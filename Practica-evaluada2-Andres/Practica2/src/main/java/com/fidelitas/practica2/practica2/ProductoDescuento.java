package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public class ProductoDescuento extends Producto {

    private final double descuento; // porcentaje, ej. 10, 25, 50

    public ProductoDescuento(int codigo, String nombre, double precio, int cantidadInventario, double descuento) {
        super(codigo, nombre, precio, cantidadInventario);
        if (Double.isNaN(descuento) || descuento <= 0 || descuento >= 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 1 y 99.");
        }
        this.descuento = descuento;
    }

    //solo tiene get porque el descuento es final
    public double getDescuento() {
        return this.descuento;
    }

    //polimorfismo, al precio normal se le resta el descuento
    @Override
    public double calcularPrecioFinal() {
        return getPrecio() - (getPrecio() * this.descuento / 100);
    }

    @Override
    public void mostrar() {
        System.out.println("| Tipo        : Producto con descuento");
        super.mostrar();
        System.out.println("| Descuento   : " + this.descuento + "%");
    }

}//fin clase ProductoDescuento
