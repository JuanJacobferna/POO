import java.util.*;

public class Ascensor {
    private int id;
    private int pisoActual;
    private int direccion; 
    private Puerta puerta;
    private Map<Integer, BotonCabina> botones;

    
    public Ascensor(int id, int pisos) {
        this.id = id;
        this.pisoActual = 1;
        this.direccion = 0; 
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
            direccion = 1; // subiendo
        } else {
            pisoActual--;
            direccion = -1; // bajando
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
            direccion = 0;
        }

        return mensajes;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ascensor " + id;
    }

    public void presionarBotonCabina(int pisoDestino) {
        if (botones.containsKey(pisoDestino)) {
            botones.get(pisoDestino).presionar();
            System.out.println("Botón del piso " + pisoDestino + " presionado dentro del ascensor.");
        } else {
            System.out.println("Piso inválido.");
        }
    }

        public static void main(String[] args) {
            System.out.println("=== Prueba del Ascensor ===\n");
        
           
            Ascensor ascensor = new Ascensor(1, 5);
            System.out.println("Ascensor creado. Piso inicial: " + ascensor.getPisoActual() + "\n");

            ascensor.presionarBotonCabina(3);
            System.out.println("Moviendo a piso 3...");
            System.out.println(ascensor.moverUnPiso(3));
            System.out.println(ascensor.moverUnPiso(3));

           
            System.out.println("\nLlegando al piso 3:");
            for (String mensaje : ascensor.llegar()) {
                System.out.println(mensaje);
            }

            System.out.println("\nPiso actual: " + ascensor.getPisoActual());

            ascensor.presionarBotonCabina(5);
            System.out.println("\nMoviendo a piso 5...");
            System.out.println(ascensor.moverUnPiso(5));
            System.out.println(ascensor.moverUnPiso(5));

           
            System.out.println("\nLlegando al piso 5:");
            for (String mensaje : ascensor.llegar()) {
                System.out.println(mensaje);
            }

            System.out.println("\nPiso actual: " + ascensor.getPisoActual());
            System.out.println("\n=== Fin de la prueba ===");
        }
    }



    

