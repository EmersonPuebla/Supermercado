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
public class Cajero extends Persona {
    private String id;
    private String username;
    private String password;

    public Cajero(String id, String username, String password, String run, String digitoVerificador, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno) {
        super(run, digitoVerificador, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
