/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import java.sql.PreparedStatement;
import java.util.Date;
import modelo.SumKids.Estudiantes;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Jordy
 */
public class EstudianteDao extends AdaptadorDao<Estudiantes>{
          private Estudiantes estudiante;
        
        public Estudiantes getEstudiante(){
            if (estudiante==null) {
                estudiante = new Estudiantes();
                
            }
            return estudiante;
        }
        public void setEstudiante(Estudiantes em){
            this.estudiante=em;
        }
        
        public EstudianteDao(){
            super(Estudiantes.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getEstudiante().getId_estudiante()!= null) {
                    modificar(this.getEstudiante());
                    
                }else{
                    guardar(this.getEstudiante());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
        public void guardarEstudiante(Object dato) throws Exception {
       Estudiantes p =(Estudiantes) dato;
        String[] columnas = super.columnas();      
   String comando= "insert into Estudiantes";
       String variables = "";
        System.out.println("*******************");
        
        String fecha = p.getFechaNacimiento().get(Calendar.DATE)+"/"+ p.getFechaNacimiento().get(Calendar.MONTH)+"/"+ p.getFechaNacimiento().get(Calendar.YEAR);
        
for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length-1) {
                variables += columnas[i]; 
            } else {    
                variables += columnas[i] + " , ";
            }
        }
    comando += "(" + variables + ") values("+super.contar()+1+","+p.getId_representante()+","+p.getId_profesor()+", to_date('"+fecha+"','DD/MM/YYYY'), '"+p.getNombres()+"','"+p.getApellidos()+"','"+p.getIdentificacion()+"','"+p.getGenero()+"','"+p.getDireccion()+"')";
            
    try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "guardado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }

        System.out.println(comando);
        commit();
    }
     
    public static void main(String[] args) throws Exception {
     //    Date d = new Date();
      //   Calendar r =Calendar.getInstance();
        // r.set(2016,10,1);
//         DD/MON/YY
          //EstudianteDao e = new EstudianteDao();
       //   Estudiantes w= new Estudiantes();
        //System.out.println( new SimpleDateFormat("dd/MM/YYYY").format(r.getTime()));
          //e.guardarEstudiante(w);
       //  System.out.println(r.get(Calendar.MONTH));
         
         EstudianteDao m = new EstudianteDao();
         Calendar fecha=Calendar.getInstance();
        
        
         fecha.set(2016,10,1);
         //Calendar fecha, Integer id_profesor, ,String apellidos, String nombres, String identificacion, char sexo, String direccion
         Estudiantes e = new Estudiantes(fecha,8,1,"Angamarca","Brayan","1212121212",'M',"salinassssssss");
         m.guardarEstudiante(e);
    }
}
