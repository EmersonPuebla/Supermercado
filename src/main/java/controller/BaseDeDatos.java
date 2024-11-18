package src.main.java.controller;

import java.sql.*;

public class BaseDeDatos {
    private Connection con = null;

    public BaseDeDatos() {
    }

    @SuppressWarnings("deprecation") // Para que no se queje por el jdbc.Driver
    public Connection conectar(String url, String dbName, String username, String password) throws Exception {
        try {
            String completeURL = "jdbc:mysql://" + url + dbName;

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection(completeURL, username, password);

        } catch (SQLException e) {
            System.out.println("ERROR [SQL CONNECTION]: " + e);
        }
        if (con != null)
            System.out.println("[SQL CONNECTOR]: Se ha establecido una conexión a la base de datos");
        return con;
    }

    public void desconectar() {
        try {
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            System.out.println("ERROR [SQL CONNECTOR]: " + e);
        }
    }

    public String query(String query) {
        return "";
    }
}
