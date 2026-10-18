/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fidelitas.practica2.practica2;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author gabri
 */
public class Practica2 {

    public static void main(String[] args) {
        //variable global
        int menu=0;
        
        //hacer los arry y las list 
        List<ProductoBase> inventario = new ArrayList<>();
        
        
        Scanner scanner = new Scanner(System.in);
        do{
            
            System.out.println(""
                    + "+--------------------------------+\n"
                    + "|         MENU PRINCIPAL         |\n"
                    + "+--------------------------------+\n"
                    + "| 1 - Agregrar producto          |\n"
                    + "| 2 - ver catalogo de productos  |\n"
                    + "| 3 - agregar producto carrito   |\n"
                    + "| 4 - ver carito, total y recibo |\n"
                    + "| 5 - Salir                      |\n"
                    + "+--------------------------------+\n"
                    + "Digite una opcion:");
            
            try{
                menu=scanner.nextInt();
                switch(menu){
                    case 1:
                        System.out.println(""
                        + "+--------------------------------+\n"
                        + "|         Agregar producto       |\n");
                        System.out.println("ingrese el nombre del producto");
                        String nombre=scanner.nextLine();
                        System.out.println("ingrese el precio ");
                        double precio= scanner.nextDouble();
                        
                        System.out.println("ingrese la cantidad de existencias");
                        int cantidad= scanner.nextInt();
                        
                        if(precio<0 || cantidad <0 ){
                            System.out.println("\n"
                                    +"el precio o la cantidad no pueden ser negativos ");
                        }
                        System.out.println("ingrese el numero de identificacion ");
                        int identificacion= scanner.nextInt();
                        //creo el objett¿o
                        Producto nuevoProducto = new Producto(identificacion, nombre, precio, cantidad);
                        //agregar al array list
                        inventario.add(nuevoProducto);
                        //int id, String nombre, double precio, int CantidadInventario costructor
                        //agregar producto 
                        break;
                    case 2:
                        //ver catalogo 
                        
                        break;
                    case 3:
                        //agregar producto 
                        break;
                    case 4:
                        //recibo 
                        break;
                    case 5:
                        System.out.println("gracias por usar el programa");
                        break;
                    default://si usa un 6 o algo mas 
                        System.out.println("opcion no valida ");
                        break;
                    
                    
                    
                }//fin swich 
            //menu =0; 
            //en caso que sea null 
            }catch(NullPointerException e){//se deja aca no recuerdo si habbia que importar una libreria
                menu=0;
                System.out.println("error nulo "+e.getMessage() );
                //creo que este era para text 
            }catch(NumberFormatException e){
                menu=0;
                System.out.println("error no se pueden usar letras");
                //recetear 
                
            }finally{
                System.out.println("por favor usar una opcion valida");
            }
            
        
        
        }while(menu!=5);
        

    }//fin de clase main 
}
