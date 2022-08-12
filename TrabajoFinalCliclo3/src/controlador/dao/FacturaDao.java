/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
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

}

