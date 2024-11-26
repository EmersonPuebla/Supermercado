package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {
        // Método genérico para obtener todas las filas de la venta por un rango de fechas
    public static List<String[]> obtenerFilasVentaPorRangoFechas(String fechaDesde, String fechaHasta) {
        String query = "SELECT id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto FROM venta WHERE fecha_venta BETWEEN ? AND ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, fechaDesde);  // Fecha de inicio
            ps.setString(2, fechaHasta);  // Fecha de fin
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Asignamos los valores de la fila a un arreglo de String
                String[] fila = new String[6];  // Hay 6 columnas en la consulta
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("rut_cliente");
                fila[2] = rs.getString("rut_vendedor");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("metodo_pago");
                fila[5] = rs.getString("monto");
                filas.add(fila);  // Agregamos la fila a la lista
            }
            if (filas.isEmpty()) {
                System.out.println("No se encontraron ventas entre las fechas " + fechaDesde + " y " + fechaHasta);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer las ventas");
            e.printStackTrace();
        }
        return filas;
    }
    
    // Método genérico para obtener todas las filas de la venta como una lista de String[]
    public static List<String[]> obtenerFilasVentaPorCampo(String campoBusqueda, String valorBusqueda) {
        String query = "SELECT id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto FROM venta WHERE " + campoBusqueda + " = ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, valorBusqueda);  // Usamos el valor de búsqueda para el PreparedStatement
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Asignamos los valores de la fila a un arreglo de String
                String[] fila = new String[6];  // Hay 6 columnas en la consulta
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("rut_cliente");
                fila[2] = rs.getString("rut_vendedor");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("metodo_pago");
                fila[5] = rs.getString("monto");
                filas.add(fila);  // Agregamos la fila a la lista
            }
            if (filas.isEmpty()) {
                System.out.println("No se encontraron ventas con " + campoBusqueda + ": " + valorBusqueda);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer las ventas");
            e.printStackTrace();
        }
        return filas;
    }

    // Métodos específicos para obtener las filas completas por distintos campos
    public static List<String[]> getFilasVentaPorIdVenta(int id_venta) {
        return obtenerFilasVentaPorCampo("id_venta", String.valueOf(id_venta));
    }

    public static List<String[]> getFilasVentaPorRutCliente(String rut_cliente) {
        return obtenerFilasVentaPorCampo("rut_cliente", rut_cliente);
    }

    public static List<String[]> getFilasVentaPorRutVendedor(String rut_vendedor) {
        return obtenerFilasVentaPorCampo("rut_vendedor", rut_vendedor);
    }

    public static List<String[]> getFilasVentaPorFechaVenta(String fecha_venta) {
        return obtenerFilasVentaPorCampo("fecha_venta", fecha_venta);
    }

    public static List<String[]> getFilasVentaPorMetodoPago(String metodo_pago) {
        return obtenerFilasVentaPorCampo("metodo_pago", metodo_pago);
    }

    public static List<String[]> getFilasVentaPorMonto(String monto) {
        return obtenerFilasVentaPorCampo("monto", monto);
    }
}
