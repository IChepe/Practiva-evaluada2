package com.fidelitas.practica2.practica2;

/**
 *
 * @author gabri, steven, andres, jose
 */
public class Producto extends ProductoBase {

    //el codigo es final para que nunca se cambie despues de creado el producto
    private final int codigo;
    private String nombre;
    private double precio;
    private int cantidadInventario;

    //constructor con todos los atributos, usa los setters para validar
    public Producto(int codigo, String nombre, double precio, int cantidadInventario) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El codigo debe ser mayor a 0.");
        }
        this.codigo = codigo;
        setNombre(nombre);
        setPrecio(precio);
        setCantidadInventario(cantidadInventario);
    }

    //getters y setters de la clase
    //el codigo solo tiene get porque es final
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre.trim();
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        validarPrecio(precio);
        this.precio = precio;
    }

    public int getCantidadInventario() {
        return this.cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        validarCantidad(cantidadInventario);
        this.cantidadInventario = cantidadInventario;
    }

    //cambia los datos del producto, primero valida todo para que no quede cambiado a medias
    public void modificar(String nombre, double precio, int cantidadInventario) {
        validarNombre(nombre);
        validarPrecio(precio);
        validarCantidad(cantidadInventario);
        setNombre(nombre);
        setPrecio(precio);
        setCantidadInventario(cantidadInventario);
    }

    //validaciones, lanzan excepcion si el dato no es valido
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
    }

    private void validarPrecio(double precio) {
        //NaN e Infinity tambien los acepta nextDouble, por eso se revisan
        if (Double.isNaN(precio) || Double.isInfinite(precio) || precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser un numero mayor a 0.");
        }
    }

    private void validarCantidad(int cantidadInventario) {
        if (cantidadInventario < 0) {
            throw new IllegalArgumentException("La cantidad en inventario no puede ser negativa.");
        }
    }

    //rebaja del inventario las unidades vendidas
    //lanza excepcion si la cantidad es invalida o si no hay suficiente stock
    public void vender(int cantidad) throws StockInsuficienteException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad invalida, debe ser mayor a 0.");
        }
        if (cantidad > this.cantidadInventario) {
            throw new StockInsuficienteException("No hay suficientes existencias de " + this.nombre
                    + ". Disponibles: " + this.cantidadInventario);
        }
        this.cantidadInventario = this.cantidadInventario - cantidad;
    }

    //el producto normal se vende a su precio sin cambios
    @Override
    public double calcularPrecioFinal() {
        return this.precio;
    }

    //usa calcularPrecioFinal, asi cada subclase aplica su propio precio
    @Override
    public double calcularSubtotal(int cantidad) {
        return calcularPrecioFinal() * cantidad;
    }

    @Override
    public void mostrar() {
        System.out.println("| Codigo      : " + this.codigo);
        System.out.println("| Nombre      : " + this.nombre);
        System.out.println("| Precio      : " + this.precio);
        System.out.println("| Precio final: " + calcularPrecioFinal());
        System.out.println("| Existencias : " + this.cantidadInventario);
    }

}//fin clase Producto
