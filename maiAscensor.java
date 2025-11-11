import java.util.Scanner;

public class maiAscensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenido al sistema de ascensores interactivo ===");

        System.out.print("Ingrese número de ascensores: ");
        int numAscensores = readInt(sc);

        System.out.print("Ingrese número de pisos: ");
        int pisos = readInt(sc);

        ControlAscensor control = new ControlAscensor(numAscensores, pisos);

        System.out.println("\nSistema iniciado: " + numAscensores + " ascensor(es), " + pisos + " pisos.");
        System.out.println("Comandos: <número de piso> para solicitar ascensor, 'estado' para ver estado, 'salir' para terminar.");

        while (true) {
            System.out.print("\n> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("salir") || line.equalsIgnoreCase("exit")) {
                System.out.println("Saliendo...");
                break;
            }
            if (line.equalsIgnoreCase("estado") || line.equalsIgnoreCase("status")) {
                control.imprimirEstado();
                continue;
            }

            // intentar parsear número de piso
            try {
                int piso = Integer.parseInt(line);
                control.solicitarAscensor(piso);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no reconocida. Usa un número de piso, 'estado' o 'salir'.");
            }
        }

        sc.close();
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Intenta de nuevo: ");
            }
        }
    }
}
