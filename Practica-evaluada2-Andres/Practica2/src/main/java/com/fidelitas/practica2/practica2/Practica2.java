package com.fidelitas.practica2.practica2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri, steven, andres, jose
 */
public class Practica2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> inventario = new ArrayList<>();
        List<DetalleCarrito> carrito = new ArrayList<>();
        int menu = 0;

        do {
            System.out.println(""
                    + "+--------------------------------+\n"
                    + "|   MINISUPER RAPIDO - MENU      |\n"
                    + "+--------------------------------+\n"
                    + "| 1 - Agregar producto           |\n"
                    + "| 2 - Agregar producto descuento |\n"
                    + "| 3 - Listar productos           |\n"
                    + "| 4 - Buscar producto por codigo |\n"
                    + "| 5 - Modificar producto         |\n"
                    + "| 6 - Eliminar producto          |\n"
                    + "| 7 - Agregar producto al carrito|\n"
                    + "| 8 - Ver carrito, total, recibo |\n"
                    + "| 9 - Salir                      |\n"
                    + "+--------------------------------+\n"
                    + "Digite una opcion:");

            try {
                menu = scanner.nextInt();

                switch (menu) {
                    case 1://agregar producto normal
                    case 2://agregar producto con descuento
                        System.out.println(""
                                + "+--------------------------------+\n"
                                + "|        AGREGAR PRODUCTO        |\n"
                                + "+--------------------------------+");
                        System.out.println("Ingrese el codigo del producto");
                        int codigo = scanner.nextInt();

                        //revisamos que el codigo no este repetido
                        boolean repetido = false;
                        for (int i = 0; i < inventario.size(); i++) {
                            if (inventario.get(i).getCodigo() == codigo) {
                                repetido = true;
                            }
                        }
                        if (repetido) {
                            System.out.println("Ya existe un producto con ese codigo. Producto no registrado.");
                            break;
                        }

                        scanner.nextLine();//limpiamos el salto de linea que deja nextInt
                        System.out.println("Ingrese el nombre del producto");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese el precio");
                        double precio = scanner.nextDouble();
                        System.out.println("Ingrese la cantidad de existencias");
                        int cantidad = scanner.nextInt();

                        //si algun dato es invalido el constructor lanza la excepcion
                        Producto nuevoProducto;
                        if (menu == 1) {
                            nuevoProducto = new Producto(codigo, nombre, precio, cantidad);
                        } else {
                            System.out.println("Ingrese el porcentaje de descuento (1 a 99)");
                            double descuento = scanner.nextDouble();
                            nuevoProducto = new ProductoDescuento(codigo, nombre, precio, cantidad, descuento);
                        }

                        inventario.add(nuevoProducto);
                        System.out.println("Producto guardado correctamente");
                        break;

                    case 3://listar productos
                        if (inventario.isEmpty()) {
                            System.out.println("No hay productos registrados");
                        } else {
                            String borde = "+----------------------------------------+";
                            System.out.println(borde);
                            System.out.println("|          CATALOGO DE PRODUCTOS         |");
                            //cada producto se muestra en su propio recuadro
                            for (int i = 0; i < inventario.size(); i++) {
                                System.out.println(borde);
                                System.out.println("| PRODUCTO " + (i + 1));
                                System.out.println(borde);
                                inventario.get(i).mostrar();//polimorfismo, cada tipo se muestra a su manera
                            }//fin for
                            System.out.println(borde);
                        }//fin else
                        break;

                    case 4://buscar por codigo
                        System.out.println("Ingrese el codigo del producto");
                        int codigoBuscado = scanner.nextInt();

                        //recorremos el inventario buscando el codigo
                        Producto productoBuscado = null;
                        for (int i = 0; i < inventario.size(); i++) {
                            if (inventario.get(i).getCodigo() == codigoBuscado) {
                                productoBuscado = inventario.get(i);
                            }
                        }

                        if (productoBuscado == null) {
                            System.out.println("Producto no encontrado");
                        } else {
                            System.out.println("+----------------------------------------+");
                            productoBuscado.mostrar();
                            System.out.println("+----------------------------------------+");
                        }
                        break;

                    case 5://modificar producto
                        System.out.println("Ingrese el codigo del producto a modificar");
                        int codigoModificar = scanner.nextInt();

                        //recorremos el inventario buscando el codigo
                        Producto productoModificar = null;
                        for (int i = 0; i < inventario.size(); i++) {
                            if (inventario.get(i).getCodigo() == codigoModificar) {
                                productoModificar = inventario.get(i);
                            }
                        }
                        if (productoModificar == null) {
                            System.out.println("Producto no encontrado");
                            break;
                        }

                        scanner.nextLine();//limpiamos el salto de linea que deja nextInt
                        System.out.println("Ingrese el nuevo nombre");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese el nuevo precio");
                        double nuevoPrecio = scanner.nextDouble();
                        System.out.println("Ingrese las nuevas existencias");
                        int nuevaCantidad = scanner.nextInt();

                        //modificar valida todos los datos antes de cambiarlos y lanza excepcion si son invalidos
                        productoModificar.modificar(nuevoNombre, nuevoPrecio, nuevaCantidad);
                        System.out.println("Producto modificado correctamente");
                        break;

                    case 6://eliminar producto
                        System.out.println("Ingrese el codigo del producto a eliminar");
                        int codigoEliminar = scanner.nextInt();

                        //recorremos el inventario buscando el codigo
                        Producto productoEliminar = null;
                        for (int i = 0; i < inventario.size(); i++) {
                            if (inventario.get(i).getCodigo() == codigoEliminar) {
                                productoEliminar = inventario.get(i);
                            }
                        }
                        if (productoEliminar == null) {
                            System.out.println("Producto no encontrado");
                            break;
                        }

                        //revisamos que el producto no este en el carrito
                        boolean enCarrito = false;
                        for (int i = 0; i < carrito.size(); i++) {
                            if (carrito.get(i).getProducto() == productoEliminar) {
                                enCarrito = true;
                            }
                        }
                        if (enCarrito) {
                            System.out.println("No se puede eliminar, el producto esta en el carrito");
                            break;
                        }

                        inventario.remove(productoEliminar);
                        System.out.println("Producto eliminado");
                        break;

                    case 7://agregar al carrito
                        if (inventario.isEmpty()) {
                            System.out.println("No hay productos registrados");
                            break;
                        }
                        //armamos la lista de productos y la mostramos una sola vez
                        String listaProductos = "Productos disponibles:\n";
                        for (int i = 0; i < inventario.size(); i++) {
                            listaProductos += inventario.get(i).getCodigo() + " - " + inventario.get(i).getNombre()
                                    + " - Precio: " + inventario.get(i).calcularPrecioFinal()
                                    + " (" + inventario.get(i).getCantidadInventario() + " disponibles)\n";
                        }
                        System.out.println(listaProductos);

                        System.out.println("Ingrese el codigo del producto");
                        int codigoCompra = scanner.nextInt();

                        //recorremos el inventario buscando el codigo
                        Producto productoCompra = null;
                        for (int i = 0; i < inventario.size(); i++) {
                            if (inventario.get(i).getCodigo() == codigoCompra) {
                                productoCompra = inventario.get(i);
                            }
                        }
                        if (productoCompra == null) {
                            System.out.println("Producto no encontrado");
                            break;
                        }

                        System.out.println("Ingrese la cantidad que desea comprar");
                        int cantidadCompra = scanner.nextInt();
                        //vender lanza excepcion si la cantidad es invalida o no hay stock
                        productoCompra.vender(cantidadCompra);

                        //creamos el detalle y lo guardamos en el carrito
                        DetalleCarrito nuevoDetalle = new DetalleCarrito();
                        nuevoDetalle.setProducto(productoCompra);
                        nuevoDetalle.setCantidad(cantidadCompra);
                        nuevoDetalle.setSubtotal(productoCompra.calcularSubtotal(cantidadCompra));
                        carrito.add(nuevoDetalle);
                        System.out.println("Producto agregado al carrito.\nSubtotal: " + nuevoDetalle.getSubtotal());
                        break;

                    case 8://carrito, total y recibo
                        if (carrito.isEmpty()) {
                            System.out.println("El carrito esta vacio");
                        } else {
                            String recibo = "+----------------------------------------+\n"
                                    + "|            RECIBO DE COMPRA            |\n"
                                    + "+----------------------------------------+\n";
                            double total = 0;

                            //recorremos el carrito
                            for (int i = 0; i < carrito.size(); i++) {

                                DetalleCarrito detalleActual = carrito.get(i);

                                recibo += "Producto " + (i + 1)
                                        + "\nNombre: " + detalleActual.getProducto().getNombre()
                                        + "\nCantidad: " + detalleActual.getCantidad()
                                        + "\nPrecio unitario: " + detalleActual.getProducto().calcularPrecioFinal()
                                        + "\nSubtotal: " + detalleActual.getSubtotal()
                                        + "\n--------------------------\n";

                                //sumamos el subtotal de cada producto
                                total += detalleActual.getSubtotal();
                            }

                            recibo += "\nCantidad de productos: " + carrito.size()
                                    + "\nTotal a pagar: " + total
                                    + "\nGracias por su compra";

                            System.out.println(recibo);

                            //la compra queda pagada, se vacia el carrito
                            carrito.clear();
                        }
                        break;

                    case 9://salir del programa
                        System.out.println("Gracias por usar el programa");
                        break;

                    default://en caso de que ingrese otro numero
                        System.out.println("Opcion no valida");
                        break;
                }//fin switch

            } catch (IllegalArgumentException e) {//cantidades negativas o datos invalidos
                System.out.println("ERROR: " + e.getMessage());
            } catch (StockInsuficienteException e) {//no hay suficiente stock
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {//cuando escriben letras donde van numeros
                if (scanner.hasNextLine()) {
                    scanner.nextLine();//se descarta lo que escribieron mal
                    menu = 0;
                    System.out.println("ERROR: solo se permiten numeros (los decimales se escriben con punto, ej. 1.5).");
                } else {
                    //ya no hay mas entrada (ej. Ctrl+Z), se cierra el programa para que no se caiga
                    menu = 9;
                    System.out.println("No hay mas datos de entrada, se cierra el programa.");
                }
            } finally {
                System.out.println("--------------------------------------");
            }

        } while (menu != 9);

    }//fin de main
}
