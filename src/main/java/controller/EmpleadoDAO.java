package controller;
import java.sql.*;
import controller.BaseDeDatos;

public class EmpleadoDAO {

    public static void agregar() {}

    public static void editar() {}

public static String[] getNombre(String inputUsername) {
    String query = "SELECT primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno FROM empleado WHERE username = ?";
    
    // Crear el arreglo que se retornará
    String[] nombreCompleto = new String[4]; 
    
    try (Connection con = BaseDeDatos.conectar(); 
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setString(1, inputUsername);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) { // Si se encuentra el usuario
            // Obtener los valores del ResultSet y asignarlos al arreglo
            nombreCompleto[0] = rs.getString("primerNombre");
            nombreCompleto[1] = rs.getString("segundoNombre");
            nombreCompleto[2] = rs.getString("apellidoPaterno");
            nombreCompleto[3] = rs.getString("apellidoMaterno");
        } else {
            System.out.println("No se encontró un usuario con el username: " + inputUsername);
            // Si no se encuentra el usuario, devolver null o un arreglo vacío
            return new String[] {};  // Devuelve un arreglo vacío si no se encuentra el usuario
        }
        
    } catch (SQLException e) {
        System.out.println("ERROR [SQL]: No se pudo leer el username");
        e.printStackTrace();
        return new String[] {};  // Devuelve un arreglo vacío en caso de error
    }
        return nombreCompleto;  // Devolver el arreglo con los nombres y apellidos
    }

    
    public static String getUsername(String inputUsername) {
        String query = "SELECT username FROM empleado WHERE username = ?";
        String username = null;
    
    try (Connection con = BaseDeDatos.conectar(); 
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setString(1, inputUsername);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) { // Si se encuentra el usuario
            username = rs.getString("username");
        } else {
            System.out.println("No se encontró un usuario con el username: " + inputUsername);
        }
        
    } catch (SQLException e) {
        System.out.println("ERROR [SQL]: No se pudo leer el username");
        e.printStackTrace();
    }
        return username;
    }

    
    public static String getPassword(String inputUsername) {
        String query = "SELECT password FROM empleado WHERE username = ?";
        String password = null;
    
    try (Connection con = BaseDeDatos.conectar(); 
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setString(1, inputUsername);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) { // Si se encuentra el usuario
            password = rs.getString("password");
        } else {
            System.out.println("No se encontró un usuario con el username: " + inputUsername);
        }
        
    } catch (SQLException e) {
        System.out.println("ERROR [SQL]: No se pudo leer la contraseña");
        e.printStackTrace();
    }
    
    return password;
}

    public static Boolean[] getPermisos(String inputUsername) {
        String query = "SELECT isAdministrador, isReporte, isCaja, isBodega, isHabilitado FROM empleado WHERE username = ?";
        Boolean[] permisos = new Boolean[5];

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, inputUsername);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // Si se encuentra el usuario
                permisos[0] = rs.getBoolean("isAdministrador");
                permisos[1] = rs.getBoolean("isReporte");
                permisos[2] = rs.getBoolean("isCaja");
                permisos[3] = rs.getBoolean("isBodega");
                permisos[4] = rs.getBoolean("isHabilitado");
            } else {
                System.out.println("No se encontró un usuario con el username: " + inputUsername);
            }

        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudieron leer los permisos");
            e.printStackTrace();
        }

        return permisos;
    }
    
    
    
}
