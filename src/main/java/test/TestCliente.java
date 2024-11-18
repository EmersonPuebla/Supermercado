package src.main.java.test;
import src.main.java.model.*;

public class TestCliente {
    public static void main(String[] args) {
        //----instancia Cliente----
        Cliente cliente = new Cliente(
                "2-2",
                "Luis",
                "Antonio",
                "Alvarez",
                "Requejo"
            );

        //----imprime info cliente----
        System.out.println(cliente.toString());
    }
}
