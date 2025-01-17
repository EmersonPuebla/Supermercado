package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReporteDAO {
    // Método genérico para obtener todas las filas de la venta por un rango de fechas
    public static List<String[]> obtenerFilasVentaPorRangoFechas(String fechaDesde, String fechaHasta) {
        if (fechaDesde.trim().equals("/  /") || fechaHasta.trim().equals("/  /")) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar ambas fechas para buscar las ventas.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Advertencia: Fechas no ingresadas para la búsqueda.");
            return new ArrayList<>();
        }

        String query = "SELECT id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto FROM venta WHERE fecha_venta BETWEEN ? AND ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, fechaDesde);  // Fecha de inicio
            ps.setString(2, fechaHasta);  // Fecha de fin
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] fila = new String[6];  // Hay 6 columnas en la consulta
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("rut_cliente");
                fila[2] = rs.getString("rut_vendedor");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("metodo_pago");
                fila[5] = rs.getString("monto");
                filas.add(fila);
            }
            if (filas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron ventas entre las fechas especificadas.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("No se encontraron ventas entre las fechas " + fechaDesde + " y " + fechaHasta);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer las ventas",
                    "ERROR SQL",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR [SQL]: No se pudo leer las ventas");
            e.printStackTrace();
        }
        return filas;
    }

    public static List<String[]> getFilasVentaPorRangoMonto(int desdeMonto, int hastaMonto) {
        if (desdeMonto == 0 && hastaMonto == 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un rango de montos válido para buscar las ventas.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Advertencia: Rango de montos inválido (0 a 0).");
            return new ArrayList<>();
        }

        String query = "SELECT id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto "
                + "FROM venta WHERE monto BETWEEN ? AND ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, desdeMonto);  // Monto mínimo
            ps.setInt(2, hastaMonto);  // Monto máximo
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("rut_cliente");
                fila[2] = rs.getString("rut_vendedor");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("metodo_pago");
                fila[5] = rs.getString("monto");
                filas.add(fila);
            }

            if (filas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron ventas en el rango de precio especificado:\n" + "$" + desdeMonto + "-" + "$" + hastaMonto,
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("No se encontraron ventas en el rango de montos: " + desdeMonto + " - " + hastaMonto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer las ventas por rango de montos",
                    "ERROR SQL",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR [SQL]: No se pudo leer las ventas por rango de montos");
            e.printStackTrace();
        }

        return filas;
    }

    public static List<String[]> obtenerFilasVentaPorCampo(String campoBusqueda, String valorBusqueda) {
        if (valorBusqueda == null || valorBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un valor en el campo de búsqueda para continuar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Advertencia: Valor de búsqueda no ingresado en el campo " + campoBusqueda + ".");
            return new ArrayList<>();
        }

        String query = "SELECT id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto FROM venta WHERE " + campoBusqueda + " = ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, valorBusqueda);  // Usamos el valor de búsqueda para el PreparedStatement
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_venta");
                fila[1] = rs.getString("rut_cliente");
                fila[2] = rs.getString("rut_vendedor");
                fila[3] = rs.getString("fecha_venta");
                fila[4] = rs.getString("metodo_pago");
                fila[5] = rs.getString("monto");
                filas.add(fila);
            }
            if (valorBusqueda.trim().equals("-")){
                JOptionPane.showMessageDialog(null,
                    "Debes ingresar un valor para poder buscar ventas\nPorfavor completa la casilla faltante",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            } else if (filas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron ventas con los valores especificados",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("No se encontraron ventas con " + campoBusqueda + ": " + valorBusqueda);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer las ventas",
                    "ERROR SQL",
                    JOptionPane.ERROR_MESSAGE);
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
}
