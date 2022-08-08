/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.conexion;

import controlador.dao.AdaptadorDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordy
 */
public class OracleTest {

      public static void main(String[] args) {         
               SQLclass s = new SQLclass();
               s.conn();
               
      } 
     
}
            
        
        
