package model;

public class Producto {
    public static final String[] UNIDADES_DE_MEDIDA = {
        "mg",    // Miligramos
        "g",     // Gramos
        "kg",    // Kilogramos
        "l",     // Litros
        "ml",    // Mililitros
        "u"      // Unidad ??  
    
        // TO DO: Revisar si queda alguna por añadir
    };

    private int id;
    private int cantidad;
    private String nombre;
    private int medida;
    private String unidadMedida;
    private int precio;
    private int stock;
    private int descuento;

    public Producto(int cantidad,
            String nombre,
            int medida,
            String unidadMedida,
            int precio, 
            int stock, 
            int descuento
        ) {
        
        //----verificadores----
        if (!isUnidadMedidaValido(unidadMedida)) {
            throw new IllegalArgumentException("ERROR [PRODUCTO]: Unidad de medida inválida");
        } else if (precio <= 0) {
            throw new IllegalArgumentException("ERROR [PRODUCTO]: El precio no puede ser menor o igual a cero");
        } else if (stock <= 0) {
            throw new IllegalArgumentException("ERROR [PRODUCTO]: El stock no puede ser menor o igual a cero");
        } else if (descuento < 0 && descuento > 100) {
            throw new IllegalArgumentException("ERROR [PRODUCTO]: El descuento no puede ser menor que <0 o mayor que >100");
        }

        // TO DO: el id debe ser auto-incremental
        this.id = 1; 
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
    }

    //----getters----
    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMedida() {
        return medida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getDescuento() {
        return descuento + "%";
    }

    //----setters----
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    //----customs----
    public static boolean isUnidadMedidaValido(String unidadMedida){
        for (String unidad : UNIDADES_DE_MEDIDA) {
            if (unidad.toLowerCase().equals(unidadMedida.toLowerCase())) {
                return true;
            }
        }
        return false;
    };

    //----toString----
    @Override
    public String toString() {
        return getId() + " " + 
            getCantidad() + "x " +
            getNombre() +  " " +
            getMedida() + " " +  
            getUnidadMedida() + " " +
            getPrecio() + " ";
    }

}