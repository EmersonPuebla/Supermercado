package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Empleado extends Persona implements IPermissions {
    private int id;
    private String username;
    private String password;
    private boolean[] permissions;
    private boolean isEnabled;

    public Empleado(
            String rut,
            String primerNombre,
            String segundoNombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String password,
            boolean[] permissions) {
        super(rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);

        this.id = 1;
        this.username = crearUsername(primerNombre, apellidoPaterno);
        this.password = hashString(password); // La password se almacena hacheada
        this.permissions = permissions;

        // por defecto al momento de crear un usuario (empleado) esta habilitado
        this.isEnabled = true;
    }

    //----getters----
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    //----setters----
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //----getters (IPermissions)----
    public String getPermissions() {
        String permission; 
        

        if (permissions[0]) {
            permission = "Administrador (Acceso Total)";
        } 
        else if (!permissions[1] && !permissions[2] && !permissions[3]){
            permission = "Sin acceso";
        }
        else {
            permission = "Con acceso a: ";
            if (permissions[1]) { permission += "Reportes "; };
            if (permissions[2]) { permission += "Cajero "; };
            if (permissions[3]) { permission += "Bodega"; };
        }
        return permission;
    }
    

    public String isEnabled() {
        if (isEnabled == true) {
            return "El empleado " + getUsername() + "esta habilitado";
        } else {
            return "El empleado " + getUsername() + "esta deshabilitado";
        }
    }

    //----setters (IPermissions)----
    public void setPermissions(boolean[] permissions) {
        if (permissions.length > 4) {
            throw new IllegalArgumentException("ERROR: El número máximo de permisos permitidos es 4");
        } else {
            this.permissions = permissions;
        }        
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    //----customs----
    public static String hashString(String input) {
        try {
            // No entiendo muy bien como hace el hash
            // sin embargo, si le sumáramos algo al input
            // podría servir como salt aunque realmente no es necesario
            // o eso creo, tampoco es un software comercial como tal :v
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("ERROR [hashString]: ");
        }
    }  

    public static boolean compararHash(String textoOriginal, String hash) {
        String Hash = hashString(textoOriginal);
        return Hash.equals(hash);
        // devuelve true/false dependiendo de si es igual o no
    }

    private String crearUsername(String primerNombre, String apellidoPaterno){
        String username = primerNombre.substring(0, 1) + apellidoPaterno;
        return username.toLowerCase();
    }

    //----toDelete----
    public String getPassword() {
        return password;
    }

    //----toString----
    @Override
    public String toString() {
        return 
                // !!! password solo para pruebas no producto final
                "Password: " + getPassword() + "\n" +

                "IdEmpleado: " + getId()
                + "\nUsername: " + getUsername()
                + "\nPermisos: " + getPermissions() + "\n"
                + super.toString();
    }
}
