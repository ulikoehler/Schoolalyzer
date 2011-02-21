/** 
 * 
 * @author Joan Alba Maldonado
 */

/*
 * TetrisDAI (http://tetrisdai.sourceforge.net)
 */
//Falta: en totes les classes, impedir ficar valors no possibles en els sets (valors negatius, etc).
package schoolalyzer.tetris.principal;

import java.awt.Graphics;

import schoolalyzer.tetris.logica.TetrisGame;
import schoolalyzer.tetris.logica.Paleta;
import schoolalyzer.tetris.logica.Pieza;

import schoolalyzer.tetris.gui.TetrisApplet;

import schoolalyzer.tetris.gui.TetrisForm;
import schoolalyzer.tetris.gui.MotorGrafico;

//import java.awt.Dimension;
//FALTA: implementar multijugador (quiza el objeto juego de Main pueda convertirse en JuegoMultijugador y se manejaria igual).
public class TetrisMain {

    static public TetrisGame game = null; //Objeto principal del motor del juego.
    static public TetrisForm ventanaPrincipal; //Formulario principal del juego.
    static public TetrisApplet appletPrincipal;
    static protected int idiomaActual = schoolalyzer.tetris.configuracion.Idiomas.idiomaPorDefecto; //Idioma actual del programa.

    public TetrisMain() {
    }

    //Main que se ejecuta cuando se utiliza el JFrame en lugar del JApplet:
    public static void main(String[] args) {
        //Si se ha ejecutado primero el main en lugar del JApplet, se configura para utilizar el JFrame y no el Applet:
        if (TetrisMain.appletPrincipal == null) {
            schoolalyzer.tetris.configuracion.Otros.setTipoPrograma((byte) 0);
        }

        //Si esta configurado para utilizar JFrame, lo hace:
        if (schoolalyzer.tetris.configuracion.Otros.getTipoPrograma() == 0) {
            TetrisMain.ventanaPrincipal = new TetrisForm();
            TetrisMain.showMainWindow();
            TetrisMain.game = new TetrisGame(TetrisMain.ventanaPrincipal.getGamePanel());
        } //...pero si esta configurado para utilizar JApplet, lo hace:
        else if (schoolalyzer.tetris.configuracion.Otros.getTipoPrograma() == 1) {
            TetrisMain.game = new TetrisGame(TetrisMain.appletPrincipal.getGamePanel());
        }

        //PRUEBA:
        TetrisMain.initializeGame(); //BORRAR ESTA LINEA!!!

        //Define el ancho y alto de la ventana o applet principal del juego:
        TetrisMain.resizeMainWindow(); //Quiza se deba comentar esto si se utliza un Applet.

        TetrisMain.game.showMainMenu(); //<<-PRUEBA!!!
    }

    public static int getIdiomaActual() {
        return TetrisMain.idiomaActual;
    }

    //Muestra la ventana principal del juego:
    protected static void showMainWindow() {
        //Muestra la ventana:
        TetrisMain.resizeMainWindow();
        TetrisMain.ventanaPrincipal.setLocationRelativeTo(null);
        TetrisMain.ventanaPrincipal.setVisible(true);
    }

    //Pone el ancho y alto de la ventana o applet principal del juego:
    public static void resizeMainWindow() {
        int ancho = 640, alto = 480; //Dimension por defecto si no existe el juego.

        if (TetrisMain.game != null) {
            ancho = (TetrisMain.game.getPanel().getLeft() + TetrisMain.game.getPanel().getAncho()) * MotorGrafico.getCeldaAncho();
            alto = TetrisMain.game.getTablero().getAlto() * MotorGrafico.getCeldaAlto(); //Podria pasar que el alto del tablero fuese menor que el alto del panel, pero no se tendra en cuenta (solo ocurriria con piezas muy grances y un tablero menor que alguna de estas).
        }

        int margenHorizontal = schoolalyzer.tetris.configuracion.Aspecto.getMargenHorizontal();
        int margenVertical = schoolalyzer.tetris.configuracion.Aspecto.getMargenVertical();

        //Si esta configurado para utilizar JFrame, redimensiona este:
        if (schoolalyzer.tetris.configuracion.Otros.getTipoPrograma() == 0) {
            TetrisMain.ventanaPrincipal.setSize(ancho + margenHorizontal, alto + margenVertical);
        } //...pero si esta configurado para utilizar JApplet, redimensiona este:
        else if (schoolalyzer.tetris.configuracion.Otros.getTipoPrograma() == 1) {
            //Main.appletPrincipal.setSize(ancho + margenHorizontal, alto + margenVertical);
        }

        //Si el juego ha comenzado, redimensiona la imagen de buffer:
        if (TetrisMain.game != null) {
            TetrisMain.game.redimensionarImagenBuffer();
        }
    }

    //Inicia el juego:
    public static void initializeGame() {
        //Define el ancho y alto de la ventana o applet principal del juego:
        TetrisMain.resizeMainWindow(); //Quiza se deba comentar esto si se utliza un Applet.

        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        //Inicia el juego:
        TetrisMain.game.initializeGame();
    }

    //Finaliza el juego (no el programa):
    public static void finalizarJuego() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.finalizarJuego();
        //Main.juego = null;
    }

    //Reinicia el juego (no el programa):
    public static void reinitializeGame() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.reiniciarJuego();
    }

    //Pausa el juego:
    public static void pauseGame() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.pausarJuego();
    }

    //Reanuda el juego (quita la pausa):
    public static void continueGame() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.reanudarJuego();
    }

    //Cambia el contenedor grafico del juego:
    public static void cambiarContenedorGraficoJuego(Graphics contenedor) {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.setContenedorGrafico(contenedor);
    }

    //Cambia la paleta del juego:
    public static void cambiarPaletaJuego(Paleta paleta) {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.setPaleta(paleta);
    }

    //Cambia las piezas base del juego:
    public static void cambiarPiezasBaseJuego(Pieza[] piezasBase) {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.setPiezasBase(piezasBase);
    }

    //Cambia las teclas del juego:
    public static void cambiarTeclasJuego(int[] teclaArriba, int[] teclaAbajo, int[] teclaDerecha, int[] teclaIzquierda, int[] teclaRotarDerecha, int[] teclaRotarIzquierda, int[] teclaAceptar, int[] teclaPausa, int[] teclaSalir) {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.definirTeclas(teclaArriba, teclaAbajo, teclaDerecha, teclaIzquierda, teclaRotarDerecha, teclaRotarIzquierda, teclaAceptar, teclaPausa, teclaSalir);
    }

    //Lee y procesa una tecla:
    public static void procesarTecla(int codigoTecla) {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.procesarTecla(codigoTecla);
        //System.out.println("Tecla pulsada: " + codigoTecla);
    }

    //Cambia el idioma actual:
    public static void cambiarIdiomaActual(int idioma) {
        if (idioma >= 0 && idioma < schoolalyzer.tetris.configuracion.Idiomas.idiomas.length) {
            TetrisMain.idiomaActual = idioma;
        }
    }

    //Desactiva el sonido del juego:
    public static void desactivarSonido() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.desactivarSonido();
    }

    //Activa el sonido del juego:
    public static void activarSonido() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.activarSonido();
    }

    //Alterna el sonido del juego (lo activa o desactiva):
    public static void alternarSonido() {
        //Si no se ha instanciado el juego, sale:
        if (TetrisMain.game == null) {
            return;
        }

        TetrisMain.game.alternarSonido();
    }
}
