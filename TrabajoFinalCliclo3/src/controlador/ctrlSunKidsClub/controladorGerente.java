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
import modelo.SumKids.Estudiantes;
import modelo.SumKids.Gerente;
import modelo.SumKids.Profesores;
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
        PreparedStatement stmt2 = getConexion().prepareStatement(comando + (a + 1) + "," + id_est + "," + id_Pof);
        stmt2.executeUpdate();
    }

    public Boolean guardarModificar() {
        try {
            if (this.getGerente().getId_empleado() != null) {
                modificar(this.getGerente());
            } else {
                guardar(this.getGerente());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }

}
