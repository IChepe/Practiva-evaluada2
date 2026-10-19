package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public abstract class ProductoBase {

    //metodo abstracto, cada subclase calcula el precio final con su propia logica
    public abstract double calcularPrecioFinal();

    //metodo abstracto, cada subclase calcula cuanto se paga por varias unidades
    public abstract double calcularSubtotal(int cantidad);

    //metodo abstracto, cada subclase muestra sus datos
    public abstract void mostrar();

}//fin clase ProductoBase
