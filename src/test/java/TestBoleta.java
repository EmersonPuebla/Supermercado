

import model.Empleado;
import model.Producto;
import model.Boleta;

public class TestBoleta {
    public static void main(String[] args) {
        // ----determina los permisos del empleado----
        // 0: Administrador
        // 1: Reportes
        // 2: Caja
        // 3: Bodega
        boolean[] permissions = { false, false, false, false };

        // ----Instanciar 3 productos----
        Producto producto1 = new Producto(2, "Azúcar", "Zucarita", 1, "kg", 1000, 50, 20);
        Producto producto2 = new Producto(4, "Leche", "Malaya", 1, "l", 1000, 20, 50);
        Producto producto3 = new Producto(7, "Pan", "Panote", 1, "u", 100, 200, 0);

        // ----crear un array de productos----
        Producto[] productos = { producto1, producto2, producto3 };

        // ----instancia empleado----
        Empleado cajero = new Empleado(
                "1-1",
                "Emerson",
                "Flavio",
                "Puebla",
                "Diaz",
                "PanConQueso123@",
                permissions);

        // ----instancia boleta----
        Boleta boleta = new Boleta(cajero, productos, "efectivo");

        // ----imprime el detalle de la boleta----
        System.out.println(boleta.toString());

    }
}
