/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.SumKids.Representante;

/**
 *
 * @author Jordy
 */
public class RepresentanteDao extends AdaptadorDao<Representante>{
    private Representante representante;
        
        public Representante getRepresentante(){
            if (representante==null) {
                representante = new Representante();
                
            }
            return representante;
        }
        public void setRepresentante(Representante em){
            this.representante=em;
        }
        
        public RepresentanteDao(){
            super(Representante.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getRepresentante().getId_representante()!= null) {
                    modificar(this.getRepresentante());
                    
                }else{
                    guardar(this.getRepresentante());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
}
