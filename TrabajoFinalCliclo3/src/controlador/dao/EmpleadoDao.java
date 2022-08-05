/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.SumKids.Empleado;

/**
 *
 * @author Jordy
 */
public class EmpleadoDao extends AdaptadorDao<Empleado>{
        private Empleado empleado;
        
        public Empleado getEmpleado(){
            if (empleado==null) {
                empleado = new Empleado();
                
            }
            return empleado;
        }
        public void setEmpleado(Empleado em){
            this.empleado=em;
        }
        
        public EmpleadoDao(){
            super(Empleado.class);
        }
        public Boolean guardarModificar(){
            try{
                if (this.getEmpleado().getId_empleado()!= null) {
                    modificar(this.getEmpleado());
                    
                }else{
                    guardar(this.getEmpleado());
                }
                return true;
            }catch(Exception e){
                System.out.println("Error"+e);
                return false;
            }
        }
        
}
