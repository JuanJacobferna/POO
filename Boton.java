// Boton.java
// Clase base simple que representa un botón con estado encendido/apagado.
// Contiene un pequeño main para probar su comportamiento.

public class Boton {
    // Atributo que indica si la luz del botón está encendida
    protected boolean encendido;

    // Constructor: por defecto el botón inicia apagado
    public Boton() {
        this.encendido = false;
    }

    /**
     * Presiona el botón.
     * Si el botón estaba apagado lo enciende y devuelve true.
     * Si ya estaba encendido devuelve false.
     */
    public boolean presionar() {
        if (!encendido) {
            encendido = true;
            return true;
        }
        return false;
    }

    /**
     * Cancela/apaga el botón (apaga la luz).
     */
    public void cancelar() {
        encendido = false;
    }

    /**
     * Getter para saber si el botón está encendido.
     */
    public boolean isEncendido() {
        return encendido;
    }

    // --- Método de prueba (main) para ejecutar esta clase de forma independiente ---
    public static void main(String[] args) {
        Boton b = new Boton();
        System.out.println("Estado inicial (debe ser false): " + b.isEncendido());

        boolean primera = b.presionar();
        System.out.println("Presionar() devuelve (debe ser true): " + primera);
        System.out.println("Estado después de presionar (debe ser true): " + b.isEncendido());

        boolean segunda = b.presionar();
        System.out.println("Presionar nuevamente (debe ser false porque ya estaba encendido): " + segunda);

        b.cancelar();
        System.out.println("Estado después de cancelar (debe ser false): " + b.isEncendido());
    }
}
