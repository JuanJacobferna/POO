import java.io.*;
import java.util.*;

public class MainAscensor {

    public static void main(String[] args) {
        System.out.println("Compilando fuentes Java en el proyecto...\n");
        boolean compiled = compileSources();
        if (!compiled) {
            System.err.println("La compilación falló. Corrige los errores y vuelve a intentar.");
            return;
        }

        // Ejecutar el menú interactivo (usa ControlAscensor ya compilado)
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Sistema de Ascensores (MainAscensor) ===");
            System.out.print("Ingrese número de ascensores: ");
            int numAsc = readInt(sc);
            System.out.print("Ingrese número de pisos: ");
            int pisos = readInt(sc);

            ControlAscensor control = new ControlAscensor(numAsc, pisos);

            System.out.println("\nSistema iniciado. Comandos: <piso> solicitar, 'estado', 'salir'.");
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
                try {
                    int piso = Integer.parseInt(line);
                    control.solicitarAscensor(piso);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Usa un número de piso, 'estado' o 'salir'.");
                }
            }
        }
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

    private static boolean compileSources() {
        try {
            File cwd = new File(System.getProperty("user.dir"));
            File[] javaFiles = cwd.listFiles((d, name) -> name.toLowerCase().endsWith(".java"));
            if (javaFiles == null || javaFiles.length == 0) {
                System.out.println("No se encontraron archivos .java en la carpeta del proyecto.");
                return true;
            }

            List<String> command = new ArrayList<>();
            command.add("javac");
            command.add("-d");
            command.add("out");
            for (File f : javaFiles) command.add(f.getName());

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(cwd);
            pb.redirectErrorStream(true);
            Process p = pb.start();

            try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exit = p.waitFor();
            if (exit == 0) {
                System.out.println("Compilación exitosa.\n");
                return true;
            } else {
                System.err.println("javac devolvió código de salida " + exit);
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al invocar javac: " + e.getMessage());
            return false;
        }
    }
}
