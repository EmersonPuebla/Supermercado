package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVentaDAO {

    // Método genérico para obtener las filas de venta_producto por un campo de búsqueda
    public static List<String[]> obtenerFilasDetalleVentaPorCampo(String campoBusqueda, String valorBusqueda) {
        if (valorBusqueda == null || valorBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un valor en el campo de búsqueda para continuar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Advertencia: Valor de búsqueda no ingresado en el campo " + campoBusqueda + ".");
            return new ArrayList<>();
        }

        String query = "SELECT id_venta, id_producto, cantidad, precio_unitario, descuento FROM venta_producto WHERE " + campoBusqueda + " = ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, valorBusqueda);  // Usamos el valor de búsqueda para el PreparedStatement
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("id_producto");
                
                int codigo = Integer.parseInt(fila[1]);
                
                fila[2] = ProductoDAO.getNombre(codigo) + " " + ProductoDAO.getMarca(codigo) + " " + ProductoDAO.getMedida(codigo) + ProductoDAO.getUnidadMedida(codigo);
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("precio_unitario");
                fila[5] = rs.getString("descuento");
               
                filas.add(fila); 
            }
            if (valorBusqueda.trim().equals("-")) {
                JOptionPane.showMessageDialog(null,
                        "Debes ingresar un valor para poder buscar detalles de venta\nPorfavor completa la casilla faltante",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            } else if (filas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron detalles de venta con los valores especificados",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("No se encontraron detalles de venta con " + campoBusqueda + ": " + valorBusqueda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer los detalles de venta",
                    "ERROR SQL",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR [SQL]: No se pudo leer los detalles de venta");
            e.printStackTrace();
        }
        return filas;
    }

}
