package com.mycompany.desayunosv2;

import java.util.ArrayList;
import javax.persistence.Query;
import models.carta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USUARIO
 */
public class FuncionCarta {
    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static Session s = sf.openSession();
    
    public void listaCarta(){
        Query q = s.createQuery("FROM carta", carta.class);
        ArrayList<carta> res = (ArrayList<carta>)q.getResultList();
        System.out.println("\n\nCONTENIDO DE LA CARTA:");
        res.forEach( (p)->System.out.println(p) );
    }
    
    
}
