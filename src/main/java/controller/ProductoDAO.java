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
    
    
public static boolean agregarProducto(
        String nombre,
        String marca,
        int medida,
        String unidadMedida,
        int precio,
        int stock,
        int descuento
) {
    // Variable para el nuevo id_producto
    int id_producto = 0;
    
    // Consulta para obtener el último id_producto
    String querySelect = "SELECT MAX(id_producto) FROM producto";
    String queryInsert = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        // Establecer conexión a la base de datos
        Connection con = BaseDeDatos.conectar();

        // Consultar el último id_producto
        PreparedStatement psSelect = con.prepareStatement(querySelect);
        ResultSet rs = psSelect.executeQuery();
        
        if (rs.next()) {
            id_producto = rs.getInt(1) + 1; // Incrementar el último id_producto
        }

        // Insertar el nuevo producto con el id_producto calculado
        PreparedStatement psInsert = con.prepareStatement(queryInsert);
        psInsert.setInt(1, id_producto);
        psInsert.setString(2, nombre);
        psInsert.setString(3, marca);
        psInsert.setInt(4, medida);
        psInsert.setString(5, unidadMedida);
        psInsert.setInt(6, precio);
        psInsert.setInt(7, stock);
        psInsert.setInt(8, descuento);

        // Ejecutar la inserción
        psInsert.executeUpdate();
        System.out.println("Dato Insertado con éxito");
        return true;
        
    } catch (SQLException ex) {
        System.out.println("ERROR [SQL INSERT]: No se pudo insertar el dato");
        ex.printStackTrace();
        return false;
    }
}

public static boolean actualizarProducto(
        int id_producto,       // ID del producto a actualizar
        String nombre,         // Nombre del producto
        String marca,          // Marca del producto
        int medida,            // Medida del producto
        String unidadMedida,   // Unidad de medida
        int precio,            // Precio del producto
        int stock,             // Cantidad en stock
        int descuento          // Descuento aplicable
) {
    // Consulta para actualizar los datos del producto
    String queryUpdate = "UPDATE producto SET nombre = ?, marca = ?, medida = ?, unidad_medida = ?, precio = ?, stock = ?, descuento = ? WHERE id_producto = ?";

    try {
        // Establecer conexión a la base de datos
        Connection con = BaseDeDatos.conectar();

        // Preparar la consulta de actualización
        PreparedStatement psUpdate = con.prepareStatement(queryUpdate);
        psUpdate.setString(1, nombre);          // Asigna el nombre del producto
        psUpdate.setString(2, marca);           // Asigna la marca del producto
        psUpdate.setInt(3, medida);             // Asigna la medida del producto
        psUpdate.setString(4, unidadMedida);    // Asigna la unidad de medida
        psUpdate.setInt(5, precio);             // Asigna el precio del producto
        psUpdate.setInt(6, stock);              // Asigna el stock disponible
        psUpdate.setInt(7, descuento);          // Asigna el descuento aplicable
        psUpdate.setInt(8, id_producto);        // Asigna el ID del producto a actualizar

        // Ejecutar la actualización
        int rowsAffected = psUpdate.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Producto actualizado con éxito");
            return true;
        } else {
            System.out.println("No se encontró el producto con el ID especificado");
            return false;
        }

    } catch (SQLException ex) {
        System.out.println("ERROR [SQL UPDATE]: No se pudo actualizar el producto");
        ex.printStackTrace();
        return false;
    }
}


    
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
    
    public static boolean eliminarProducto(int id_producto) {
        // Consulta para eliminar el producto basado en el id_producto
        String queryDelete = "DELETE FROM producto WHERE id_producto = ?";

        try {
            // Establecer conexión a la base de datos
            Connection con = BaseDeDatos.conectar();

            // Preparar la consulta de eliminación
            PreparedStatement psDelete = con.prepareStatement(queryDelete);
            psDelete.setInt(1, id_producto); // Establecer el id_producto a eliminar

            // Ejecutar la eliminación
            int filasAfectadas = psDelete.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado con éxito");
                return true;
            } else {
                System.out.println("No se encontró el producto con id: " + id_producto);
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR [SQL DELETE]: No se pudo eliminar el producto");
            ex.printStackTrace();
            return false;
        }
    }

    
}
