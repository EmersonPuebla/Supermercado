/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author TUTE
 */
public class TestHerencia {
    public static void main(String[] args) {
        Cliente tute = new Cliente(0, "1-1", "Emerson", "Flavio", "Puebla", "Diaz");
        Cajero tony = new Cajero("245", "Tony", "PanConQueso12@", "2-4", "Luis", "Antonio", "Alvarez", "Requejo");


        System.out.println(tony.toString());
        System.out.println(tute.toString());
    }
}
