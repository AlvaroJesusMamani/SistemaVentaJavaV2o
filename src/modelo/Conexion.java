/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Jesus Cahuapaza
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;

    // Datos de tu base de datos
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=BDSistVentas;encrypt=false;";
    private final String user = "sa";          // Cambia si usas otro usuario
    private final String password = "admin"; // Cambia por tu contraseña real

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a SQL Server VAMOS");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(" Error de conexion: " + e.getMessage());
        }
        return con;
    }
}

