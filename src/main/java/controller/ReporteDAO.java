/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteDAO {

    public static String getRutCliente(int folio) {
        String query = "SELECT rut_cliente FROM venta WHERE id_venta = ?";
        String rut_cliente = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, folio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rut_cliente = rs.getString("rut_cliente");
            } else {
                System.out.println("No se encontró una venta con el folio: " + folio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la venta");
            e.printStackTrace();
        }
        return rut_cliente;
    }

    public static String getRutVendedor(int folio) {
        String query = "SELECT rut_vendedor FROM venta WHERE id_venta = ?";
        String rut_vendedor = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, folio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rut_vendedor = rs.getString("rut_vendedor");
            } else {
                System.out.println("No se encontró una venta con el folio: " + folio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la venta");
            e.printStackTrace();
        }
        return rut_vendedor;
    }

    public static String getFechaVenta(int folio) {
        String query = "SELECT fecha_venta FROM venta WHERE id_venta = ?";
        String fecha_venta = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, folio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fecha_venta = rs.getString("fecha_venta");
            } else {
                System.out.println("No se encontró una venta con el folio: " + folio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la venta");
            e.printStackTrace();
        }
        return fecha_venta;
    }

    public static String getMetodoPago(int folio) {
        String query = "SELECT metodo_pago FROM venta WHERE id_venta = ?";
        String metodo_pago = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, folio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                metodo_pago = rs.getString("metodo_pago");
            } else {
                System.out.println("No se encontró una venta con el folio: " + folio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la venta");
            e.printStackTrace();
        }
        return metodo_pago;
    }

    public static String getMontoVenta(int folio) {
        String query = "SELECT monto FROM venta WHERE id_venta = ?";
        String monto = null;

        try (Connection con = BaseDeDatos.conectar(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, folio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                monto = rs.getString("monto");
            } else {
                System.out.println("No se encontró una venta con el folio: " + folio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR [SQL]: No se pudo leer la venta");
            e.printStackTrace();
        }
        return monto;
    }

    public static void filtrarRangoFecha() {
    }

}
