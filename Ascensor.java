// Ascensor.java
// Representa el ascensor con su movimiento, puerta y botones internos.

import java.util.*;

public class Ascensor {
    private int id;
    private int pisoActual;
    private Puerta puerta;
    private Map<Integer, BotonCabina> botones;

 
    public Ascensor(int id, int pisos) {
        this.id = id;
        this.pisoActual = 1; 
        this.puerta = new Puerta();
        this.botones = new HashMap<>();


        for (int i = 1; i <= pisos; i++) {
            botones.put(i, new BotonCabina(i));
        }
    }

    
    public String moverUnPiso(int destino) {
        if (destino == pisoActual) {
            return "Ascensor " + id + " ya está en el piso " + pisoActual;
        }

        if (destino > pisoActual) {
            pisoActual++; 
        } else {
            pisoActual--; 
        }

        return "Ascensor " + id + " se mueve al piso " + pisoActual;
    }


    public List<String> llegar() {
        List<String> mensajes = new ArrayList<>();
        mensajes.add(puerta.abrir());

        BotonCabina boton = botones.get(pisoActual);
        if (boton.isEncendido()) {
            boton.cancelar();
            mensajes.add("Botón del piso " + pisoActual + " apagado");
        }

        mensajes.add(puerta.cerrar());

       
        boolean algunoEncendido = botones.values().stream()
                .anyMatch(BotonCabina::isEncendido);
        if (!algunoEncendido) {
        }

        return mensajes;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void presionarBotonCabina(int pisoDestino) {
        if (botones.containsKey(pisoDestino)) {
            botones.get(pisoDestino).presionar();
            System.out.println("Botón del piso " + pisoDestino + " presionado dentro del ascensor.");
        } else {
            System.out.println("Piso inválido.");
        }
    }
}
