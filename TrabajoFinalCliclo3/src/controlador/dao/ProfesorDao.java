/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.SumKids.Profesores;




/**
 *
 * @author Jordy
 */
public class ProfesorDao extends AdaptadorDao<Profesores>{
    private Profesores profesor;
        
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
              public static void main(String[] args) {
       ProfesorDao profesores = new ProfesorDao();
         ListaEnlazada<Profesores> lista = profesores.listar();
       profesores.getProfesor().setId_profesor(0);
       profesores.getProfesor().setId_empleado(0);
        profesores.getProfesor().setEspecialidad("ccccc");   
        
   try{
  profesores.guardar(profesores.getProfesor());

       //for (int i = 0; i < lista.getSize(); i++) {
         //  System.out.println(lista.obtenerDato(0).getId_representante() + lista.obtenerDato(0).getNombres());
       //}
   }catch(Exception e){
       System.out.println("Error"+e);
   }
   
    }
}
