package org.entregas3;

import org.entregas3.elementos.Desarrollador;
import org.entregas3.elementos.Director;
import org.entregas3.elementos.Videojuego;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Queries {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();


        // QUERY 1
        System.out.println("QUERY 1");
        Query<Desarrollador> q1 = ss.createQuery("From Desarrollador",Desarrollador.class);
        List<Desarrollador> result1 = q1.list();
        for(Desarrollador d : result1)
            System.out.println(d.getNombre());

        // QUERY 2
        System.out.println("QUERY 2");

        Query<Desarrollador> q2 = ss.createQuery("From Desarrollador where id = 1",Desarrollador.class);
        Desarrollador desa = q2.uniqueResult();
        System.out.println(desa.getNombre());

        // QUERY 3
        System.out.println("QUERY 3");

        Query<Object[]> q3 = ss.createQuery("Select d.horas,d.nombre from Desarrollador d where d.horas > 20 order by horas desc");
        List<Object[]> result2 = q3.list();
        for(Object[] de : result2){
            System.out.println("Desarrollador: "+de[1]+ ", Horas trabajadas: "+ de[0]);
        }

        // QUERY 4
        System.out.println("QUERY 4");
        Query<Object[]> q4 = ss.createQuery("from Director d,Videojuego v where d.id = v.director.id and v.nombre = 'Fall Guys'");
        Object[] direc = q4.uniqueResult();
        System.out.println(direc[0]);

        // QUERY 5
        System.out.println("QUERY 5");
        Query<Object[]> q5 = ss.createQuery("select d.nombre, d.horas from Desarrollador d where d.horas = (select max(horas) from Desarrollador )");
        Object[] result5 = q5.uniqueResult();
        System.out.printf("El desarrollador con más horas es: %s, con %d horas.\n",result5[0],result5[1]);

        // QUERY 6
        System.out.println("QUERY 6");
        Query<Object[]> q6 = ss.createQuery("from Videojuego v,Director d where v.director.id = d.id and d.year < 1975");
        Iterator<Object[]> result6 = q6.stream().iterator();
        result6.forEachRemaining(objects -> System.out.println(objects[0]));

    }
}
