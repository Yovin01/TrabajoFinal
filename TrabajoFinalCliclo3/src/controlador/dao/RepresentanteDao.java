/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
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
        public static void main(String[] args) {
       RepresentanteDao representante = new RepresentanteDao();
      ListaEnlazada<Representantes> lista = representante.listar();
      //representante.listar();
        try {
            System.out.println(lista.obtenerDato(0).getId_representante());
           // System.out.println(lista.obtenerDato(1).getGenero());
        } catch (PosicionException ex) {
            Logger.getLogger(RepresentanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
             
//      representante.getRepresentante().setId_representante(1000);
//      representante.getRepresentante().setNombres(null);
//      representante.getRepresentante().setApellidos(null);
//      representante.getRepresentante().setIdentificacion("1123121212");
//      representante.getRepresentante().setTelefono(null);
//        representante.getRepresentante().setGenero('M');
//       representante.getRepresentante().setDireccion(null);

   try{
       
  //representante.guardar(representante.getRepresentante());

       //for (int i = 0; i < lista.getSize(); i++) {
         //  System.out.println(lista.obtenerDato(0).getId_representante() + lista.obtenerDato(0).getNombres());
       //}
   }catch(Exception e){
       System.out.println("Error"+e);
   }
   
    }
}
