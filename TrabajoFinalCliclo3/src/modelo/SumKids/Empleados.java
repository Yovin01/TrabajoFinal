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
public class Empleados extends Persona {

    private TipoEmpleado cargo;
    private Integer id_empleado;
    private String correo;
    private String password;

    public Empleados(TipoEmpleado cargo, Integer id_empleado, String correo, String constraseña) {
        this.cargo = cargo;
        this.id_empleado = id_empleado;
        this.correo = correo;
        this.password = constraseña;
    }

    public Empleados(TipoEmpleado cargo, Integer id_empleado, String correo, String password, String apellidos, String nombres, String identificacion, String celular, char gene, String direccion) {
        super(apellidos, nombres, identificacion, celular, gene, direccion);
        this.cargo = cargo;
        this.id_empleado = id_empleado;
        this.correo = correo;
        this.password = password;
    }
       public Empleados(TipoEmpleado cargo, Integer id_empleado, String correo, String apellidos, String nombres, String identificacion, String celular, char gene, String direccion) {
        super(apellidos, nombres, identificacion, celular, gene, direccion);
        this.cargo = cargo;
        this.id_empleado = id_empleado;
        this.correo = correo;
    }
           public Empleados(String nombres ,  String apellidos  ,   String identificacion,  String celular,char Ge , String direccion ,TipoEmpleado cargo, String correo) {
        super(apellidos, nombres, identificacion,celular, Ge,direccion);
        this.cargo = cargo;
        this.correo = correo;
    }               
    public Empleados(String nombres ,  String apellidos  ,   String identificacion,  String celular,char Ge , String direccion ,TipoEmpleado cargo, String correo, String constraseña) {
        super(apellidos, nombres, identificacion,celular, Ge,direccion);
        this.cargo = cargo;
        this.correo = correo;
        this.password = constraseña;
    }

    public String getConstraseña() {
        return password;
    }

    public void setConstraseña(String constraseña) {
        this.password = constraseña;
    }
    
   public Empleados(){
       
   }
    public String getCargo() {
        return cargo.toString();
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
