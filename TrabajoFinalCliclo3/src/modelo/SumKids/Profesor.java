/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import modelo.SumKids.Empleado;
import modelo.enums.TipoEmpleado;

/**
 *
 * @author User
 
 */
public class Profesor extends Empleado {
    private String especialidad;
    private Integer id_profesor;
    private Integer id_empleado;
   

    public Profesor(String especialidad, Integer id_profesor, Integer id_empleado1, TipoEmpleado cargo, Integer id_empleado, String correo, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(cargo, id_empleado1, correo, apellidos, nombres, identificacion, celular, direccion);
        this.especialidad = especialidad;
        this.id_profesor = id_profesor;
        this.id_empleado = id_empleado;
    }
  public Profesor(){
      
  }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the id_profesor
     */
    public Integer getId_profesor() {
        return id_profesor;
    }

    /**
     * @param id_profesor the id_profesor to set
     */
    public void setId_profesor(Integer id_profesor) {
        this.id_profesor = id_profesor;
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
