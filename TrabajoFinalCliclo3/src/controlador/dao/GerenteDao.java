/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.conexion.SQLclass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Estudiantes;
import modelo.SumKids.Gerente;
import modelo.SumKids.Profesores;
import modelo.enums.estadoMatricula;

/**
 *
 * @author Jordy
 */
public class GerenteDao  extends AdaptadorDao<Gerente>{
   SQLclass sql = new SQLclass();
   Connection Co = sql.getConection();
    private Gerente gerente;
   
   public GerenteDao(){
            super(Gerente.class);
        }
    public Gerente getGerente(){
            if (gerente==null) {
               gerente = new Gerente();
            }
            return gerente;
        }
   
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
   public void AsignarDocente(){
       Estudiantes e = new Estudiantes();
     
   }
     public Boolean guardarModificar(){
            try{
                if (this.getGerente().getId_empleado()!= null) {
                    modificar(this.getGerente());
                }else{
                    guardar(this.getGerente());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
        public void contratar(Profesores v) {
        try {
            PreparedStatement PS = Co.prepareStatement("INSERT INTO PROFESORES(ID_PROFESOR,ID_EMPLEADO,ESPECIALIDAD) VALUES (?,?,?)");
            PS.setInt(1, v.getId_profesor());
            PS.setInt(2, v.getId_empleado());
            PS.setString(3, v.getEspecialidad());
            PS.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profesor agregado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Datos erroneos");
        }
    }
}
