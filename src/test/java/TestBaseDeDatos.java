/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.BaseDeDatos;

/**
 *
 * @author TUTE
 */
public class TestBaseDeDatos {
    public static void main(String[] args) {
        BaseDeDatos db = new BaseDeDatos();
        
        db.conectar();
    }
}
