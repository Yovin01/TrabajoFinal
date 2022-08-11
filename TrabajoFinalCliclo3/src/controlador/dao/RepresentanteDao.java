/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.SumKids.Representantes;

/**
 *
 * @author Jordy
 */
public class RepresentanteDao extends AdaptadorDao<Representantes>{
    private Representantes representante;
        
        public Representantes getRepresentante(){
            if (representante==null) {
                representante = new Representantes();
                
            }
            return representante;
        }
        public void setRepresentante(Representantes em){
            this.representante=em;
        }
        
        public RepresentanteDao(){
            super(Representantes.class);
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
        public static void main(String[] args) throws SQLException {
      RepresentanteDao r = new RepresentanteDao();
           
      
    // ListaEnlazada<Representantes> lista = representante.listar();
  
      
    }
}
