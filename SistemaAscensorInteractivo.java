// ⚽ ANALOGÍA FÚTBOL: Este es el SIMULADOR COMPLETO DE UN DÍA DE PARTIDO
// Tú eres un HINCHA que quiere moverse por diferentes zonas del estadio
// El ascensor es como el AUTOBÚS DEL EQUIPO que te lleva entre zonas
// Puedes estar FUERA esperando el autobús, o DENTRO viajando

import java.util.Scanner;

public class SistemaAscensorInteractivo {

    // ⚽ VARIABLES GLOBALES - El "estado del juego"
    private static ControlAscensor control; // ⚽ El DT que controla todo
    private static Scanner scanner; // ⚽ El micrófono para escuchar al hincha
    private static int pisoUsuario; // ⚽ ¿En qué zona del estadio estás?
    private static boolean dentroAscensor; // ⚽ ¿Estás dentro o fuera del autobús?

    // ⚽ MÉTODO PRINCIPAL: Como el inicio del día de partido
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // ⚽ CONFIGURACIÓN INICIAL: Preparar el estadio y ubicar al hincha
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   🏢 SISTEMA DE ASCENSOR INTERACTIVO  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ⚽ Pregunta 1: ¿Cuántas zonas tiene el estadio?
        System.out.print("¿Cuántos pisos tiene el edificio? (mínimo 2): ");
        int numeroPisos = leerEnteroValido(2, 20);

        // ⚽ Crear el sistema completo (DT, autobús, banderas, etc.)
        control = new ControlAscensor(numeroPisos);

        // ⚽ Pregunta 2: ¿Dónde estás ubicado inicialmente?
        System.out.print("\n¿En qué piso te encuentras actualmente? (1-" + numeroPisos + "): ");
        pisoUsuario = leerEnteroValido(1, numeroPisos);
        dentroAscensor = false; // ⚽ Empiezas FUERA del autobús

        // ⚽ Confirmación: Todo listo para empezar
        System.out.println("\n✅ Sistema inicializado.");
        System.out.println("📍 Te encuentras en el piso " + pisoUsuario);
        System.out.println("🛗 El ascensor está en el piso " + control.getAscensor().getPisoActual());

