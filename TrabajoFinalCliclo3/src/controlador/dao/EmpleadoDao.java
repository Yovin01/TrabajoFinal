/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.SumKids.Empleados;

/**
 *
 * @author Jordy
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
         public DefaultTableModel getTableEmpleados() {
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
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;
    }
}
