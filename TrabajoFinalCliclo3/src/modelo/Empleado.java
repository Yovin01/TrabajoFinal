/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.enums.TipoEmpleado;

/**
 *
 * @author User
 */
public class Empleado extends Persona{
    private TipoEmpleado cargo;
    private Integer id_empleado;
    
    public Empleado() {
    }

    public Empleado(TipoEmpleado cargo, Integer id_empleado, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(apellidos, nombres, identificacion, celular, direccion);
        this.cargo = cargo;
        this.id_empleado = id_empleado;
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

    
    
}
