/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.SumKids.Estudiantes;

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

}
