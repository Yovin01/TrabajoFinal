/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.SumKids.Profesores;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.SumKids.Representantes;
import controlador.dao.InterfazDao;
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
  
         public DefaultTableModel getTableProfesores() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        modelo.addColumn("Clave");
        String slq = "SELECT * From Empleados";
        String datos[] = new String[5];
        Statement st;
        try {
            st = SQLclass.getConection().createStatement();
            ResultSet rs = st.executeQuery(slq);
            int i = 1;
            while (rs.next()) {
                datos[0] = ("" + i);
                PreparedStatement pps = SQLclass.getConection().prepareStatement("UPDATE persona SET IDPersona=' " + i + "'WHERE Nombre='" + rs.getString(2) + "'");
                pps.executeUpdate();
                i++;
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }

        return modelo;
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
    
    public static void main(String[] args) throws SQLException, Exception {
        ProfesorDao m = new ProfesorDao();
        Profesores p = new Profesores("Matematicas","Juan","marquez","222222","0987564561",'M',"colinas",TipoEmpleado.P_PRO,"WWWWW","WERWRE");
        m.guardarProfesor(p);
    }


   
  }
