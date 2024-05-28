// src/Cajera.java
public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Cajera(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println(this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

        for (Producto producto : cliente.getProductos()) {
            this.esperarXsegundos(producto.getPrecio());
            System.out.println(this.nombre + " procesando el producto " + producto.getNombre() + " ->Precio: " + producto.getPrecio() + " en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }

        System.out.println(this.nombre + " HA TERMINADO DE PROCESAR " + this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    private void esperarXsegundos(double precio) {
        try {
            Thread.sleep((long) precio * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
