/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import controlador.tda.lista.ListaEnlazada;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.SumKids.Profesores;
import java.sql.PreparedStatement;




/**
 *
 * @author Jordy
 */
public class ProfesorDao extends AdaptadorDao<Profesores>{
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
  }
