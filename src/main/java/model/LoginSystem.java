/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.EmpleadoDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class LoginSystem {    
    static String nombreEmpleado = null;
    static String apellidoEmpleado = null;
    static Boolean[] permisos = {false, false, false, false, false};
    
    public static String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public static String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public static Boolean[] getPermisos() {
        return permisos;
    }
    
    public static void setNombreEmpleado(String nombreEmpleado) {
        LoginSystem.nombreEmpleado = nombreEmpleado;
    }
    
    public static void setApellidoEmpleado(String apellidoEmpleado) {
        LoginSystem.apellidoEmpleado = apellidoEmpleado;
    }

    public static void setPermisos(Boolean[] permisos) {
        LoginSystem.permisos = permisos;
    }
    
    public static boolean login(String username, char[] passwordChar) {
        String password = new String(passwordChar);   
        String hashed = hashString(password);
        
        String objUsername = EmpleadoDAO.getUsername(username);
        String objPassword = EmpleadoDAO.getPassword(username);
        permisos = EmpleadoDAO.getPermisos(username);
        
        if (password.length() == 0 || username.length() == 0) {
           JOptionPane.showMessageDialog(null, "Porfavor rellena los campos faltantes", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
           return false;
           
        } else if (hashed.equals(objPassword) && username.equals(objUsername)) {       
            if (permisos[4] == false) {
                JOptionPane.showMessageDialog(null, "No tienes permiso para ingresar al sistema", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);  
                return false;
            }
            
            setNombreEmpleado(EmpleadoDAO.getNombre(username)[0]);
            setApellidoEmpleado(EmpleadoDAO.getNombre(username)[2]);
            setPermisos(EmpleadoDAO.getPermisos(username)); 

            return true;
            
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);  
            return false;
        
        }
    }
    
    //---customs----
    public static String hashString(String input) {
        try {
            // No entiendo muy bien como hace el hash
            // sin embargo, si le sumáramos algo al input
            // podría servir como salt aunque realmente no es necesario
            // o eso creo, tampoco es un software comercial como tal :v
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("ERROR [hashString]: ");
        }
    }  

    public static boolean compararHash(String textoOriginal, String hash) {
        String Hash = hashString(textoOriginal);
        return Hash.equals(hash);
        // devuelve true/false dependiendo de si es igual o no
    }
}
