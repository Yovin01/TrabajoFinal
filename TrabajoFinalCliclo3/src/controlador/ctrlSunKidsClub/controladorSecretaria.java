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
import controlador.tda.lista.ListaEnlazadaServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SumKids.Empleados;
import modelo.SumKids.Estudiantes;
import modelo.SumKids.Profesores;
import modelo.SumKids.Representantes;

/**
 *
 * @author Jordy
 */
public class controladorSecretaria {
    
    
    private ProfesorDao pro = new ProfesorDao();
    private RepresentanteDao repr = new RepresentanteDao();
    private EmpleadoDao empl = new EmpleadoDao();
    private EstudianteDao estu = new EstudianteDao();
    
    public Profesores getProfesores(){
        return pro.getProfesor();
    }
    
    public Representantes getRepresentantes(){
        return repr.getRepresentante();
    }
    
    public Empleados getEmpleados(){
        return empl.getEmpleado();
    }
    
    public Estudiantes getEstudiantes(){
        return estu.getEstudiante();
    }
    
    public void guardarProfesor(Profesores profesor) throws Exception {
       pro.guardarProfesor(profesor);
    }

    public void guardarRepresentante(Representantes representante) throws Exception {
       repr.guardarRepresentante(representante);
    }
    public void guardarEmpleado(Empleados empleado) throws Exception {
       empl.guardarEmpleado(empleado);
    }
    public void guardarEstudiante(Estudiantes estudiante) throws Exception {
       estu.guardarEstudiante(estudiante);
    }
    
}
