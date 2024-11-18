package controller;
import model.*;

public class ClienteDAO {
    public static void agregar() {
        
        // INSERT -> Tabla de Clientes

    };

    public static boolean isRegistrado(String rut) {
        if (rut == "") {
            // TO DO: Aquí debe buscar en la tabla Clientes 
            //        y si lo encuentra devolver True
            return true;
        } else {
            return false;
        }
    }

    public static void sumarPuntos(Cliente cliente, int puntos) {
        // TO DO: Sí el cliente no se encuentra registrado en la
        //        base de datos lo debe añadir automáticamente
        //        utilizando el método agregar()

        int puntosActuales = cliente.getPuntos();

        cliente.setPuntos(puntosActuales + puntos);
    };  
}
