package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
//excepcion propia para cuando no hay suficientes existencias de un producto
public class StockInsuficienteException extends Exception {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }

}//fin clase StockInsuficienteException
