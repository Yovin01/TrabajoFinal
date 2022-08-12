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
   String comando= "insert into Profesores";
       String variables = "";
        System.out.println("*******************");
        
for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length-1) {
                variables += columnas[i]; 
            } else {    
                variables += columnas[i] + " , ";
            }
        }
    comando += "(" + variables + ") values("+super.contar()+1+","+p.getId_representante()+"','"+p.getFechaNacimiento()+"',"+p.getProfesor().getId_profesor()+",'"+p.getApellidos()+"','"+p.getNombres()+"','"+p.getGenero()+"','"+p.getDireccion()+"')";
            
    try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }

        System.out.println(comando);
        commit();
    }
    public static void main(String[] args) {
         Date d = new Date();
         Calendar r =Calendar.getInstance();
         r.set(2016,10,1);
         d.;
         System.out.println(d);
         System.out.println(d.getTime());
//         mm-dd-yyyy
//         24-May-2005
                 
         //String fecha = r.get(Calendar.YEAR)
         System.out.println(r.get(Calendar.MONTH));
         
    }
}
