/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ctrlSunKidsClub;

import controlador.conexion.SQLclass;
import controlador.dao.AdaptadorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Catalogos;
import modelo.SumKids.Estudiantes;
import modelo.SumKids.Gerente;
import modelo.SumKids.Profesores;
import modelo.SumKids.Representantes;
import modelo.enums.estadoMatricula;

/**
 *
 * @author Jose Yangari
 */
public class controladorGerente extends AdaptadorDao<Gerente> {

    private AdaptadorDao relacion = new AdaptadorDao();
    private Gerente gerente;

    public controladorGerente() {
        super(Gerente.class);
    }

    public Gerente getGerente() {
        if (gerente == null) {
            gerente = new Gerente();
        }
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public void AsignarDocente(Integer id_Pof, Integer id_est) throws SQLException {
        String comando = "insert into est_prof values (";
        String contar = "select count(id_est_prof) from est_prof";
        PreparedStatement stmt = getConexion().prepareStatement(contar);

        ResultSet re = stmt.executeQuery();
        Integer a = 0;
        while (re.next()) {
            a = (Integer) re.getInt(1);
        }
<<<<<<< HEAD

=======
>>>>>>> 864d4ad234987476f04eb17ab89fd41b9dc376a5
        PreparedStatement stmt2 = getConexion().prepareStatement(comando + (a + 1) + "," + id_est + "," + id_Pof);
        stmt2.executeUpdate();
        JOptionPane.showMessageDialog(null, "asignado correctamente");
    }

    public void crearCatalogo(Object dato) throws SQLException {
        Catalogos cat = (Catalogos) dato;
        String comando = "insert into catalogos values (";
        String count = "select count(id_catalogo) from catalogos";
        PreparedStatement stm1 = getConexion().prepareStatement(count);
        ResultSet re = stm1.executeQuery();
        Integer a = 0;
        while (re.next()) {
            a = (Integer) re.getInt(1);
        }
        try {
            PreparedStatement stmt2 = getConexion().prepareStatement(comando + (a + 1) + "," + cat.getPrecio() + "," + cat.getDias() + ",'" + cat.getMateria() + "')");
            stmt2.executeUpdate();
          JOptionPane.showMessageDialog(null, "guardado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }
        commit();
    }

<<<<<<< HEAD
=======
    public static void main(String[] args) throws SQLException {
        controladorGerente c = new controladorGerente();
        // precio//
        //Catalogos ca = new Catalogos(0,70,20,"Matematicas");
        Catalogos ca = new Catalogos(0, 70, 20, "Matematicas");
        c.crearCatalogo(ca);
    }
>>>>>>> 864d4ad234987476f04eb17ab89fd41b9dc376a5
}
