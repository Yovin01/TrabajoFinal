package controlador.autorizacion;

import static com.itextpdf.kernel.pdf.PdfName.r;
import controlador.tda.lista.ListaEnlazada;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.SumKids.Empleados;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Yovin
 */
public class verificarPassword {

    // Creating a private instance
    // of Scanner class
    //   private static Scanner sc;
    // BCrypt is a password Hashing
    // Function based on Blowfish
    // Algorithm.
    public String Password_Hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verifying password with the
    // hashed password.
    public boolean Verify_Password(String dbCotra ,String password, String hashed_password) {
        try {    
                    if (BCrypt.checkpw(password, dbCotra)) {
                        return true;
                    } 
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
//    public static void main(
//            String args[]) throws Exception {
//
//        // Scanner class instance connected
//        // to the Input Stream(System.in)
//        sc = new Scanner(System.in);
//
//        System.out.println( "Enter the password: ");
//
//        // Scanner class instance
//        // reading the user input
//        String p = sc.nextLine();
//
//        // Generate hashed password
//        String passwordHash = Password_Hash(p);
//
//        // Print Hashed Password
//        System.out.println(   "Hashed-password: " + passwordHash);
//
//        // Printing the result of verification
//        // of hashed password
//        // with original password
//        System.out.println( "Verification: " + Verify_Password(  p, passwordHash));
//    }
    
    public void a(Calendar r){
       
    }
    
    public static void main(String[] args) {
         Date d = new Date();
         Calendar r =Calendar.getInstance();
         r.set(2016,10,1);
        
     new SimpleDateFormat("MM").format(r.getTime());
}}
