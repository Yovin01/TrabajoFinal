/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

/**
 *
 * @author User
 */
public class Estudiante extends Persona{
    
    private Integer id_estudiante;
    private Integer id_representante;
    private Representante edad;
    private Double pension;
    private Profesor profesor;
    
    public Estudiante() {
    }

    public Estudiante(Integer id_estudiante, Integer id_representante, Representante edad, Double pension, Profesor profesor, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(apellidos, nombres, identificacion, celular, direccion);
        this.id_estudiante = id_estudiante;
        this.id_representante = id_representante;
        this.edad = edad;
        this.pension = pension;
        this.profesor = profesor;
    }

    public Integer getRepresentante() {
        return id_representante;
    }

    public void setRepresentante(Integer representante) {
        this.id_representante = representante;
    }

    public Representante getEdad() {
        return edad;
    }

    public void setEdad(Representante edad) {
        this.edad = edad;
    }

    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
