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
public class Categoria {
    private String idCategoria;
    private String nombreCategoria;
    private String ubicacionCategoria;

    public Categoria(String idCategoria, String nombreCategoria, String ubicacionCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.ubicacionCategoria = ubicacionCategoria;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getUbicacionCategoria() {
        return ubicacionCategoria;
    }

    public void setUbicacionCategoria(String ubicacionCategoria) {
        this.ubicacionCategoria = ubicacionCategoria;
    }
    
    
}
