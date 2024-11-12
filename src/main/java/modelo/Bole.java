package modelo;

public class Caja {

    Empresa walmart = new Empresa("777-1", "Walmart", "AV. Tupakmamani");

    // generar boleta
    public String generarBoleta() {
        return 
            "BOLETA \n"
            + "-------------- \n"
            + "FOLIO: \n"
            + "CADENA: \n"
            + "DIRECCION: \n"
       
            + "DATOS CLIENTE: \n"
            + "------------- \n"
            + "RUT: \n"
            + "NOMBRE: \n"
            + "PUNTOS: \n"
            
            + "SUCURSAL: \n"
            + "------------- \n"
            + "LOCAL: \n"
            + "FECHA: \n"
            + "ATENDIDO POR: \n"
            + "CAJA: \n"
            


            + "DETALLE COMPRA: \n"
            + "--------------- \n"
            + "CODIGO" + "DESCRIPCION" + "CANTIDAD" + "PRECIO" + "TOTAL" + "DESCUENTO \n"
            + "FOLIO: \n"
            
            + "METODO DE PAGO: \n"
        
            + "SUBTOTAL \n"
            + "------------- \n"
            + "NETO:$888 \n"
            + "IVA(x%): $888\n"
            + "TOTAL: $888 \n"

            
        ;

        /*
         * FOLIO: 376977
         * ----------------------------
         * RUT: 777-1
         * CADENA: WALMART
         * DIRECCION: AV. Tupakmamani
         * ----------------------------
         * DATOS CLIENTE
         * ----------------------------
         * RUT: 1-1
         * NOMBRE: SIPUE
         * PUNTOS: 1263
         * 
         * ----------------------------
         * SUCURSAL
         * ----------------------------
         * LOCAL: 47 San beka
         * FECHA: DD/MM/AA HH:MM:SS
         * ATENDIDO POR: id_cajero nombre_cajero
         * CAJA: id_caja
         * 
         * ----------------------------
         * DETALLE COMPRA
         * ----------------------------
         * CODIGO - DESCRIPCION - CANTIDAD - PRECIO - TOTAL - DESCUENTO
         * 856      Vianesa hellmans 1kg x1  $2500   $2500     -$250   
         *
         * METODO DE PAGO: 
         * ---------------------------
         * DEBITO/CREDITO/EFECTIVO/ENRED
         * 
         * ---------------------------
         * SUBTOTAL
         * ---------------------------
         * NETO: $2500
         * IVA(19%): 475 
         * TOTAL: 2975 
         * 
         */

    }
}
