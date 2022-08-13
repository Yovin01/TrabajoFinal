/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
       
        public void guardarRepresentante(Object dato) throws SQLException{
            Representantes Repre = (Representantes) dato;
        String[] columnas = super.columnas();      
   String comando= "insert into Representantes";
        String variables = "";
        System.out.println("*******************");
for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length-1) {
                variables += columnas[i]; 
              
            } else {    
                variables += columnas[i] + " , ";
            }
        }

    comando += "(" + variables + ") values('"+Repre.getCorreo()+"','"+Repre.getApellidos()+"','"+Repre.getNombres()+"','"+Repre.getIdentificacion()+"','"+Repre.getCelular()+"','"+Repre.getGenero()+"','"+Repre.getDireccion()+"');";
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
       
}
