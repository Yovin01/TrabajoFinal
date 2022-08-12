/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.SumKids;

import java.util.Date;

/**
 *
 * @author User
 */
public class Factura {

    private Integer id_factura=null;
    private Integer id_representante=null;
    private Double pension=null;
    private Date fecha=null;
    private String nombre=null;
    private String apellido=null;
    private String direccion=null;
    private String identificacion=null;
    private String celular=null;
    private String detalle=null;

    public Factura() {
    }

    public Factura(Integer nro, Integer id_representante, Double pension, Date fecha, String nombre, String apellido, String direccion, String identificacion, String celular, String detalle) {
        this.id_factura = nro;
        this.id_representante = id_representante;
        this.pension = pension;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.celular = celular;
        this.detalle = detalle;
    }

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer nro) {
        this.id_factura = nro;
    }

    public Integer getId_representante() {
        return id_representante;
    }

    public void setId_representante(Integer id_representante) {
        this.id_representante = id_representante;
    }

    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
