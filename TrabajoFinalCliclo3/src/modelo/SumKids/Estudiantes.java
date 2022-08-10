/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

/**
 *
 * @author User
 */
public class Estudiantes extends Persona{
    
    private Integer id_estudiante;
    private Integer id_representante;
    private Representantes edad;
    private Double pension;
    private Profesores profesor;
    
    public Estudiantes() {
    }

    public Estudiantes(Integer id_estudiante, Integer id_representante, Representantes edad, Double pension, Profesores profesor, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(apellidos, nombres, identificacion, celular, direccion);
        this.id_estudiante = id_estudiante;
        this.id_representante = id_representante;
        this.edad = edad;
        this.pension = pension;
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

    public Representantes getEdad() {
        return edad;
    }

    public void setEdad(Representantes edad) {
        this.edad = edad;
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
