import java.util.Scanner;

public class MainAscensor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE ASCENSOR ===");
        System.out.print("Ingrese cuántos pisos tiene el edificio: ");
        int pisos = scanner.nextInt();

        Ascensor ascensor = new Ascensor(1, pisos);

        while (true) {
            System.out.println("\nAscensor en piso actual: " + ascensor.getPisoActual());
            System.out.println("¿A qué piso desea ir? (1 - " + pisos + ")");
            System.out.println("Ingrese 0 para salir.");
            System.out.print("→ ");

            int destino = scanner.nextInt();

            if (destino == 0) {
                System.out.println("\nCerrando sistema...");
                break;
            }

            if (destino < 1 || destino > pisos) {
                System.out.println("⚠ Piso inválido. Intente nuevamente.");
                continue;
            }

           
            ascensor.presionarBotonCabina(destino);

        
            while (ascensor.getPisoActual() != destino) {
                System.out.println(ascensor.moverUnPiso(destino));
                try {
                    Thread.sleep(800); 
                } catch (Exception e) {}
            }

            System.out.println("\n=== Llegada al piso " + destino + " ===");
            for (String msg : ascensor.llegar()) {
                System.out.println(msg);
            }
        }

        scanner.close();
    }
}
