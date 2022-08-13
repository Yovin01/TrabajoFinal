/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import java.util.Calendar;
import java.util.Date;
import modelo.enums.estadoMatricula;

/**
 *
 * @author User
 */
public class Estudiantes extends Persona{
    
    private Integer id_estudiante=null;
    private Integer id_representante=null;
    private Calendar fechaNacimiento=null;
    private Double pension=null;
    private Integer id_profesor=null;
    private estadoMatricula estado =estadoMatricula.espera;
    
    public Estudiantes() {
    }
//contructor de la base de datos
    public Estudiantes(Integer id_estudiante, Integer id_representante, Calendar fecha, Integer id_profesor, String apellidos, String nombres, String identificacion, char sexo, String direccion,estadoMatricula estado) {
        super(apellidos, nombres, identificacion, sexo, direccion);
        this.id_estudiante = id_estudiante;
        this.id_representante = id_representante;
        this.fechaNacimiento=fecha;
        this.id_profesor=id_profesor;
        this.estado=estado;
        
    }
    //constructor normal
       public Estudiantes( Calendar fecha,Integer id_representante,Integer id_profesor, String apellidos, String nombres, String identificacion, char sexo, String direccion) {
        super(apellidos, nombres, identificacion, sexo, direccion);
        this.fechaNacimiento=fecha; 
        this.id_representante = id_representante;
        this.id_profesor = id_profesor;
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

    public Integer getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Integer id_profesor) {
        this.id_profesor = id_profesor;
    }

    public estadoMatricula getEstado() {
        return estado;
    }

    public void setEstado(estadoMatricula estado) {
        this.estado = estado;
    }

    
}
