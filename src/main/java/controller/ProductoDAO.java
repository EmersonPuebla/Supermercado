/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
    
    
    public void agregarProducto() {}
    
   // public void buscarProducto() {}
    
    public static String getNombre(int codigo) {
        String query = "SELECT nombre FROM producto WHERE id_producto = ?";
        String nombre = null;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            // Establecer el valor del parámetro `codigo` en la consulta
            ps.setInt(1, codigo);  // Usamos setInt para un parámetro de tipo int

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // Si se encuentra el producto con el código
                nombre = rs.getString("nombre"); // Obtener el nombre del producto
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }

        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el nombre del producto");
            e.printStackTrace();
        }
        return nombre;
    }

    public static String getMarca(int codigo) {
        String query = "SELECT marca FROM producto WHERE id_producto = ?";
        String marca = null;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                marca = rs.getString("marca");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la marca del producto");
            e.printStackTrace();
        }
        return marca;
    }

    public static int getMedida(int codigo) {
        String query = "SELECT medida FROM producto WHERE id_producto = ?";
        int medida = 0;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                medida = rs.getInt("medida");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la marca del producto");
            e.printStackTrace();
        }
        return medida;
    }

    public static String getUnidadMedida(int codigo) {
        String query = "SELECT unidad_medida FROM producto WHERE id_producto = ?";
        String unidadMedida = null;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                unidadMedida = rs.getString("unidad_medida");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la marca del producto");
            e.printStackTrace();
        }
        return unidadMedida;
    }
    
    public static int getPrecio(int codigo) {
        String query = "SELECT precio FROM producto WHERE id_producto = ?";
        int precio = 0;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                precio = rs.getInt("precio");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el precio del producto");
            e.printStackTrace();
        }
        return precio;
    }
    
    public static int getStock(int codigo) {
        String query = "SELECT stock FROM producto WHERE id_producto = ?";
        int stock = 0;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                stock = rs.getInt("stock");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el stock del producto");
            e.printStackTrace();
        }
        return stock;
    }
    
    public static int getDescuento(int codigo) {
        String query = "SELECT descuento FROM producto WHERE id_producto = ?";
        int descuento = 0;

        try (Connection con = BaseDeDatos.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                descuento = rs.getInt("descuento");
            } else {
                System.out.println("No se encontró un producto con el código: " + codigo);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el stock del producto");
            e.printStackTrace();
        }
        return descuento;
    }
    
    
    
    
    
    
    
    public void actualizarProducto() {}
    
    public void eliminarProducto() {}
    
}
