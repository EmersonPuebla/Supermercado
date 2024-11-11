/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Laboratorio
 */
public class Empresa {
    private String rut;
    private String nombre;
    private String direccion;

    public Empresa(String rut, String nombre, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // setters
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // getters
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "RUT: " + getRut() + "\n"
                + "NOMBRE: " + getNombre() + "\n"
                + "DIRECCION: " + getDireccion();
    }
}

