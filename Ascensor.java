import java.util.ArrayList;

public class Ascensor {
    private int id;
    private int pisoActual;
    private int direccion;
    private ArrayList<Puerta> puertas;
    private Map<Integer, BotonCabina> botones;
    

    public Ascensor(int id, int pisoInicial, int direccionInicial) {
        this.id = id;
        this.pisoActual = pisoInicial;
        this.direccion = direccionInicial;
        this.puertas = new ArrayList<>();
        this.botones = new Map<>();

for (int i = 1; i <=  pisos; i++){
    botones.put(i, new BotonCabina(i));

}


    }
    public String moverUnpiso(int destino){
        pisoActual++;
        direccion=1;
    }else{
        pisoActual--;
        direccion=-1;

    
    }
 
    return "Ascensor " + id + " se ha movido al piso " + pisoActual;

}
public List<String> llegar(){
    List<String> mensajes = new ArrayList<>();
    mensajes.add(puerta.abrir());

    BotonCabina boton = botones.get(pisoActual);
    if (boton.isEncendido()){
        boton.cancelar();
        mensajes.add("Botón del piso " + pisoActual + " apagado.");
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

    public void presionarBotonCabina(int pisoDestino) {
        if (botones.containsKey(pisoDestino)) {
            botones.get(pisoDestino).presionar();
            System.out.println("Botón del piso " + pisoDestino + " presionado dentro del ascensor.");
        } else {
            System.out.println("Piso inválido.");
        }
    }







    

