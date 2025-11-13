// BotonPiso.java
// Representa un botón externo (en el pasillo del edificio)
// que permite solicitar el ascensor para subir o bajar.

public class BotonPiso extends Boton {
    private String direccion; // "subir" o "bajar"

    // Constructor: recibe la dirección del botón
    public BotonPiso(String direccion) {
        super(); // Llama al constructor de Boton
        this.direccion = direccion;
    }

    // Devuelve la dirección del botón ("subir" o "bajar")
    public String getDireccion() {
        return direccion;
    }

    // Prueba de funcionamiento independiente
    public static void main(String[] args) {
        // Creamos dos botones: uno de subir y otro de bajar
        BotonPiso subir = new BotonPiso("subir");
        BotonPiso bajar = new BotonPiso("bajar");

        System.out.println("Botón de " + subir.getDireccion() + " encendido? " + subir.isEncendido());
        subir.presionar();
        System.out.println("Después de presionar: " + subir.isEncendido());

        System.out.println("\nBotón de " + bajar.getDireccion() + " encendido? " + bajar.isEncendido());
        bajar.presionar();
        System.out.println("Después de presionar: " + bajar.isEncendido());
    }
}
