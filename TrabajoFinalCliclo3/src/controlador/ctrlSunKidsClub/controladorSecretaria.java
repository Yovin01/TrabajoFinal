/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ctrlSunKidsClub;

import controlador.conexion.SQLclass;
import controlador.dao.EmpleadoDao;
import controlador.dao.EstudianteDao;
import controlador.dao.ProfesorDao;
import controlador.dao.RepresentanteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Profesores;

/**
 *
 * @author Jordy
 */
public class controladorSecretaria {
        private ProfesorDao pro= new ProfesorDao();
        private RepresentanteDao repr = new RepresentanteDao();
        private EmpleadoDao empl = new EmpleadoDao();
         private EstudianteDao estu = new EstudianteDao();
           
}
