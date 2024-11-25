/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.EmpleadoDAO;
import java.util.Arrays;
/**
 *
 * @author TUTE
 */
public class TestEmpleadoSQL {
    public static void main(String[] args) {
        String username = "cgarcia";
        System.out.println(EmpleadoDAO.getPassword(username));
        System.out.println(Arrays.toString(EmpleadoDAO.getPermisos(username)));
 
        
    }
   
}
