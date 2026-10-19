/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public class Producto extends ProductoBase {
    

    //coustructor heredado de producto base 
    public Producto(int id, String nombre, double precio, int CantidadInventario) {
        super(id, nombre, precio, CantidadInventario);
    }

    @Override
    public double CalcularPrecioFinal() {
       return getPrecio();

        
    }
    
}
