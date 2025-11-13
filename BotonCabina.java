// ⚽ ANALOGÍA FÚTBOL: Este es como el PANEL DE SUSTITUCIONES del entrenador
// Cada botón representa un JUGADOR que puede entrar (un piso específico)
// Cuando presionas un botón, es como decir "¡Quiero hacer un cambio con el jugador #3!"
// ¡También hereda del tablero básico (Boton)!

public class BotonCabina extends Boton {

    // ⚽ El número de JUGADOR que quieres llamar (el número de PISO que quieres
    // alcanzar)
    private int piso;

    // ⚽ CONSTRUCTOR: Crear un botón para un jugador/piso específico
    // Como asignar un número a cada jugador suplente en el banquillo
    public BotonCabina(int piso) {
        super(); // ⚽ Hereda las características del tablero básico
        this.piso = piso;
    }

    // ⚽ OBTENER PISO: ¿Qué número de jugador/piso representa este botón?
    // Como preguntarle al asistente: "¿Qué jugador quieres que entre?"
    public int getPiso() {
        return piso;
    }

    // ⚽ MÉTODO DE PRUEBA - Como revisar el panel de sustituciones antes del partido
    public static void main(String[] args) {
        BotonCabina b1 = new BotonCabina(3);
        System.out.println("Botón del piso " + b1.getPiso() + " encendido? " + b1.isEncendido());

        b1.presionar(); // ⚽ ¡Pedimos el jugador #3!
        System.out.println("Después de presionar: " + b1.isEncendido());

        b1.cancelar(); // ⚽ Cancelamos el cambio
        System.out.println("Después de cancelar: " + b1.isEncendido());
    }
}
