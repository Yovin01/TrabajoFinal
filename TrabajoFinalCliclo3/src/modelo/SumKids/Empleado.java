/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import modelo.enums.TipoEmpleado;

/**
 *
 * @author User
 */
public class Empleado extends Persona {

    private TipoEmpleado cargo;
    private Integer id_empleado;
    private String correo;

    public Empleado(TipoEmpleado cargo, Integer id_empleado, String correo, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(apellidos, nombres, identificacion, celular, direccion);
        this.cargo = cargo;
        this.id_empleado = id_empleado;
        this.correo = correo;
    }
   public Empleado(){
       
   }
    public TipoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(TipoEmpleado cargo) {
        this.cargo = cargo;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
