/** 
 * 
 * @author Joan Alba Maldonado
 */
//FALTA: siempre validar configuracion y si no es korrekta, usar unos valores por defecto.
package schoolalyzer.tetris.configuracion;

public class Idiomas {
    //Idiomas existentes y por defecto (Modificable):

    static final public String[] idiomas = {"Catal�", "Castellano", "Deutsch"}; //Idiomas existentes.
    static final public int idiomaPorDefecto = 2; //Indice del idioma por defecto al iniciar el juego.
    //Etiquetas traducibles (Modificable):
    static final public String[] piezaSiguiente = {
        "Pe�a seg�ent",
        "Pieza siguiente",
        "Nächstes Stück"
    };
    static final public String[] lineasTotales = {
        "Linies totals",
        "Lineas totales",
        "Linien insgesamt"
    };
    static final public String[] lineasNivel = {
        "Linies nivell",
        "Lineas nivel",
        "Level-Linien"
    };
    static final public String[] nivel = {
        "Nivell",
        "Nivel",
        "Level"
    };
    static final public String[] puntuacion = {
        "Puntuaci�",
        "Puntuaci�n",
        "Punktestand"
    };
    static final public String[] gameOver = {
        "Fi del joc",
        "Fin del juego",
        "Game Over"
    };
    static final public String[] iniciarJuego = {
        "Inicia joc",
        "Iniciar juego",
        "Spiel starten"
    };
    static final public String[] finalizarJuego = {
        "Surt",
        "Salir",
        "Beenden"
    };
    static final public String[] volver = {
        "Torna",
        "Volver",
        "Zurück"
    };
    static final public String[] opciones = {
        "Opcions",
        "Opciones",
        "Optionen"
    };
    static final public String[] comienzaJuego = {
        "Comen�a el joc",
        "Comienza el juego",
        "Startet das Spiel"
    };
    static final public String[] modificarOpciones = {
        "Modificar opcions",
        "Modificar opciones",
        "Optionen ändern"
    };
    static final public String[] saleJuego = {
        "Surt del joc",
        "Sale del juego",
        "Spiel beenden"
    };
    static final public String[] confirmarSalir = {
        "Confirmar",
        "Confirmar",
        "Bestätigen"
    };
    static final public String[] rechazarSalir = {
        "Torna al menu",
        "Volver al menu",
        "Zurück zum Menü"
    };
    static final public String[] volverJuego = {
        "Torna al joc",
        "Vuelve al juego",
        "Zurück zum Spiel"
    };
    static final public String[] volverMenuPrincipal = {
        "Tornar al men� principal",
        "Volver al men� principal",
        "Zurück zum Hauptmenü"
    };
    static final public String[] volverMenu = {
        "Tornar",
        "Volver",
        "Zurück"
    };
    static final public String[] reanudarJuego = {
        "Continuar",
        "Continuar",
        "Weiter"
    };
    static final public String[] terminarJuego = {
        "Terminar",
        "Terminar",
        "Beenden"
    };

    private Idiomas() {
    }
}
