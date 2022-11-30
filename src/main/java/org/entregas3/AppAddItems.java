package org.entregas3;

import org.entregas3.elementos.Director;
import org.entregas3.elementos.Videojuego;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppAddItems {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Director dir = new Director("Markus Persson",1979);
        Videojuego d1 = new Videojuego("Minecraft","Mojang",2010,dir);

        ss.persist(d1);
        t.commit();
        ss.close();
    }
}
