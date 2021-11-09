package com.mycompany.desayunosv2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import models.pedidos;
import java.util.Date;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USUARIO
 */
   
public class FuncionPedido {
    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static Session s = sf.openSession();

    //Creamos pedido
    public void crearPedido() {
        String nombre;
        String estado;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta tu nombre: ");
        nombre = sc.next();
        System.out.println("Inserta el estado del producto: ");
        estado = sc.next();
        System.out.println("Inserta el Id del producto que desea: ");
        int cartaId = sc.nextInt();

        java.util.Date fechaAhora = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(fechaAhora.getTime());

        pedidos p = new pedidos(0, nombre, estado, cartaId, fecha);
        Transaction t = s.beginTransaction();
        s.save(p);
        t.commit();

    }
    
    public void marcarPedido(){
        Integer pedidoId;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserta el id del pedido que se va a recoger: ");
        pedidoId = sc.nextInt();
        Serializable id = pedidoId;
        
        Transaction t = s.beginTransaction();
        pedidos p = s.load(pedidos.class, id);
        p.setEstado("Ha sido recogido");
        s.update(p);
        t.commit();
    }
    
    public void borrarPedido(){
        Integer pedido;
        Integer r = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta el id del pedido que quieres eliminar: ");
        pedido = sc.nextInt();
        Serializable id = pedido;
        
        Transaction t = s.beginTransaction();
        pedidos p = s.load(pedidos.class, id);
        s.remove(p);
        t.commit();
    }
    
    public void listaComandas(){
        Query q = s.createQuery("FROM carta WHERE estado = 'A la espera'", pedidos.class);
        ArrayList<pedidos> res = (ArrayList<pedidos>)q.getResultList();
        System.out.println(res.toString());
    }
    

}
