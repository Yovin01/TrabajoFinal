/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Integer;

/**
 *
 * @author sebastian
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    private Connection conexion;
    private Class clazz;
    private String contar = "select count(id_";
    private String ALL = "select * from ";
    private String ALL_ID = "select * from";

    public Integer contar() throws SQLException {
        String m = clazz.getSimpleName().toLowerCase();
        m = m.substring(0, m.length() - 1) + m.substring(m.length());
        //System.out.println(m);
        PreparedStatement stmt = getConexion().prepareStatement(contar + m + " ) from " + clazz.getSimpleName().toLowerCase());

        ResultSet re = stmt.executeQuery();
        Integer a = 0;
        while (re.next()) {
            a = (Integer) re.getInt(1);
        }
        if (a == null) {
            a = 0;
        }
        return a;
    }

    public ListaEnlazada objetenerDato(String atributo, Object o, Boolean m) throws SQLException {
        String comando;
        ListaEnlazada lista = new ListaEnlazada();
        if (m) {
            comando = "select " + atributo + " from " + clazz.getSimpleName().toLowerCase() + " where " + atributo + " = " + o.toString();
            System.out.println(comando);
        } else {
            comando = "select " + atributo + " from " + clazz.getSimpleName().toLowerCase() + " where " + atributo + " = '" + o.toString() + "'";
            System.out.println(comando);
        }
        PreparedStatement stmt = getConexion().prepareStatement(comando);
        ResultSet re = stmt.executeQuery();
        int contador = 0;
        while (re.next()) {
            lista.insertarCabecera(re.getString(contador));
            contador++;
        }
        return lista;
    }

    public void commit() throws SQLException {
        PreparedStatement stmt = getConexion().prepareStatement("commit");
        stmt.executeQuery();
    }

    public AdaptadorDao(Class clazz) {
        this.clazz = clazz;
        this.conexion = SQLclass.getConection();
        ALL += clazz.getSimpleName().toLowerCase();
        ALL_ID += clazz.getSimpleName().toLowerCase() + " where id =";
    }

    public AdaptadorDao() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public Class getClazz() {
        return clazz;
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            String seleccion = "select * from " + clazz.getSimpleName().toLowerCase();
            PreparedStatement stmt = getConexion().prepareStatement(seleccion);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }

            while (resultSet.next()) {
                T obj = (T) clazz.getConstructor().newInstance();
                for (int i = 0; i < columna.length; i++) {
                    Object objeto = resultSet.getObject(i + 1);
                    System.out.println("nuevo" + "\n" + "\t" + columna[i] + "\n" + objeto.toString() + "\t");
                    if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                        java.sql.Timestamp aux = (java.sql.Timestamp) objeto;
                        java.util.Date fecha = new Date(aux.getTime());
                        Utilidades.cambiarDatos(fecha, columna[i], obj);
                    } else {
                        Utilidades.cambiarDatos(objeto, columna[i], obj);
                    }
                }
                lista.insertarCabecera(obj);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar " + e);
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void guardar(T dato) throws Exception {
        String[] columnas = columnas();
        String comando = "insert into " + clazz.getSimpleName().toLowerCase() + " ";
        String variables = "";
        String datos = "";
        //String m = "  ' ";
        System.out.println("*******************");
        System.out.println(tipoDato(columnas[1], dato));
        System.out.println(tipoDato(columnas[0], dato));
        System.out.println(tipoDato(columnas[2], dato));
        for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length - 1) {
                variables += columnas[i]; //id, nombres, external_id, ...
                System.out.println(variables);
                datos += tipoDato(columnas[i], dato);//0, "casa", "343-545
                System.out.println();
            } else {
                System.out.println(datos);
                variables += columnas[i] + " , ";
                datos += tipoDato(columnas[i], dato) + ",";
            }
        }

        comando += "(" + variables + ") values(" + datos + ")";
        try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        System.out.println(comando);
        commit();
    }

    public void modificar(String atributo, Integer id, String valor) throws Exception {

        //objeto a modificar ya lo envian desde el metodo
        //reemplazar por valores nuevos
        //enviar el comando
        String[] columnas = columnas();
        String comando = "update  " + clazz.getSimpleName().toLowerCase() + " SET ";
        //String variables = "";
        String m = clazz.getSimpleName().toLowerCase();
        m = m.substring(0, m.length() - 1) + m.substring(m.length());
        comando += atributo + "=" + valor + " where " + m + " = " + id.toString();
        try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        System.out.println(comando);
        commit();
    }

    @Override
    public T obtener(Integer id) throws Exception {
        T obj = null;
        String[] columna = columnas();
        String m = clazz.getSimpleName().toLowerCase();
        m = m.substring(0, m.length() - 1) + m.substring(m.length());
        System.out.println(m);
        PreparedStatement stmt = getConexion().prepareStatement(" select * from " + clazz.getSimpleName().toLowerCase() + " where id_" + m + " = " + id.toString());
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            obj = (T) clazz.getConstructor().newInstance();
            for (int i = 0; i < columna.length; i++) {
                Object objeto = resultSet.getObject(i + 1);
                System.out.println("** " + objeto + columna[i]);
                if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                    java.sql.Timestamp aux = (java.sql.Timestamp) objeto;
                    java.util.Date fecha = new Date(aux.getTime());
                    Utilidades.cambiarDatos(fecha, columna[i], obj);
                } else {
                    Utilidades.cambiarDatos(objeto, columna[i], obj);
                }
            }
        }
        return obj;
    }

    public String[] columnas() {
        String[] columna = null;
        try {
            String seleccion = "select * from " + clazz.getSimpleName().toLowerCase();
            PreparedStatement stmt = getConexion().prepareStatement(seleccion);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }
        } catch (Exception ex) {

        }
        return columna;
    }

    private Object tipoDato(String name, T objeto) {
        String aux = "";
        try {
            Field field = Utilidades.getField(name, clazz);
            char[] arr = name.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            Method method = getMethod("get" + new String(arr), clazz);
            Object dato = method.invoke(objeto);

            if (field.getType().getSimpleName().equals("Date")) {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                aux = (dato != null) ? "\"" + formato.format((Date) dato) + "\"" : "null";
            } else if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                aux = (dato != null) ? dato.toString() : "0";
            } else if (field.getType().getSimpleName().equals("Boolean")) {
                aux = (dato != null) ? dato.toString() : Boolean.FALSE.toString();
            } else {
                aux = (dato != null) ? "\"" + dato + "\"" : "null";
            }
        } catch (Exception e) {
            System.out.println("xxxx " + e);

        }

        return aux;
    }

    @Override
    public void modificar(T dato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
