// ⚽ ANALOGÍA FÚTBOL: Este es como el TABLERO ELECTRÓNICO del estadio
// Puede estar encendido (mostrando información) o apagado (sin información)
// Es la clase BASE - como el concepto general de "señal luminosa"

public class Boton {

    // ⚽ El "estado del tablero": ¿está iluminado o no?
    // Como cuando el tablero muestra "CAMBIO" o está apagado
    protected boolean encendido;

    // ⚽ CONSTRUCTOR: Al inicio del partido, el tablero está apagado
    public Boton() {
        this.encendido = false;
    }

    // ⚽ PRESIONAR = Como cuando el árbitro señala una falta
    // Solo se "enciende la señal" si no estaba ya encendida
    // Devuelve true si logró encender (falta nueva), false si ya estaba encendida
    // (falta repetida)
    public boolean presionar() {
        if (!encendido) {
            encendido = true;
            return true; // ⚽ ¡Señal nueva activada!
        }
        return false; // ⚽ Ya estaba activada, no hace nada
    }

    // ⚽ ENCENDER = Forzar que el tablero se ilumine
    // Como cuando encienden las luces del estadio para un partido nocturno
    public void encender() {
        encendido = true;
    }

    // ⚽ APAGAR = Apagar el tablero
    // Como al finalizar el partido, se apagan todas las señales
    public void apagar() {
        encendido = false;
    }

    // ⚽ CANCELAR = Mismo que apagar
    // Como cuando el VAR anula una decisión y se borra la señal del tablero
    public void cancelar() {
        encendido = false;
    }

    // ⚽ CONSULTAR ESTADO = ¿Está iluminado el tablero?
    // Como preguntarle al comentarista: "¿Hay alguna señal activa?"
    public boolean isEncendido() {
        return encendido;
    }

    // ⚽ MÉTODO DE PRUEBA - Como un entrenamiento antes del partido
    // Aquí probamos que todo funcione correctamente
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
