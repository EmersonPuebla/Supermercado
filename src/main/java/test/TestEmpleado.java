package test;

import model.Empleado;

public class TestEmpleado {
    public static void main(String[] args) {
        //----determina los permisos del empleado----
        // 0: Administrador
        // 1: Reportes
        // 2: Caja
        // 3: Bodega
        boolean[] permissions = { false, false, true, true };

        //----instancia empleado----
        Empleado empleado = new Empleado(

                "1-1",
                "Emerson",
                "Flavio",
                "Puebla",
                "Diaz",
                "PanConQueso123@",
                permissions);

        //----imprime info empleado----
        System.out.println(empleado.toString());
    }
}