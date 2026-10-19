/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.fidelitas.practica2.practica2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author gabri, steven, andres, jose
 *
 */
public class Practica2 {

    public static void main(String[] args) {
        //variable global
        int menu = 0;

        //hacer los arry y las list 
        List<ProductoBase> inventario = new ArrayList<>();
        List<ProductoBase> carrito = new ArrayList<>();
        List<Integer> cantidadesCarrito = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println(""
                    + "+--------------------------------+\n"
                    + "|         MENU PRINCIPAL         |\n"
                    + "+--------------------------------+\n"
                    + "| 1 - Agregrar producto          |\n"
                    + "| 2 - ver catalogo de productos  |\n"
                    + "| 3 - agregar producto carrito   |\n"
                    + "| 4 - ver carrito, total y recibo|\n"
                    + "| 5 - Producto con descuento     |\n"
                    + "| 6 - Modificar producto         |\n"
                    + "| 7 - Eliminar producto          |\n"
                    + "| 8 - Salir                      |\n"
                    + "+--------------------------------+\n"
                    + "Digite una opcion:");

            try {
                menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println(""
                                + "+--------------------------------+\n"
                                + "|         Agregar producto       |\n");
                        System.out.println("ingrese el nombre del producto");
                        scanner.nextLine();
                        String nombre = scanner.nextLine();

                        System.out.println("ingrese el precio ");
                        double precio = scanner.nextDouble();

                        System.out.println("ingrese la cantidad de existencias");
                        int cantidad = scanner.nextInt();

                        if (precio < 0 || cantidad < 0) {
                            System.out.println("\n"
                                    + "el precio o la cantidad no pueden ser negativos ");
                            break;
                        }
                        System.out.println("ingrese el numero de identificacion ");
                        int identificacion = scanner.nextInt();
                        //revisar que no este repetido
                        boolean repetido = false;
                        for (ProductoBase p : inventario) {
                            if (p.getId() == identificacion) {
                                repetido = true;
                            }
                        }
                        if (repetido) {
                            System.out.println("ya existe un producto con ese codigo.");
                            break;
                        }
                        //creo el objeto
                        Producto nuevoProducto = new Producto(identificacion, nombre, precio, cantidad);
                        //agregar al array list
                        inventario.add(nuevoProducto);
                        //int id, String nombre, double precio, int CantidadInventario costructor
                        //agregar producto 

                        break;
                    case 2:
                        if (inventario.isEmpty()) {
                            System.out.println("No hay productos registrados");
                        } else {
                            for (ProductoBase productoActual : inventario) {
                                System.out.println("Codigo: " + productoActual.getId());
                                System.out.println("Nombre: " + productoActual.getNombre());
                                System.out.println("Precio: " + productoActual.CalcularPrecioFinal());
                                System.out.println("Existencias: " + productoActual.getCantidadInventario());
                                System.out.println("-----------------------------");
                            }
                        }

                        break;
                    case 3:
                        System.out.println("Ingrese el codigo del producto");
                        int codigoBuscado = scanner.nextInt();

                        System.out.println("Ingrese la cantidad que desea comprar");
                        int cantidadCompra = scanner.nextInt();

                        ProductoBase productoEncontrado = null;

                        for (ProductoBase p : inventario) {
                            if (p.getId() == codigoBuscado) {
                                productoEncontrado = p;
                                break;
                            }
                        }

                        if (cantidadCompra <= 0) {
                            System.out.println("La cantidad debe ser mayor a cero");
                        } else if (productoEncontrado == null) {
                            System.out.println("Producto no encontrado");
                        } else if (cantidadCompra > productoEncontrado.getCantidadInventario()) {
                            System.out.println("No hay suficientes existencias");
                        } else {
                            carrito.add(productoEncontrado);
                            cantidadesCarrito.add(cantidadCompra);

                            productoEncontrado.setCantidadInventario(
                                    productoEncontrado.getCantidadInventario() - cantidadCompra
                            );

                            System.out.println("Producto agregado al carrito");
                        }
                        break;
                    case 4:
                        if (carrito.isEmpty()) {
                            System.out.println("El carrito esta vacio");
                        } else {
                            double total = 0;

                            System.out.println("------ RECIBO DE COMPRA ------");

                            for (int i = 0; i < carrito.size(); i++) {
                                ProductoBase p = carrito.get(i);
                                int unidades = cantidadesCarrito.get(i);

                                double subtotal = p.CalcularPrecioFinal() * unidades;

                                System.out.println("Producto: " + p.getNombre());
                                System.out.println("Cantidad: " + unidades);
                                System.out.println("Subtotal: " + subtotal);
                                System.out.println("-----------------------------");

                                total += subtotal;
                            }

                            System.out.println("TOTAL A PAGAR: " + total);

                            carrito.clear();
                            cantidadesCarrito.clear();
                        }
                        break;
                    case 5:

                        System.out.println("Ingrese el nombre del producto");
                        scanner.nextLine();
                        String nombreD = scanner.nextLine();

                        System.out.println("Ingrese el precio");
                        double precioD = scanner.nextDouble();

                        System.out.println("Ingrese las existencias");
                        int cantidadD = scanner.nextInt();

                        System.out.println("Ingrese el codigo");
                        int codigoD = scanner.nextInt();

                        System.out.println("Ingrese el descuento de 0 a 100");
                        double descuentoD = scanner.nextDouble();

                        //revisar que no este repetido (de nuevo xd)
                        boolean repetidoD = false;
                        for (ProductoBase p : inventario) {
                            if (p.getId() == codigoD) {
                                repetidoD = true;
                            }
                        }
                        if (repetidoD) {
                            System.out.println("ya existe un producto con ese codigo.");
                            break;
                        }

                        if (precioD < 0 || cantidadD < 0 || descuentoD < 0 || descuentoD > 100) {
                            System.out.println("Valores no validos");
                        } else {
                            inventario.add(new ProductoDescuento(
                                    codigoD, nombreD, precioD, cantidadD, descuentoD
                            ));

                            System.out.println("Producto con descuento agregado");
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese el codigo del producto a modificar");
                        int codigoM = scanner.nextInt();

                        ProductoBase productoM = null;

                        for (ProductoBase p : inventario) {
                            if (p.getId() == codigoM) {
                                productoM = p;
                                break;
                            }
                        }

                        if (productoM == null) {
                            System.out.println("Producto no encontrado");
                        } else {
                            System.out.println("Ingrese el nuevo nombre");
                            scanner.nextLine();
                            String nombreM = scanner.nextLine();

                            System.out.println("Ingrese el nuevo precio");
                            double precioM = scanner.nextDouble();

                            System.out.println("Ingrese las nuevas existencias");
                            int cantidadM = scanner.nextInt();

                            if (precioM < 0 || cantidadM < 0) {
                                System.out.println("el precio o la cantidad no pueden ser negativos");
                            } else {
                                productoM.setNombre(nombreM);
                                productoM.setPrecio(precioM);
                                productoM.setCantidadInventario(cantidadM);
                                System.out.println("Producto modificado");
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Ingrese el codigo del producto a eliminar");
                        int codigoE = scanner.nextInt();

                        ProductoBase productoE = null;

                        for (ProductoBase p : inventario) {
                            if (p.getId() == codigoE) {
                                productoE = p;
                                break;
                            }
                        }

                        //revisar que el producto no este en el carrito
                        boolean enCarrito = false;
                        for (ProductoBase p : carrito) {
                            if (p == productoE) {
                                enCarrito = true;
                            }
                        }

                        if (productoE == null) {
                            System.out.println("Producto no encontrado");
                        } else if (enCarrito) {
                            System.out.println("No se puede eliminar, el producto esta en el carrito");
                        } else {
                            System.out.println("Seguro que desea eliminar " + productoE.getNombre() + "? (S/N");
                            String respuesta = scanner.next();

                            //Esperaria que no digan nada por usar .equals jaja
                            if (respuesta.equalsIgnoreCase("s")) {
                                inventario.remove(productoE);
                                System.out.println("Producto eliminado");
                            } else {
                                System.out.println("Eliminacion cancelada");
                            }
                        }
                        break;
                    case 8:
                        System.out.println("gracias por usar el programa");
                        break;

                    default:
                        System.out.println("opcion no valida ");
                        break;
                }//fin swich 
                //menu =0; 
                //en caso que sea null 
            } catch (NullPointerException e) {//se deja aca no recuerdo si habbia que importar una libreria
                menu = 0;
                System.out.println("error nulo " + e.getMessage());
                //creo que este era para text 
            } catch (NumberFormatException e) {
                menu = 0;
                System.out.println("error no se pueden usar letras");
                //recetear 

            } catch (Exception e) {
                menu = 0;
                scanner.next();
                System.out.println("ERROR, no se pueden usar letras, digite solo numeros");
            } finally {
                System.out.println("por favor usar una opcion valida");
            }

        } while (menu != 8);

    }//fin de clase main 
}
