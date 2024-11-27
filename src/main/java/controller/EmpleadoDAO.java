package controller;

import java.sql.*;
import controller.BaseDeDatos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDAO {

    public static boolean agregarEmpleado(String rut, String primerNombre, String segundoNombre,
            String apellidoPaterno, String apellidoMaterno, String username, String password,
            boolean isAdministrador, boolean isReporte, boolean isCaja, boolean isBodega, boolean isHabilitado) {

        String sql = "INSERT INTO empleado (rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, username, password, isAdministrador, isReporte, isCaja, isBodega, isHabilitado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = BaseDeDatos.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Configurar los parámetros del PreparedStatement
            pstmt.setString(1, rut);
            pstmt.setString(2, primerNombre);
            pstmt.setString(3, segundoNombre);
            pstmt.setString(4, apellidoPaterno);
            pstmt.setString(5, apellidoMaterno);
            pstmt.setString(6, username);
            pstmt.setString(7, password);
            pstmt.setInt(8, isAdministrador ? 1 : 0);
            pstmt.setInt(9, isReporte ? 1 : 0);
            pstmt.setInt(10, isCaja ? 1 : 0);
            pstmt.setInt(11, isBodega ? 1 : 0);
            pstmt.setInt(12, isHabilitado ? 1 : 0);

            // Ejecutar la inserción
            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean actualizarEmpleado(String rut, String primerNombre,
            String segundoNombre, String apellidoPaterno, String apellidoMaterno,
            String username, String password, boolean isAdministrador,
            boolean isReporte, boolean isCaja, boolean isBodega, boolean isHabilitado) {

        String sql = "UPDATE empleado SET "
                + "primerNombre = ?, "
                + "segundoNombre = ?, "
                + "apellidoPaterno = ?, "
                + "apellidoMaterno = ?, "
                + "username = ?, "
                + "password = ?, "
                + "isAdministrador = ?, "
                + "isReporte = ?, "
                + "isCaja = ?, "
                + "isBodega = ?, "
                + "isHabilitado = ? "
                + "WHERE rut = ?";

        try (Connection conn = BaseDeDatos.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los valores en el PreparedStatement
            pstmt.setString(1, primerNombre);
            pstmt.setString(2, segundoNombre);
            pstmt.setString(3, apellidoPaterno);
            pstmt.setString(4, apellidoMaterno);
            pstmt.setString(5, username);
            pstmt.setString(6, password);
            pstmt.setInt(7, isAdministrador ? 1 : 0);
            pstmt.setInt(8, isReporte ? 1 : 0);
            pstmt.setInt(9, isCaja ? 1 : 0);
            pstmt.setInt(10, isBodega ? 1 : 0);
            pstmt.setInt(11, isHabilitado ? 1 : 0);
            pstmt.setString(12, rut);

            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null,
                        "Empleado actualizado exitosamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontró el empleado para actualizar",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminarEmpleado(String rut) {
        String sql = "DELETE FROM empleado WHERE rut = ?";

        try (Connection conn = BaseDeDatos.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rut); // Establece el RUT en el query

            // Ejecutar la eliminación
            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null,
                        "Empleado eliminado exitosamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontró el empleado con el RUT especificado.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar empleado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    public static List<String[]> obtenerFilasEmpleadoPorCampo(String campoBusqueda, String valorBusqueda) {
        if (valorBusqueda == null || valorBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un valor en el campo de búsqueda para continuar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Advertencia: Valor de búsqueda no ingresado en el campo " + campoBusqueda + ".");
            return new ArrayList<>();
        }

        String query = "SELECT rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, username, password, isAdministrador, isReporte, isCaja, isBodega, isHabilitado FROM empleado WHERE " + campoBusqueda + " = ?";
        List<String[]> filas = new ArrayList<>();

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, valorBusqueda);  // Usamos el valor de búsqueda para el PreparedStatement
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] fila = new String[12];
                fila[0] = rs.getString("rut");
                fila[1] = rs.getString("primerNombre");
                fila[2] = rs.getString("segundoNombre");
                fila[3] = rs.getString("apellidoPaterno");
                fila[4] = rs.getString("apellidoMaterno");
                fila[5] = rs.getString("username");
                fila[6] = rs.getString("password");
                fila[7] = rs.getString("isAdministrador");
                fila[8] = rs.getString("isReporte");
                fila[9] = rs.getString("isCaja");
                fila[10] = rs.getString("isBodega");
                fila[11] = rs.getString("isHabilitado");
                filas.add(fila);
            }
            if (valorBusqueda.trim().equals("-")) {
                JOptionPane.showMessageDialog(null,
                        "Debes ingresar un valor para poder buscar empleados\nPor favor completa la casilla faltante",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            } else if (filas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron empleados con los valores especificados",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("No se encontraron empleados con " + campoBusqueda + ": " + valorBusqueda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer los empleados",
                    "ERROR SQL",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR [SQL]: No se pudo leer los empleados");
            e.printStackTrace();
        }
        return filas;
    }

    public static String[] buscar(String rut) {
        String username = getUsernameAlt(rut);
        String[] nombreCompleto = getNombre(username);

        return nombreCompleto;

    }

    public static String getUsernameAlt(String Rut) {
        String query = "SELECT rut FROM empleado WHERE username = ?";
        String username = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, Rut);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
            } else {
                System.out.println("No se encontró un usuario con el rut: " + Rut);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el stock del producto");
            e.printStackTrace();
        }
        return username;
    }

    public static String[] getNombre(String inputUsername) {
        String query = "SELECT primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno FROM empleado WHERE username = ?";

        // Crear el arreglo que se retornará
        String[] nombreCompleto = new String[4];

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

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
                return new String[]{};  // Devuelve un arreglo vacío si no se encuentra el usuario
            }

        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer el username");
            e.printStackTrace();
            return new String[]{};  // Devuelve un arreglo vacío en caso de error
        }
        return nombreCompleto;  // Devolver el arreglo con los nombres y apellidos
    }

    public static String getUsername(String inputUsername) {
        String query = "SELECT username FROM empleado WHERE username = ?";
        String username = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

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

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

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

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

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
