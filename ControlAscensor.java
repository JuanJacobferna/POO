// ⚽ ANALOGÍA FÚTBOL: Este es como el DIRECTOR TÉCNICO (DT) del equipo
// Controla TODO el sistema: el autobús (ascensor) y todas las señales (botones)
// Decide cuándo mover el autobús, atiende las llamadas de los hinchas (botones de piso)
// Y gestiona las solicitudes de los jugadores dentro del autobús (botones de cabina)

import java.util.*;

public class ControlAscensor {

    // ⚽ RECURSOS QUE MANEJA EL DT:
    private Ascensor ascensor; // ⚽ El autobús del equipo
    private BotonPiso[] botonesSubida; // ⚽ Banderas "SUBIR" en cada zona del estadio
    private BotonPiso[] botonesBajada; // ⚽ Banderas "BAJAR" en cada zona del estadio
    private int numeroPisos; // ⚽ Cuántas zonas/estadios hay en total

    // ⚽ CONSTRUCTOR: El DT organiza todo el sistema al inicio
    // Como cuando el club contrata un nuevo DT y le da todos los recursos
    public ControlAscensor(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.ascensor = new Ascensor(numeroPisos); // ⚽ Comprar el autobús del equipo

        // ⚽ Instalar banderas de SUBIDA (no hay en el último piso - ya estás arriba del
        // todo)
        this.botonesSubida = new BotonPiso[numeroPisos - 1];

        // ⚽ Instalar banderas de BAJADA (no hay en el primer piso - ya estás abajo del
        // todo)
        this.botonesBajada = new BotonPiso[numeroPisos - 1];

        // ⚽ Colocar una bandera de "SUBIR" en cada piso (excepto el último)
        for (int i = 0; i < numeroPisos - 1; i++) {
            botonesSubida[i] = new BotonPiso(i + 1, true); // true = subir
        }

        // ⚽ Colocar una bandera de "BAJAR" en cada piso (excepto el primero)
        for (int i = 0; i < numeroPisos - 1; i++) {
            botonesBajada[i] = new BotonPiso(i + 2, false); // false = bajar
        }
    }

    // ⚽ LLAMAR ASCENSOR: Un hincha llama al autobús desde fuera
    // Como cuando los fans esperan al equipo en una zona y hacen señales para que
    // vaya allí
    public void llamarAscensor(int piso, boolean subir) {
        // ⚽ VALIDACIÓN: ¿La zona/piso existe?
        if (piso < 1 || piso > numeroPisos) {
            System.out.println("❌ Piso inválido.");
            return;
        }

        System.out.println("📞 Llamando ascensor al piso " + piso + " para " + (subir ? "SUBIR ⬆️" : "BAJAR ⬇️"));

        // ⚽ ENCENDER LA BANDERA CORRESPONDIENTE
        // Como levantar la bandera para que el autobús sepa dónde ir
        if (subir && piso < numeroPisos) {
            botonesSubida[piso - 1].encender(); // ⚽ Levantar bandera "SUBIR"
        } else if (!subir && piso > 1) {
            botonesBajada[piso - 2].encender(); // ⚽ Levantar bandera "BAJAR"
        }

        // ⚽ ENVIAR EL AUTOBÚS A ESA ZONA
        ascensor.moverAPiso(piso);

        // ⚽ APAGAR LA BANDERA cuando el autobús llega
        // Como bajar la bandera porque ya no se necesita - el autobús llegó
        if (subir && piso < numeroPisos) {
            botonesSubida[piso - 1].apagar();
        } else if (!subir && piso > 1) {
            botonesBajada[piso - 2].apagar();
        }
    }

    // ⚽ SELECCIONAR PISO: Un jugador DENTRO del autobús presiona un botón
    // Como cuando alguien en el autobús dice "¡Vamos al estadio #5!"
    public void seleccionarPiso(int pisoDestino) {
        // ⚽ VALIDACIÓN: ¿El destino existe?
        if (pisoDestino < 1 || pisoDestino > numeroPisos) {
            System.out.println("❌ Piso inválido.");
            return;
        }

        // ⚽ REGISTRAR LA SOLICITUD
        System.out.println("🔘 Botón piso " + pisoDestino + " presionado");
        ascensor.getBotonesCabina()[pisoDestino - 1].encender(); // ⚽ Iluminar el botón

        // ⚽ MOVER EL AUTOBÚS al destino solicitado
        ascensor.moverAPiso(pisoDestino);
    }

    // ⚽ OBTENER ASCENSOR: Acceso al autobús (para consultar estado, etc.)
    public Ascensor getAscensor() {
        return ascensor;
    }

    // ⚽ OBTENER NÚMERO DE PISOS: ¿Cuántas zonas/estadios hay?
    public int getNumeroPisos() {
        return numeroPisos;
    }
}
