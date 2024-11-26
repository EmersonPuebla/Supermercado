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

public class VentaDAO {
public static int obtenerFolio() {
    String query = "SELECT MAX(id_venta) FROM venta";  // Consulta para obtener el id_venta máximo
    int siguienteId = 1;  // Valor predeterminado

    try {
        // Establecer conexión a la base de datos
        Connection con = BaseDeDatos.conectar();

        // Preparar la consulta para obtener el valor máximo de id_venta
        PreparedStatement ps = con.prepareStatement(query);

        // Ejecutar la consulta
        ResultSet rs = ps.executeQuery();

        // Si hay un resultado, obtener el valor máximo
        if (rs.next()) {
            siguienteId = rs.getInt(1) + 1;  // sumar 1 al valor máximo
        }

        // Si no hay registros en la tabla, el siguiente id_venta será 1
        if (siguienteId == 0) {
            siguienteId = 1;
        }

    } catch (SQLException ex) {
        System.out.println("ERROR [SQL vDAO]: No se pudo obtener el siguiente id_venta");
    } catch (java.lang.NullPointerException npe) {
        System.out.println("ERROR [SQL vDAO]: No se logro conectar con la base de datos");
    }

    return siguienteId;
}



    
}
