/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

/**
 *
 * @author Jordy
 */
public class Catalogos {
     private Integer id_catalogo;
    private Integer dias_Semana;
    private Integer precio;
   private String materia;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
   
    public Catalogos(Integer id_catalogo, Integer precio, Integer dias,String materia) {
        this.id_catalogo = id_catalogo;
        this.dias_Semana = dias;
        this.precio = precio;
        this.materia=materia;
    }
   public Catalogos(){
       
   }
    public Integer getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(Integer id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    public Integer getDias() {
        return dias_Semana;
    }

    public void setDias(Integer dias) {
        this.dias_Semana = dias;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
}
