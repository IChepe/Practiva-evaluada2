/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri
 */
public class ProductoDescuento extends ProductoBase{
    private final double Descuento;//atribito final que no sea modificado 
    
    public ProductoDescuento(int id, String nombre, double precio, int CantidadInventario,double Descuento) {
        super(id, nombre, precio, CantidadInventario);
        this.Descuento=Descuento;
    }
    //solo el get para evitar que sea modificacdo el descuento 

    public double getDescuento() {
        return Descuento;
    }

    @Override
    public double CalcularPrecioFinal() {
        return getPrecio() - (getPrecio() * Descuento / 100);
    }
    
    
    
    
}
