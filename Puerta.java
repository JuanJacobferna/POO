public class Puerta {
    private boolean abierta;

    public Puerta() {
        this.abierta = false;

    }

    public String abrir() {
        if (!abierta) {
            abierta = true;
            return "La puerta se ha abierto.";
        } else {
            return "La puerta ya está abierta.";
        }
    }
    public String cerrar() {
        if (abierta) {
            abierta = false;
            return "La puerta se ha cerrado.";
        } else {
            return "La puerta ya está cerrada.";
        }
    }
    public boolean isAbierta() {
        return abierta;
            
}

public static void main(String[] args) {
    Puerta  puerta= new Puerta();

    System.out.println(puerta.abrir());
    System.out.println("¿La puerta está abierta? " + puerta.isAbierta());
   
   
    System.out.println(puerta.cerrar());
    System.out.println("¿La puerta está abierta? " + puerta.isAbierta());


}

}