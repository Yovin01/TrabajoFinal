<<<<<<< HEAD
package Controlador.Conexion;
=======
package controlador.conexion;
>>>>>>> de13da8fab3f89909930f5209f2c3d7d923984d9

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author jordy
 */
public class SQLclass {
   private static final String user = "SUNKIDS";
    private static final String password = "sunkids";
    
<<<<<<< HEAD
    public SQLclass() {
    }
     
    public Connection conn(){
        
=======
   public static Connection conecction;
public SQLclass() {
    }
    public static Connection getConecction() {
        if(conecction == null)
            conn();
        return conecction;
    }    
       
     public static Connection conn(){
>>>>>>> de13da8fab3f89909930f5209f2c3d7d923984d9
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando a la base de datos.....");
          Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", user,password);  
            System.out.println("CONEXION EXITOSA");
            return connection;
        } catch (Exception e) {
            System.out.println("Fallo de conexion error!: "+e);
            return null;
        }
    }
}
