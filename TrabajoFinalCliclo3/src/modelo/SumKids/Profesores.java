/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import modelo.SumKids.Empleados;
import modelo.enums.TipoEmpleado;

/**
 *
 * @author User
 
 */
public class Profesores extends Empleados {
    private String especialidad;
    private Integer id_profesore;
    private Integer id_empleado;

    public Profesores(String especialidad, String nombres, String apellidos, String identificacion, String celular, char Ge, String direccion, TipoEmpleado cargo, String correo, String constraseña) {
        super(nombres, apellidos, identificacion, celular, Ge, direccion, cargo, correo, constraseña);
        this.especialidad = especialidad;
    }
   

    public Profesores(String especialidad) {
        this.especialidad = especialidad;          
    }

  public Profesores(){
      
  }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the id_profesore
     */
    public Integer getId_profesor() {
        return id_profesore;
    }

    /**
     * @param id_profesor the id_profesore to set
     */
    public void setId_profesor(Integer id_profesor) {
        this.id_profesore = id_profesor;
    }

    /**
     * @return the id_empleado
     */
    public Integer getId_empleado() {
        return id_empleado;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

}