        // ⚽ BUCLE PRINCIPAL: El juego continúa hasta que decides salir
        // Como cuando el hincha decide quedarse en el estadio o irse a casa
        while (true) {
            mostrarMenu();
            int opcion = leerEnteroValido(1, 4);

            switch (opcion) {
                case 1:
                    llamarAscensor(); // ⚽ Llamar al autobús
                    break;
                case 2:
                    entrarSalirAscensor(); // ⚽ Subir/bajar del autobús
                    break;
                case 3:
                    seleccionarDestino(); // ⚽ Elegir a qué zona ir
                    break;
                case 4:
                    System.out.println("\n👋 ¡Gracias por usar el sistema de ascensor!");
                    scanner.close();
                    return; // ⚽ Fin del juego - te vas a casa
            }
        }
    }

    // ⚽ MOSTRAR MENÚ: Como el tablero de opciones en el estadio
    // Muestra dónde estás y qué puedes hacer según tu situación
    private static void mostrarMenu() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📍 TU UBICACIÓN:");

        // ⚽ Informar tu posición actual
        if (dentroAscensor) {
            System.out.println("   ➤ Dentro del ascensor (Piso " + control.getAscensor().getPisoActual() + ")");
        } else {
            System.out.println("   ➤ En el piso " + pisoUsuario + " (fuera del ascensor)");
        }

        // ⚽ Mostrar el estado del autobús
        control.getAscensor().mostrarEstado();

        System.out.println("¿Qué deseas hacer?");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // ⚽ MENÚ DINÁMICO: Las opciones cambian según dónde estés
        if (!dentroAscensor) {
            // ⚽ FUERA del autobús: puedes llamarlo o intentar entrar
            System.out.println("1. 📞 Llamar al ascensor");
            if (control.getAscensor().getPisoActual() == pisoUsuario &&
                    control.getAscensor().getPuerta().estaAbierta()) {
                System.out.println("2. 🚶 Entrar al ascensor");
            } else {
                System.out.println("2. 🚶 Entrar al ascensor (no disponible)");
            }
            System.out.println("3. 🎯 Seleccionar piso (solo dentro del ascensor)");
        } else {
            // ⚽ DENTRO del autobús: puedes elegir destino o salir
            System.out.println("1. 📞 Llamar al ascensor (ya estás dentro)");
            System.out.println("2. 🚶 Salir del ascensor");
            System.out.println("3. 🎯 Seleccionar piso de destino");
        }
        System.out.println("4. 🚪 Salir del programa");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("Opción: ");
    }

    // ⚽ LLAMAR ASCENSOR: Hacer señas al autobús para que venga a tu zona
    // Como cuando los hinchas gritan "¡Queremos el autobús aquí!"
    private static void llamarAscensor() {
        // ⚽ VALIDACIÓN: ¿Ya estás dentro? No tiene sentido llamarlo
        if (dentroAscensor) {
            System.out.println("\nℹ️  Ya estás dentro del ascensor.");
            return;
        }

        // ⚽ Preguntar: ¿Quieres ir hacia arriba o hacia abajo?
        System.out.println("\n¿Hacia dónde quieres ir?");
        System.out.println("1. ⬆️  Subir");
        System.out.println("2. ⬇️  Bajar");
        System.out.print("Opción: ");

        int direccion = leerEnteroValido(1, 2);
        boolean subir = (direccion == 1);

        // ⚽ VALIDACIÓN LÓGICA: No puedes subir si ya estás en la cima
        // Como querer ir más arriba cuando ya estás en la tribuna presidencial
        if (subir && pisoUsuario == control.getNumeroPisos()) {
            System.out.println("\n❌ Ya estás en el último piso, no puedes subir más.");
            return;
        }
        // ⚽ Tampoco puedes bajar si ya estás en el nivel más bajo
        if (!subir && pisoUsuario == 1) {
            System.out.println("\n❌ Ya estás en el primer piso, no puedes bajar más.");
            return;
        }

        // ⚽ LLAMAR AL AUTOBÚS: El DT lo envía a tu zona
        control.llamarAscensor(pisoUsuario, subir);

        System.out.println("\n✅ El ascensor ha llegado a tu piso.");
        System.out.println("💡 Ahora puedes entrar al ascensor.");
    }

    // ⚽ ENTRAR/SALIR DEL ASCENSOR: Subir o bajar del autobús
    // Como cuando el hincha decide tomar el autobús o bajarse en una zona
    private static void entrarSalirAscensor() {
        if (!dentroAscensor) {
            // ⚽ CASO 1: INTENTAR ENTRAR al autobús

            // Validación 1: ¿El autobús está en tu zona?
            if (control.getAscensor().getPisoActual() != pisoUsuario) {
                System.out.println("\n❌ El ascensor no está en tu piso.");
                System.out.println("   Ascensor en piso: " + control.getAscensor().getPisoActual());
                System.out.println("   Tú estás en piso: " + pisoUsuario);
                System.out.println("💡 Debes llamar al ascensor primero.");
                return;
            }

            // Validación 2: ¿Está abierta la puerta del autobús?
            if (!control.getAscensor().getPuerta().estaAbierta()) {
                System.out.println("\n❌ La puerta del ascensor está cerrada.");
                System.out.println("💡 Llama al ascensor para que abra la puerta.");
                return;
            }

            // ⚽ ¡TODO BIEN! Subir al autobús
            System.out.println("\n🚶 Entrando al ascensor...");
            dentroAscensor = true;
            System.out.println("✅ Has entrado al ascensor.");

        } else {
            // ⚽ CASO 2: SALIR del autobús

            // Validación: ¿El autobús está detenido con puerta abierta?
            if (!control.getAscensor().getPuerta().estaAbierta()) {
                System.out.println("\n❌ La puerta está cerrada. Espera a que el ascensor se detenga.");
                return;
            }

            // ⚽ ¡Bajarse del autobús! Actualizar tu ubicación
            System.out.println("\n🚶 Saliendo del ascensor...");
            pisoUsuario = control.getAscensor().getPisoActual(); // ⚽ Ahora estás en esta zona
            dentroAscensor = false;
            System.out.println("✅ Has salido del ascensor en el piso " + pisoUsuario);
        }
    }

    // ⚽ SELECCIONAR DESTINO: Presionar un botón DENTRO del autobús
    // Como decirle al conductor "¡Llévame a la zona VIP!"
    private static void seleccionarDestino() {
        // ⚽ VALIDACIÓN: Solo puedes elegir destino si estás DENTRO
        if (!dentroAscensor) {
            System.out.println("\n❌ Debes estar dentro del ascensor para seleccionar un piso.");
            return;
        }

        // ⚽ Mostrar opciones y pedir el destino
        System.out.println("\n🎯 Selecciona el piso de destino:");
        System.out.println("   (Piso actual: " + control.getAscensor().getPisoActual() + ")");
        System.out.print("   Pisos disponibles: 1-" + control.getNumeroPisos() + ": ");

        int pisoDestino = leerEnteroValido(1, control.getNumeroPisos());

        // ⚽ Validar que no estés ya en ese piso
        if (pisoDestino == control.getAscensor().getPisoActual()) {
            System.out.println("\nℹ️  Ya estás en el piso " + pisoDestino);
            return;
        }

        // ⚽ ¡Viajar al destino seleccionado!
        control.seleccionarPiso(pisoDestino);
        System.out.println("\n💡 Ahora puedes salir del ascensor si lo deseas.");
    }

    // ⚽ LEER NÚMERO VÁLIDO: Validar que el hincha ingrese un número correcto
    // Como un guardia que verifica que tengas un boleto válido
    private static int leerEnteroValido(int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= min && valor <= max) {
                    return valor; // ⚽ ¡Número válido!
                } else {
                    System.out.print("❌ Por favor ingresa un número entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("❌ Por favor ingresa un número válido: ");
            }
        }
    }
}
