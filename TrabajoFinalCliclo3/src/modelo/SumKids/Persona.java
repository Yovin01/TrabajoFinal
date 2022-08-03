/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

/**
 *
 * @author User
 */
public class Persona {

    private String apellidos;
    private String nombres;
    private String identificacion;
    private String celular;
        private char sexo;
    private String direccion;

    public Persona() {
    }

    public Persona(String apellidos, String nombres, String identificacion, String celular, String direccion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.celular = celular;
        this.direccion = direccion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
