package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneradorDatos {

    private static final List<String> NOMBRES = Arrays.asList(
            "Carlos", "Luis", "Pedro", "Juan", "Javier", "Roberto", "Miguel",
            "Andrés", "José", "Hugo", "Ricardo", "Daniel", "Sebastián", "Diego", "Francisco",
            "Adrián", "Santiago", "Alejandro", "Fernando", "Cristian", "David", "Manuel",
            "Pablo", "Óscar", "Raúl", "Antonio", "Enrique", "Felipe", "Arturo", "Armando",
            "Julio", "César", "Bruno", "Gabriel", "Vicente", "Marcos", "Tomás", "Iván", "Emilio"
    );

    private static final List<String> APELLIDOS = Arrays.asList(
            "González", "Pérez", "Rodríguez", "López", "Martínez", "Sánchez",
            "Ramírez", "Hernández", "Díaz", "Vásquez", "Torres", "Flores", "Morales",
            "Gutiérrez", "Castro", "Alvarado", "Cruz", "Mendoza", "Guerrero", "Ortega",
            "Romero", "Vargas", "Delgado", "Ortiz", "Jiménez", "Reyes", "Ríos", "Navarro",
            "Suárez", "Figueroa", "Domínguez", "Carrillo", "Cabrera", "Arroyo", "Campos",
            "Paredes", "Montoya", "Santana", "Esquivel", "Barrios", "Salinas", "Cervantes"
    );

    private static final Random RANDOM = new Random();

    public static String obtenerNombreAleatorio() {
        return NOMBRES.get(RANDOM.nextInt(NOMBRES.size()));
    }

    public static String obtenerApellidoAleatorio() {
        return APELLIDOS.get(RANDOM.nextInt(APELLIDOS.size()));
    }
}
