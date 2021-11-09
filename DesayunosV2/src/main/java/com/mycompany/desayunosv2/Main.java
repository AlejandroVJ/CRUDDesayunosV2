package com.mycompany.desayunosv2;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USUARIO
 */
public class Main {
    public static void main(String[] args) {
        FuncionCarta funcionC = new FuncionCarta();
        FuncionPedido funcionP = new FuncionPedido();
        
        Scanner sc = new Scanner(System.in);
        int opciones = 0;
        //Menú selector
        do {
            System.out.println("Elige una opción: \n"
                    + "La carta: 1\n"
                    + "Crear tu pedido: 2\n"
                    + "Marca tu pedido como recogido: 3\n"
                    + "Eliminar tu pedido: 4\n"
                    + "Todas las comandas pendientes: 5\n"
                    + "Salir: 6\n");
            opciones = sc.nextInt();
            switch (opciones) {
                case 1:
                    funcionC.listaCarta();
                    break;
                case 2:
                    funcionP.crearPedido();
                    break;
                case 3:
                    funcionP.marcarPedido();
                    break;
                case 4:
                    funcionP.borrarPedido();
                    break;
                case 5:
                    funcionP.listaComandas();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    opciones = 0;
                    System.out.println("Selecciona una opción");

            }
        }while (opciones !=6);
        
        
    }
    
}
