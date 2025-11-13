// ⚽ ANALOGÍA FÚTBOL: Este es como las BANDERAS de los ASISTENTES en la línea lateral
// Hay una bandera en cada ZONA del campo (cada piso del edificio)
// La bandera puede indicar "SUBIR" (atacar hacia arriba) o "BAJAR" (defender hacia abajo)
// ¡Hereda del tablero electrónico básico (Boton) pero con información específica de zona!

public class BotonPiso extends Boton {

    // ⚽ Atributos: información de la "bandera del asistente"
    private String direccion; // ⚽ "subir" o "bajar" - como señalar offside o saque de esquina
    private int piso; // ⚽ En qué "zona del campo" está esta bandera
    private boolean subir; // ⚽ true = señala hacia arriba (ataque), false = hacia abajo (defensa)

    // ⚽ CONSTRUCTOR 1: Versión simple - solo dice la dirección
    // Como tener un asistente que solo dice "¡Arriba!" o "¡Abajo!"
    public BotonPiso(String direccion) {
        super(); // ⚽ Primero "hereda" las características del tablero básico
        this.direccion = direccion;
    }

    // ⚽ CONSTRUCTOR 2: Versión completa - sabe el piso Y la dirección
    // Como tener un asistente que dice "¡En la zona 3, señalando hacia arriba!"
    public BotonPiso(int piso, boolean subir) {
        super(); // ⚽ Hereda del tablero básico
        this.piso = piso;
        this.subir = subir;
        this.direccion = subir ? "subir" : "bajar"; // ⚽ Traduce true/false a palabras
    }

    // ⚽ OBTENER DIRECCIÓN: ¿Hacia dónde señala la bandera?
    // Como preguntarle al asistente: "¿Señalas arriba o abajo?"
    public String getDireccion() {
        return direccion;
    }

    // ⚽ OBTENER PISO: ¿En qué zona del campo está el asistente?
    public int getPiso() {
        return piso;
    }

    // ⚽ ¿SEÑALA HACIA ARRIBA?: Devuelve true si la bandera apunta al ataque
    public boolean isSubir() {
        return subir;
    }

    // ⚽ MÉTODO DE PRUEBA - Como un ensayo de señales antes del partido
    public static void main(String[] args) {

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
