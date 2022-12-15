package org.entregas3;

import org.entregas3.elementos.Desarrollador;
import org.entregas3.elementos.Director;
import org.entregas3.elementos.MotorGrafico;
import org.entregas3.elementos.Videojuego;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppAddItems {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Director dir = new Director("Markus Persson",1979);
        Director dir2 = new Director("Ruloi",1987);
        Director dir3 = new Director("Miyazaki",1957);
        Director dir4 = new Director("Yoko Taro",1970);

        Videojuego d1 = new Videojuego("Minecraft","Mojang",2010,null,null);
        Videojuego d2 = new Videojuego("Fall Guys","Mediatonic",2020,null,null);
        Videojuego d3 = new Videojuego("Nier","Cavia",2010,null,null);
        Videojuego d4 = new Videojuego("Sonic Colors","Sega",2010,null,null);

        MotorGrafico mg1 = new MotorGrafico("GDScript","Godot","Software Freedom Conservancy ",null);
        MotorGrafico mg2 = new MotorGrafico("C#","Unity","Unity Technologies",null);
        MotorGrafico mg3 = new MotorGrafico("C++","Unreal Engine","Epic Games",null);
        MotorGrafico mg4 = new MotorGrafico("Java","libGDX","Mario Zechner",null);

        Desarrollador des1 = new Desarrollador("Alfonsico",200,null,null);
        Desarrollador des2 = new Desarrollador("Gorrumio",300,null,null);
        Desarrollador des3 = new Desarrollador("Egido",400,null,null);
        Desarrollador des4 = new Desarrollador("Escolástico",150,null,null);
        Desarrollador des5 = new Desarrollador("Jonatan",20,null,null);
        Desarrollador des6 = new Desarrollador("Carratalayud",800,null,null);

        List<Desarrollador> desa1 = new ArrayList<>();
        List<Desarrollador> desa2 = new ArrayList<>();
        List<Desarrollador> desa3 = new ArrayList<>();
        List<Desarrollador> desa4 = new ArrayList<>();

        List<Videojuego> video1 = new ArrayList<>();
        List<Videojuego> video2 = new ArrayList<>();
        List<Videojuego> video3 = new ArrayList<>();
        List<Videojuego> video4 = new ArrayList<>();

        // DIRECTORES
        d1.setDirector(dir);
        d2.setDirector(dir2);
        d3.setDirector(dir3);
        d4.setDirector(dir4);

        // DESARROLLADORES
        desa1.add(des1);
        desa1.add(des2);
        desa2.add(des1);
        desa2.add(des3);
        desa3.add(des2);
        desa3.add(des4);
        desa4.add(des5);
        desa4.add(des6);

        d1.setDesarrolladores(desa1);
        d2.setDesarrolladores(desa2);
        d3.setDesarrolladores(desa3);
        d4.setDesarrolladores(desa4);

        // MOTOR GRAFICO
        des1.setMotor(mg1);
        des2.setMotor(mg1);
        des3.setMotor(mg2);
        des4.setMotor(mg2);
        des5.setMotor(mg3);
        des6.setMotor(mg4);


        mg1.setDesarrolladores(desa1);
        mg2.setDesarrolladores(desa2);
        mg3.setDesarrolladores(desa3);
        mg4.setDesarrolladores(desa4);


        // VIDEOJUEGOS
        video1.add(d1);
        video1.add(d2);
        video2.add(d3);
        video2.add(d4);
        video3.add(d1);
        video3.add(d3);
        video4.add(d2);
        video4.add(d4);
        video3.add(d1);
        video3.add(d4);
        video4.add(d2);
        video4.add(d3);

        des1.setVideojuegos(video1);
        des2.setVideojuegos(video2);
        des3.setVideojuegos(video3);
        des4.setVideojuegos(video4);
        des5.setVideojuegos(video2);
        des6.setVideojuegos(video4);


        ss.persist(mg1);
        ss.persist(mg2);
        ss.persist(mg3);
        ss.persist(mg4);
        t.commit();
        ss.close();
    }
}
