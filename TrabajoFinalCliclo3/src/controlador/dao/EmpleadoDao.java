/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;


import controlador.ctrlSunKidsClub.controladorGerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Catalogos;
import modelo.SumKids.Empleados;
import modelo.enums.TipoEmpleado;

/**
 *
 * @author Jordy
 * 
 */
public class EmpleadoDao extends AdaptadorDao<Empleados>{
       private Empleados empleado;
        
        public Empleados getEmpleado(){
            if (empleado==null) {
                empleado = new Empleados();
                
            }
            return empleado;
        }
        public void setEmpleado(Empleados em){
            this.empleado=em;
        }
        
        public EmpleadoDao(){
            super(Empleados.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getEmpleado().getId_empleado()!= null) {
                    modificar(this.getEmpleado());
                    
                }else{
                    guardar(this.getEmpleado());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
     
        public void guardarEmpleado(Object dato) throws Exception {
        Empleados e = (Empleados) dato;
        
            String[] columnas = super.columnas();
        String comando= "insert into Empleados ";
        String variables = "";
        String datos = "";
        //String m = "  ' ";
        System.out.println("*******************");
        
for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length-1) {
                variables += columnas[i]; //id, nombres, external_id, ...
              
            } else {    
                variables += columnas[i] + " , ";
            }
        }
    comando += " values("+super.contar()+1+",'"+e.getNombres()+"','"+e.getApellidos()+"','"+e.getIdentificacion()+"','"+e.getCelular()+"','"+e.getGenero()+"','"+e.getDireccion()+"','"+e.getCargo()+"','"+e.getCorreo()+"','"+e.getPassword()+"')" ; 
         try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "guardado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + e);
        }
         System.out.println(comando);
         commit();
         
    }
        public static void main(String[] args) throws SQLException, Exception {
//            
//          EmpleadoDao e = new EmpleadoDao();
//          Empleados m = new Empleados("Juan","marquez","222222","0987564561",'M',"colinas",TipoEmpleado.P_PRO,"WWWWW","WERWRE");
//         e.guardarEmpleado(m);
       
      }
    
}
