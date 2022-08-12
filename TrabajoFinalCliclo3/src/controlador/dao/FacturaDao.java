/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.SumKids.Factura;

/**
 *
 * @author User
 */
public class FacturaDao extends AdaptadorDao<Factura> {

    private Factura factura;
        
        public Factura getFactura(){
            if (factura==null) {
                factura = new Factura();
                
            }
            return factura;
        }
        public void setFactura(Factura em){
            this.factura=em;
        }
        
        public FacturaDao(){
            super(Factura.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getFactura().getId_factura()!= null) {
                    modificar(this.getFactura());
                    
                }else{
                    guardar(this.getFactura());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
        
           public void guardarFactura(Object dato) throws SQLException {
            Factura fact = (Factura) dato;
        FacturaDao r = new FacturaDao();
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
          comando += "(" + variables + ") values("+r.contar()+","+fact.getId_representante()+",'"+fact.getPension()+"','"+fact.getFecha()+"','"+fact.getDetalle()+"')";
       try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en guardar " + ex);
        }
        System.out.println(comando);
        commit();
        }
}

