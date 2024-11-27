package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.GeneradorDatos;

public class VentaDAO {

    private static final String CLIENTE_ANONIMO = "-";

    public static int obtenerFolio() {
        String query = "SELECT MAX(id_venta) FROM venta";
        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxId = rs.getInt(1);
                return maxId > 0 ? maxId + 1 : 1;
            }
            return 1;

        } catch (SQLException ex) {
            System.out.println("ERROR [SQL vDAO]: No se pudo obtener el siguiente id_venta");
            return 1;
        }
    }

    public static boolean verificarYAgregarCliente(String rut) {
        if (esClienteAnonimo(rut)) {
            return insertarClienteAnonimo();
        }

        try (Connection con = BaseDeDatos.conectar()) {
            if (clienteExiste(con, rut)) {
                return true;
            }
            return insertarNuevoCliente(con, rut);
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo verificar o insertar el cliente");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean esClienteAnonimo(String rut) {
        return rut == null || rut.trim().equals(CLIENTE_ANONIMO);
    }

    private static boolean clienteExiste(Connection con, String rut) throws SQLException {
        String queryExiste = "SELECT COUNT(*) FROM cliente WHERE rut = ?";
        try (PreparedStatement ps = con.prepareStatement(queryExiste)) {
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    private static boolean insertarClienteAnonimo() {
        String queryExiste = "SELECT COUNT(*) FROM cliente WHERE rut = ?";
        String queryInsertar = "INSERT INTO cliente (rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, puntos) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = BaseDeDatos.conectar()) {
            // Verificar si ya existe el cliente anónimo
            if (clienteExiste(con, CLIENTE_ANONIMO)) {
                return true;
            }

            // Si no existe, lo creamos
            try (PreparedStatement ps = con.prepareStatement(queryInsertar)) {
                ps.setString(1, CLIENTE_ANONIMO);
                ps.setString(2, CLIENTE_ANONIMO);
                ps.setString(3, CLIENTE_ANONIMO);
                ps.setString(4, CLIENTE_ANONIMO);
                ps.setString(5, CLIENTE_ANONIMO);
                ps.setInt(6, 0);

                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo insertar el cliente anónimo");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean insertarNuevoCliente(Connection con, String rut) throws SQLException {
        String queryInsertar = "INSERT INTO cliente (rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, puntos) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(queryInsertar)) {
            ps.setString(1, rut);
            ps.setString(2, GeneradorDatos.obtenerNombreAleatorio());
            ps.setString(3, GeneradorDatos.obtenerNombreAleatorio());
            ps.setString(4, GeneradorDatos.obtenerApellidoAleatorio());
            ps.setString(5, GeneradorDatos.obtenerApellidoAleatorio());
            ps.setInt(6, 0);

            return ps.executeUpdate() > 0;
        }
    }

    public static String obtenerRutVendedor(String username) {
        String query = "SELECT rut FROM empleado WHERE username = ?";

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("rut");
                }
                System.out.println("No se encontró el vendedor con username: " + username);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el rut del vendedor");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertarVenta(int folio, String rut, String metodoPago, String fecha, int total, String username) {
        // Aseguramos que exista el cliente (sea anónimo o no)
        if (!verificarYAgregarCliente(rut)) {
            System.out.println("Error: No se pudo verificar o agregar al cliente.");
            return false;
        }

        String rutVendedor = obtenerRutVendedor(username);
        if (rutVendedor == null) {
            System.out.println("Error: No se pudo obtener el rut del vendedor.");
            return false;
        }

        // Procesar la venta y actualizar puntos si corresponde
        try (Connection conn = BaseDeDatos.conectar()) {
            conn.setAutoCommit(false);
            try {
                // Insertar la venta
                if (!insertarVentaEnBD(conn, folio, rut, rutVendedor, fecha, metodoPago, total)) {
                    throw new SQLException("No se pudo insertar la venta");
                }

                // Actualizar puntos solo si el cliente no es anónimo
                if (!esClienteAnonimo(rut)) {
                    if (!actualizarPuntosCliente(conn, rut, total)) {
                        throw new SQLException("No se pudieron actualizar los puntos del cliente");
                    }
                }

                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: Error al procesar la venta");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean insertarVentaEnBD(Connection conn, int folio, String rut, String rutVendedor,
            String fecha, String metodoPago, int total) throws SQLException {
        String sqlVenta = "INSERT INTO venta (id_venta, rut_cliente, rut_vendedor, fecha_venta, metodo_pago, monto) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sqlVenta)) {
            ps.setInt(1, folio);
            ps.setString(2, esClienteAnonimo(rut) ? CLIENTE_ANONIMO : rut);
            ps.setString(3, rutVendedor);
            ps.setString(4, fecha);
            ps.setString(5, metodoPago);
            ps.setInt(6, total);

            return ps.executeUpdate() > 0;
        }
    }

    private static boolean actualizarPuntosCliente(Connection conn, String rut, int total) throws SQLException {
        String sqlPuntos = "UPDATE cliente SET puntos = puntos + ? WHERE rut = ?";
        int puntosGanados = calcularPuntosGanados(total);

        try (PreparedStatement ps = conn.prepareStatement(sqlPuntos)) {
            ps.setInt(1, puntosGanados);
            ps.setString(2, rut);
            return ps.executeUpdate() > 0;
        }
    }

    private static int calcularPuntosGanados(int total) {
        // Por ejemplo, 1 punto por cada $1000 gastados
        return total / 1000;
    }

    public static boolean insertarVentaProducto(int folio, String codigo, int cantidad, int precioUnitario, int descuento) {
        String sqlVentaProducto = "INSERT INTO venta_producto (id_venta, id_producto, cantidad, precio_unitario, descuento) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = BaseDeDatos.conectar(); PreparedStatement ps = conn.prepareStatement(sqlVentaProducto)) {

            ps.setInt(1, folio);
            ps.setString(2, codigo);
            ps.setInt(3, cantidad);
            ps.setInt(4, precioUnitario);
            ps.setInt(5, descuento);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: Error al insertar productos de la venta");
            e.printStackTrace();
            return false;
        }
    }
}
