// src/Main.java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
            new Producto("Leche", 2),
            new Producto("Pan", 1),
            new Producto("Huevos", 3),
            new Producto("Queso", 4),
            new Producto("Jamón", 5),
            new Producto("Cereal", 2),
            new Producto("Jugo", 3),
            new Producto("Yogurt", 1),
            new Producto("Manzanas", 2),
            new Producto("Naranjas", 3)
        );

        Cliente cliente1 = new Cliente("Cliente 1", productos);
        Cliente cliente2 = new Cliente("Cliente 2", productos);
        Cliente cliente3 = new Cliente("Cliente 3", productos);
        Cliente cliente4 = new Cliente("Cliente 4", productos);
        Cliente cliente5 = new Cliente("Cliente 5", productos);

        long initialTime = System.currentTimeMillis();

        Thread cajera1 = new Thread(new Cajera("Cajera 1", cliente1, initialTime));
        Thread cajera2 = new Thread(new Cajera("Cajera 2", cliente2, initialTime));
        Thread cajera3 = new Thread(new Cajera("Cajera 3", cliente3, initialTime));
        Thread cajera4 = new Thread(new Cajera("Cajera 4", cliente4, initialTime));
        Thread cajera5 = new Thread(new Cajera("Cajera 5", cliente5, initialTime));

        cajera1.start();
        cajera2.start();
        cajera3.start();
        cajera4.start();
        cajera5.start();
    }
}
