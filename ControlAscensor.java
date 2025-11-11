import java.util.*;

public class ControlAscensor {
    private List<Ascensor> ascensores;
    private int pisos;

    public ControlAscensor(int numeroAscensores, int pisos) {
        this.pisos = pisos;
        this.ascensores = new ArrayList<>();
        for (int i = 1; i <= numeroAscensores; i++) {
            ascensores.add(new Ascensor(i, pisos));
        }
    }

    // Solicita un ascensor para el piso indicado. Se elige el ascensor con menor distancia.
    public void solicitarAscensor(int pisoSolicitud) {
        if (pisoSolicitud < 1 || pisoSolicitud > pisos) {
            System.out.println("Piso inválido: " + pisoSolicitud);
            return;
        }

        Ascensor mejor = null;
        int mejorDist = Integer.MAX_VALUE;
        for (Ascensor a : ascensores) {
            int dist = Math.abs(a.getPisoActual() - pisoSolicitud);
            if (dist < mejorDist) {
                mejorDist = dist;
                mejor = a;
            }
        }

        System.out.println("Solicitud en piso " + pisoSolicitud + ". Asignando ascensor " + (mejor != null ? mejor.toString() : "-") + " (distancia=" + mejorDist + ")");

        if (mejor != null) {
            // Presionamos el botón dentro de la cabina hacia ese piso y movemos la cabina hasta llegar
            mejor.presionarBotonCabina(pisoSolicitud);
            while (mejor.getPisoActual() != pisoSolicitud) {
                System.out.println(mejor.moverUnPiso(pisoSolicitud));
                try {
                    Thread.sleep(150); // pequeña pausa para simular movimiento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Llegando al piso " + pisoSolicitud + " en ascensor " + mejor.toString());
            for (String msg : mejor.llegar()) {
                System.out.println(msg);
            }
        }
    }

    // Imprime el estado actual de todos los ascensores
    public void imprimirEstado() {
        System.out.println("Estado de ascensores:");
        for (Ascensor a : ascensores) {
            System.out.println("- " + a.toString() + " -> piso " + a.getPisoActual());
        }
    }

    
    public static void main(String[] args) {
        ControlAscensor control = new ControlAscensor(2, 5);

        System.out.println("--- Simulación de control de ascensores ---\n");

        // Simular solicitudes
        control.solicitarAscensor(3);
        System.out.println();
        control.solicitarAscensor(5);
        System.out.println();
        control.solicitarAscensor(2);

        System.out.println("\n--- Fin de la simulación ---");
    }
}
