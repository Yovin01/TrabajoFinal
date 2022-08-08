
package controlador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author jordy
 */
public class SQLclass {
   private static final String user = "SUNKIDS";
    private static final String password = "sunkids";
    public static Connection conection;
    public SQLclass() {
    }
     

    public static Connection getConecction() {
        if(conection == null)
            conn();
        return conection;
    }    

       
     public static Connection conn(){
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
