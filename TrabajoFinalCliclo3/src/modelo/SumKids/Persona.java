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

    private String apellidos=null;
    private String nombres=null;
    private String identificacion=null;
    private String celular=null;
    private char genero;
    private String direccion=null;
   
    public Persona() {
    }
  public Persona(String ide) {
      this.identificacion= ide;
    }

    public char getGenero() {
        return genero;
    }

    

    public void setGenero(char genero) {
        this.genero = genero;
    }
  
    public Persona(String apellidos, String nombres, String identificacion, String celular,char gene, String direccion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.celular = celular;
 this.genero = gene;
        this.direccion = direccion;
    }

    public Persona(String apellidos, String nombres, String identificacion, char genero, String direccion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.genero = genero;
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
