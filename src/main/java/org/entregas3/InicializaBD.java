package org.entregas3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializaBD {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "root", "root");
             Statement stmn = conn.createStatement()) {
            String sql = "CREATE DATABASE ut3ramonegido";
            stmn.execute(sql);
            System.out.println("Base de datos creada satisfactoriamente...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
