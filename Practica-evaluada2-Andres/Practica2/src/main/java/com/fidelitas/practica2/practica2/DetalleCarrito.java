package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public class DetalleCarrito {

    private Producto producto;
    private int cantidad;
    private double subtotal;

    //constructor vacio
    public DetalleCarrito() {
    }

    //constructor con todos los atributos
    public DetalleCarrito(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    //getters y setters de la clase
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}//fin clase DetalleCarrito
