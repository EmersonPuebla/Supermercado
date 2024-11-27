package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneradorDatos {

    private static final List<String> NOMBRES = Arrays.asList(
        "Carlos", "Luis", "Pedro", "Juan", "Javier", "Roberto", "Miguel", 
        "Andrés", "José", "Hugo", "Ricardo", "Daniel", "Sebastián", "Diego", "Francisco"
    );

    private static final List<String> APELLIDOS = Arrays.asList(
        "González", "Pérez", "Rodríguez", "López", "Martínez", "Sánchez", 
        "Ramírez", "Hernández", "Díaz", "Vásquez", "Torres", "Flores", "Morales", 
        "Gutiérrez", "Castro"
    );

    private static final Random RANDOM = new Random();

    public static String obtenerNombreAleatorio() {
        return NOMBRES.get(RANDOM.nextInt(NOMBRES.size()));
    }

    public static String obtenerApellidoAleatorio() {
        return APELLIDOS.get(RANDOM.nextInt(APELLIDOS.size()));
    }
}
