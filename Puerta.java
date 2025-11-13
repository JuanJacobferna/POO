// ⚽ ANALOGÍA FÚTBOL: Esta es como la PUERTA DEL TÚNEL DE VESTUARIOS
// Los jugadores solo pueden entrar/salir cuando está ABIERTA
// Durante el partido (cuando el ascensor se mueve), la puerta debe estar CERRADA por seguridad

public class Puerta {

    // ⚽ Estado de la puerta: ¿Pueden los jugadores pasar o está bloqueada?
    private boolean abierta;

    // ⚽ CONSTRUCTOR: Al inicio, la puerta del túnel está cerrada
    // Como antes del partido - nadie puede pasar todavía
    public Puerta() {
        this.abierta = false;
    }

    // ⚽ ABRIR: Permitir que los jugadores entren/salgan del túnel
    // Como cuando el árbitro da la señal y los jugadores salen al campo
    public void abrir() {
        if (!abierta) { // ⚽ Solo abre si estaba cerrada (no hacer el gesto dos veces)
            System.out.println("🚪 Puerta abriendo...");
            abierta = true;
        }
    }

    // ⚽ CERRAR: Bloquear el paso - nadie puede entrar ni salir
    // Como cerrar el túnel durante el partido para que nadie interrumpa
    public void cerrar() {
        if (abierta) { // ⚽ Solo cierra si estaba abierta
            System.out.println("🚪 Puerta cerrando...");
            abierta = false;
        }
    }

    // ⚽ CONSULTAR ESTADO: ¿Está abierta la puerta del túnel?
    // Como preguntarle al guardia de seguridad: "¿Pueden pasar los jugadores?"
    public boolean estaAbierta() {
        return abierta;
    }
}
