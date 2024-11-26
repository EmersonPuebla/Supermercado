package model;
import java.awt.event.KeyEvent;

public class Validador {

    public static void bloquearNumeros(KeyEvent evt) {
        // Obtener el código del carácter presionado
        char keyChar = evt.getKeyChar();

        // Verificar si el carácter es un número
        boolean esNumero = Character.isDigit(keyChar);

        if (esNumero) {
            // Consumir el evento para bloquearlo
            evt.consume();
        }
    }

    public static void bloquearLetras(KeyEvent evt) {
        // Obtener el código del carácter presionado
        char keyChar = evt.getKeyChar();

        // Verificar si el carácter es una letra
        boolean esLetra = Character.isLetter(keyChar);

        if (esLetra) {
            // Consumir el evento para bloquearlo
            evt.consume();
        }
    }
    
    public static void bloquearSimbolos(KeyEvent evt) {
        // Obtener el carácter presionado
        char keyChar = evt.getKeyChar();

        // Verificar si el carácter no es letra, número o espacio
        boolean esSimbolo = !Character.isLetterOrDigit(keyChar) && !Character.isWhitespace(keyChar);

        if (esSimbolo) {
            // Consumir el evento para bloquearlo
            evt.consume();
        }
    }
}
