package model;

public class Cliente extends Persona {
    private int puntos;

    public Cliente(String rut,
            String primerNombre,
            String segundoNombre,
            String apellidoPaterno,
            String apellidoMaterno) {
        super(rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);

        // por defecto al momento de añadir un
        // nuevo cliente sus puntos inician en 0
        puntos = 0;
    }

    //----getters----
    public int getPuntos() {
        return puntos;
    }

    //----setters----
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //----toString----
    @Override
    public String toString() {
        return "Puntos: " + getPuntos() + "\n" + super.toString();
    }
}
