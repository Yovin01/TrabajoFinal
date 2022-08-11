/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo.SumKids;

import modelo.enums.TipoEmpleado;

/**
 *
 * @author Jordy torres
 */
public class Gerente extends Empleados{

    public Gerente(TipoEmpleado cargo, Integer id_empleado, String correo, String constraseña, String apellidos, String nombres, String identificacion, String celular, String direccion) {
        super(cargo, id_empleado, correo, constraseña, apellidos, nombres, identificacion, celular, direccion);
    }
    
    
    public Gerente(){
        
    }
}
