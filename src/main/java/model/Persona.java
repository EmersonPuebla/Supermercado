package model;

public abstract class Persona {
    private String rut;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Persona(String rut,
            String primerNombre,
            String segundoNombre,
            String apellidoPaterno,
            String apellidoMaterno) {

        this.rut = rut;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    };

    //----setters----
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    //----getters----
    public String getRut() {
        return rut;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombreCompleto() {
        return getPrimerNombre() + " "
            + getSegundoNombre() + " "
            + getApellidoPaterno() + " "
            + getApellidoMaterno();
    }
    //----toString----
    @Override
    public String toString() {
        return "RUT: " + getRut()
                + "\nNombre: "
                + getNombreCompleto();
    }
}
