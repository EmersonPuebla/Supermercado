package src.main.java.model;

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
            String metodoDePago,
            int neto
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
        this.neto = neto;
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
        StringBuilder resultado = new StringBuilder(); 
        for (Producto producto : productos) {
            resultado.append(producto.toString() + " // ");
        }
        return resultado.toString();
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

    // ----toString----
    @Override
    public String toString() {
        return "FOLIO: " + getFolio() +
                "\nCAJERO: " + cajero.getNombreCompleto() +
                "\nFECHA: " + fecha +
                "\nPRODUCTOS: " + getProductos(productos) +
                "\nMETODO DE PAGO: " + getMetodoDePago() +
                "\nNETO: " + neto +
                "\nIVA: " + porcentajeIVA +
                "\nTOTAL: " + total;
    }

}
