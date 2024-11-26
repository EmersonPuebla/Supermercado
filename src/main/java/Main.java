/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import view.Login;

public class Main {
    public static void main(String[] args) {
        // Asegurarse de que la interfaz gráfica se ejecute en el hilo adecuado
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);  // Muestra la ventana
            }
        });
    }
}
