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
    private String especialidad = null;
    private Integer id_profesore = null;
    private Integer id_empleado = null;

    public Profesores(String especialidad, String nombres, String apellidos, String identificacion, String celular, char Ge, String direccion, TipoEmpleado cargo, String correo) {
        super(nombres, apellidos, identificacion, celular, Ge, direccion, cargo, correo);
        this.especialidad = especialidad;
    }
   

    public Profesores(String especialidad) {
        this.especialidad = especialidad;          
    } 

  public Profesores(){
      
  }

    public Profesores(Integer id,TipoEmpleado cargo, Integer id_empleado, String correo,  String apellidos, String nombres, String identificacion, String celular, char gene, String direccion, String especailida) {
        super(cargo, id_empleado, correo, apellidos, nombres, identificacion, celular, gene, direccion);
          this.especialidad = especailida;
          this.id_profesore = id;
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
