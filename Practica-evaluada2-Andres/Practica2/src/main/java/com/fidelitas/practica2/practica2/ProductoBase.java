/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public abstract class ProductoBase {
    //clase abstrata 
    //atributos que van a tener en comun 
    private int id;//codigo de barras 
    private String nombre;//nombre del producto 
    private double precio;
    private int CantidadInventario;
    
    //construcor 

    public ProductoBase(int id, String nombre, double precio, int CantidadInventario) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.CantidadInventario = CantidadInventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadInventario() {
        return CantidadInventario;
    }

    public void setCantidadInventario(int CantidadInventario) {
        this.CantidadInventario = CantidadInventario;
    }
    
    public abstract double CalcularPrecioFinal();//metodo abstratcto para el polimorfismo 
    
}
