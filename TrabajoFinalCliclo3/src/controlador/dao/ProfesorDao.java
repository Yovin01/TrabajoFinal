/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import controlador.tda.lista.ListaEnlazada;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.SumKids.Profesores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.SumKids.Empleados;
import modelo.enums.TipoEmpleado;



/**
 *
 * @author Jordy
 * @param <T>
 */
public class ProfesorDao extends AdaptadorDao<Profesores> {
    private Profesores profesor;
        SQLclass s = new SQLclass();
     Connection con = s.getConection();
        public Profesores getProfesor(){
            if (profesor==null) {
                profesor = new Profesores();
                
            }
            return profesor;
        }
        public void setProfesor(Profesores em){
            this.profesor=em;
        }
        
        public ProfesorDao(){
            super(Profesores.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getProfesor().getId_profesor()!= null) {
                    modificar(this.getProfesor());
                    
                }else{
                    guardar(this.getProfesor());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
         
    public void guardarProfesor(Object dato) throws Exception {
       Profesores p =(Profesores) dato;
        EmpleadoDao e = new EmpleadoDao();
        String[] columnas = super.columnas();      
   String comando= "insert into Profesores";
   Empleados q = new Empleados(p.getNombres(),p.getApellidos(),p.getIdentificacion(),p.getCelular(),p.getGenero(),p.getDireccion(),TipoEmpleado.valueOf(p.getCargo()),p.getCorreo(),p.getConstraseña());
        String variables = "";
        System.out.println("*******************");
        
for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length-1) {
                variables += columnas[i]; 
            } else {    
                variables += columnas[i] + " , ";
            }
        }
   e.guardarEmpleado(q);
    comando += "(" + variables + ") values("+e.contar()+","+super.contar()+1+",'"+p.getEspecialidad()+"')";
            try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }

        System.out.println(comando);
        commit();
    }
   //    public void guardarProfesor(Object dato) throws Exception {
//        Profesores p = (Profesores) dato;
//        EmpleadoDao e = new EmpleadoDao();
//        String[] columnas = super.columnas();
//        String comando = "insert into Profesores";
//        Empleados q = new Empleados(p.getNombres(), p.getApellidos(), p.getIdentificacion(), p.getCelular(), p.getGenero(), p.getDireccion(), TipoEmpleado.valueOf(p.getCargo()), p.getCorreo(), p.getConstraseña());
//        String variables = "";
//        System.out.println("*******************");
//        for (int i = 0; i < columnas.length; i++) {
//            if (i == columnas.length - 1) {
//                variables += columnas[i];
//            } else {
//                variables += columnas[i] + " , ";
//            }
//        }
//        e.guardarEmpleado(q);
//        comando += "(" + variables + ") values(" + e.contar() + "," + super.contar() + 1 + ",'" + p.getEspecialidad() + "')";
//        try {
//            PreparedStatement stmt = getConexion().prepareStatement(comando);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error en guardar " + ex);
//        }
//
//        System.out.println(comando);
//        commit();
//    }
//
       public ListaEnlazada<Profesores> getProfesores(String atributo, Object o, Boolean m) {
        ListaEnlazada<Profesores> listaProfesores = new ListaEnlazada<>();

        String sql;
        if (m) {
            sql = "SELECT * FROM empleados,profesores where profesores.Id_empleado = empleados.Id_empleado and " + atributo + " = " + o;
            System.out.println(sql);
        } else {
            sql = "SELECT * FROM empleados,profesores where profesores.Id_empleado = empleados.Id_empleado and " + atributo + " ='" + o + "'";
            System.out.println(sql);
        }

        try {
            PreparedStatement pps = getConexion().prepareStatement(sql);
            ResultSet resultado = pps.executeQuery();
            while (resultado.next()) {
                Profesores profesor = new Profesores(resultado.getInt(10), TipoEmpleado.P_PRO, Integer.parseInt(resultado.getString(0)), resultado.getString(8), resultado.getString(2), resultado.getString(1),resultado.getString(3),resultado.getString(4) ,resultado.getString(5).charAt(0), resultado.getString(6), resultado.getString(12));
                listaProfesores.insertarCabecera(profesor);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaProfesores;
    }
    public static void main(String[] args) throws SQLException, Exception {
        ProfesorDao m = new ProfesorDao();
//        Profesores p = new Profesores("Matematicas","Juan","marquez","222222","0987564561",'M',"colinas",TipoEmpleado.P_PRO,"WWWWW","WERWRE");
//        m.guardarProfesor(p);
          Profesores p = new Profesores();
          System.out.println(m.getProfesores("Nombre", (Object)"Juan",false));
         // m.getProfesores("Nombre", (Object)"Juan",false);
    }


   
  }
