/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author User
 */
public class Estudiantes extends Persona{
    
    private Integer id_estudiante=null;
    private Integer id_representante=null;
    private Calendar fechaNacimiento=null;
    private Double pension=null;
    private Profesores profesor=null;
      
    public Estudiantes() {
    }

    public Estudiantes(Integer id_estudiante, Integer id_representante, Calendar fecha, Profesores profesor, String apellidos, String nombres, String identificacion, char sexo, String direccion) {
        super(apellidos, nombres, identificacion, sexo, direccion);
        this.id_estudiante = id_estudiante;
        this.id_representante = id_representante;
        this.fechaNacimiento=fecha;
        this.profesor = profesor;
    }
     
  

    public Integer getId_representante() {
        return id_representante;
    }

    public void setId_representante(Integer id_representante) {
        this.id_representante = id_representante;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Integer getRepresentante() {
        return id_representante;
    }

    public void setRepresentante(Integer representante) {
        this.id_representante = representante;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    
}
