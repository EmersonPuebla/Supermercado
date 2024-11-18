package model;

import java.util.Date;

public class Boleta {
    public static final int IVA = 19;
    public static final String[] METODOS_DE_PAGO = {
            "Debito", "Credito", "Efectivo", "EdenRed"
    };

    private int folio;
    private Date fecha;
    private Empleado cajero;
    private Producto[] productos;

    // TO DO: falta meter confirmaciones para el método de pago
    private String metodoDePago;
    private int neto;
    private int porcentajeIVA;
    private int total;

    public Boleta(
            Empleado cajero,
            Producto[] productos,
            String metodoDePago

        ) {
        if (!isMetodoDePagoValido(metodoDePago)) {
            throw new IllegalArgumentException("ERROR [BOLETA]: Método de pago inválido");
        }

        // TO DO: El folio debe ser auto-incremental
        this.folio = 1;

        this.fecha = new Date();
        this.cajero = cajero;
        this.productos = productos;
        this.metodoDePago = metodoDePago;
        this.neto = calcularNeto(productos);
        this.porcentajeIVA = calcularIVA(neto);
        this.total = neto + porcentajeIVA;
    };

    // ----getters----
    public int getFolio() {
        return folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public String getProductos(Producto[] productos) {
        String detalleProductos = "";

        for (Producto producto : productos) {
            detalleProductos += " || " + producto.toString();
        }
        return detalleProductos;
    }
    

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public int getNeto() {
        return neto;
    }

    public int getPorcentajeIVA() {
        return porcentajeIVA;
    }

    public int getTotal() {
        return total;
    }


    private int calcularNeto(Producto[] productos) {
        int neto = 0;
        for (Producto producto : productos) {
            int precio = calcularPrecioDescuento(
                                producto.getPrecio(), 
                                producto.getDescuento()) 
                        * producto.getCantidad();
            neto += precio;
        }
        return neto;
    }

    // ----customs----
    // tanto el calculo del IVA como la confirmación del método de pago
    // son static con el objetivo de poder llegar a reutilizarlos
    public static int calcularIVA(int neto) {
        double iva = IVA / 100.0;

        return (int) Math.round(neto * iva);
    }

    public static boolean isMetodoDePagoValido(String metodoDePago) {
        for (String metodo : METODOS_DE_PAGO) {
            if (metodo.toLowerCase().equals(metodoDePago.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int calcularPuntos(int neto) {
        return (int) Math.round(neto*0.05);
    }

    public static int calcularPrecioDescuento(int precioProducto, int descuento) {
        double foo = (100 - descuento) / 100;
        return (int) Math.round(precioProducto * foo);
    }

    // ----toString----
    @Override
    public String toString() {
        return "FOLIO: " + getFolio() +
                "\nCAJERO: " + cajero.getNombreCompleto() +
                "\nFECHA: " + fecha +
                "\nPRODUCTOS: " + getProductos(productos) +
                "\nMETODO DE PAGO: " + getMetodoDePago() +
                "\nPUNTOS: " + calcularPuntos(neto) +
                "\nNETO: " + neto +
                "\nIVA: " + porcentajeIVA +
                "\nTOTAL: " + total;
    }

}
