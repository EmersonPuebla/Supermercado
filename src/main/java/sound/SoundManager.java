package sound;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import javazoom.jl.player.Player;

public class SoundManager {

    public static void sonido(String ruta) {
        new Thread(() -> {
            try {
                URL soundURL = SoundManager.class.getResource(ruta);
                File soundFile = new File(soundURL.getFile());

                Player player = new Player(new FileInputStream(soundFile));
                player.play();
            } catch (Exception e) {
                System.err.println("Error al reproducir el archivo MP3: " + e.getMessage());
            }
        }).start();
    }

    public static void reproducirSonido(String nombreSonido) {
        switch (nombreSonido) {
            case "addProducto":
                sonido("/sound/addProducto.mp3");
                break;

            case "question":
                sonido("/sound/question.mp3");
                break;
            
            case "login":
                sonido("/sound/login.mp3");
                break;
                
            case "cobrar":
                sonido("/sound/cobrar.mp3");
                break;
                
            case "error":
                sonido("/sound/error.mp3");
                break;
                
            case "orale":
                sonido("/sound/orale.mp3");
                break;
                
            case "clean":
                sonido("/sound/clean.mp3");
                break;
                
            default:
                System.err.println("Sonido no reconocido: " + nombreSonido);
        }
    }
}
