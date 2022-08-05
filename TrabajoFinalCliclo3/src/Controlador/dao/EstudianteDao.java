/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.SumKids.Estudiante;

/**
 *
 * @author Jordy
 */
public class EstudianteDao extends AdaptadorDao<Estudiante>{
          private Estudiante estudiante;
        
        public Estudiante getEstudiante(){
            if (estudiante==null) {
                estudiante = new Estudiante();
                
            }
            return estudiante;
        }
        public void setEstudiante(Estudiante em){
            this.estudiante=em;
        }
        
        public EstudianteDao(){
            super(Estudiante.class);
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
