// ⚽ ANALOGÍA FÚTBOL: Este es como el AUTOBÚS DEL EQUIPO
// Se mueve entre diferentes ZONAS/ESTADIOS (pisos)
// Tiene una PUERTA (túnel de vestuarios) que se abre/cierra
// Tiene BOTONES internos (panel de destinos) para elegir a dónde ir
// Puede estar en MOVIMIENTO o DETENIDO

import java.util.*;

public class Ascensor {

    // ⚽ ATRIBUTOS DEL AUTOBÚS DEL EQUIPO:
    private int pisoActual; // ⚽ ¿En qué estadio/zona estamos ahora?
    private Puerta puerta; // ⚽ La puerta del autobús (abierta/cerrada)
    private BotonCabina[] botonesCabina; // ⚽ Panel de destinos - botones para cada estadio
    private boolean enMovimiento; // ⚽ ¿Está el autobús viajando o detenido?
    private int capacidadMaxima; // ⚽ Cuántos pasajeros/jugadores caben (máximo 10)
    private int numeroPisos; // ⚽ Cuántos estadios/zonas hay en total

    // ⚽ CONSTRUCTOR: Preparar el autobús del equipo al inicio
    // Como comprar un autobús nuevo - comienza en el estadio 1, puerta cerrada,
    // listo para viajar
    public Ascensor(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.pisoActual = 1; // ⚽ Empezamos en el estadio #1
        this.puerta = new Puerta(); // ⚽ Instalamos la puerta del autobús
        this.botonesCabina = new BotonCabina[numeroPisos]; // ⚽ Creamos botones para cada destino
        this.enMovimiento = false; // ⚽ Autobús detenido inicialmente
        this.capacidadMaxima = 10; // ⚽ Capacidad: 10 pasajeros

        // ⚽ Instalar un botón para cada estadio/piso posible
        for (int i = 0; i < numeroPisos; i++) {
            botonesCabina[i] = new BotonCabina(i + 1);
        }
    }

    // ⚽ MOVER A PISO: Viajar del estadio actual a otro estadio
    // Como cuando el equipo viaja de su ciudad a otra para jugar un partido
    public void moverAPiso(int pisoDestino) {
        // ⚽ VALIDACIÓN 1: ¿El estadio destino existe?
        if (pisoDestino < 1 || pisoDestino > numeroPisos) {
            System.out.println("❌ Piso inválido.");
            return;
        }

        // ⚽ VALIDACIÓN 2: ¿Ya estamos en ese estadio?
        // Como decir "Ya estamos en el Camp Nou, no hace falta viajar"
        if (pisoDestino == pisoActual) {
            System.out.println("ℹ️  Ya estás en el piso " + pisoActual);
            return;
        }

        // ⚽ PREPARAR VIAJE: Cerrar puerta y activar modo "en movimiento"
        // Como cerrar las puertas del autobús antes de arrancar
        puerta.cerrar();
        enMovimiento = true;

        System.out.println("🔼 Ascensor moviéndose desde piso " + pisoActual + " hacia piso " + pisoDestino + "...");

        // ⚽ SIMULAR VIAJE: El autobús tarda 1.5 segundos en llegar
        // Como el tiempo real que toma viajar entre ciudades (simulado)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ⚽ LLEGADA: Actualizar ubicación y abrir puertas
        pisoActual = pisoDestino; // ⚽ ¡Hemos llegado al nuevo estadio!
        enMovimiento = false; // ⚽ Autobús detenido
        botonesCabina[pisoDestino - 1].apagar(); // ⚽ Apagar el botón - destino alcanzado

        System.out.println("✅ Ascensor ha llegado al piso " + pisoActual);
        puerta.abrir(); // ⚽ Abrir puertas para que los jugadores bajen
    }

    // ⚽ ABRIR PUERTA: Permitir que la gente entre/salga del autobús
    // Solo se puede si el autobús está DETENIDO (seguridad)
    public void abrirPuerta() {
        if (!enMovimiento) { // ⚽ ¿El autobús está parado?
            puerta.abrir();
        } else {
            System.out.println("⚠️  No se puede abrir la puerta mientras el ascensor está en movimiento.");
            // ⚽ Como intentar abrir la puerta mientras el autobús va a 100 km/h -
            // ¡PELIGROSO!
        }
    }

    // ⚽ CERRAR PUERTA: Preparar el autobús para viajar
    public void cerrarPuerta() {
        puerta.cerrar();
    }

    // ⚽ CONSULTAR PISO ACTUAL: ¿En qué estadio/zona estamos?
    public int getPisoActual() {
        return pisoActual;
    }

    // ⚽ CONSULTAR MOVIMIENTO: ¿Está el autobús viajando o detenido?
    public boolean estaEnMovimiento() {
        return enMovimiento;
    }

    // ⚽ OBTENER PUERTA: Acceso al objeto puerta (para verificar estado)
    public Puerta getPuerta() {
        return puerta;
    }

    // ⚽ OBTENER BOTONES: Acceso a todos los botones del panel interno
    public BotonCabina[] getBotonesCabina() {
        return botonesCabina;
    }

    // ⚽ MOSTRAR ESTADO: Tablero de información del autobús
    // Como el panel de información en una estación que dice dónde está cada autobús
    public void mostrarEstado() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📊 Estado del Ascensor:");
        System.out.println("   Piso actual: " + pisoActual);
        System.out.println("   Puerta: " + (puerta.estaAbierta() ? "ABIERTA 🟢" : "CERRADA 🔴"));
        System.out.println("   En movimiento: " + (enMovimiento ? "SÍ" : "NO"));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}
