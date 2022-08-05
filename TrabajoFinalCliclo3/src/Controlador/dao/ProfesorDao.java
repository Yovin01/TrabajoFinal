/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.SumKids.Profesor;




/**
 *
 * @author Jordy
 */
public class ProfesorDao extends AdaptadorDao<Profesor>{
    private Profesor profesor;
        
        public Profesor getProfesor(){
            if (profesor==null) {
                profesor = new Profesor();
                
            }
            return profesor;
        }
        public void setProfesor(Profesor em){
            this.profesor=em;
        }
        
        public ProfesorDao(){
            super(Profesor.class);
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
}
