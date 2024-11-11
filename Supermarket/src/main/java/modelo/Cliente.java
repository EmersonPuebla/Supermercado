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
public class Cliente extends Persona {
    private int puntos;

    public Cliente(int puntos, String run, String digitoVerificador, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno) {
        super(run, digitoVerificador, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
