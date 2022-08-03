/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import modelo.SumKids.Persona;

/**
 *
 * @author User
 */
public class Representante extends Persona {

    private String correo;
    private Integer id_representante;

    public Representante() {
    }

    public Representante(String correo, String celular) {
        this.correo = correo;
    }

    public Integer getId_representante() {
        return id_representante;
    }

    public void setId_representante(Integer id_representante) {
        this.id_representante = id_representante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
