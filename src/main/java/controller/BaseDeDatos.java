package controller;

import java.sql.*;

public class BaseDeDatos {
    static String url = "jdbc:mysql://localhost:3306/supermercado";
    static String user = "root";
    static String pass = "";
    
    public static Connection conectar() {
        Connection con = null;
        
        try {
          con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");
        
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: " + e);
        } 
        
        return con;
    }
    
    
}