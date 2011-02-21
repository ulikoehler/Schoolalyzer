/** 
 * 
 * @author Joan Alba Maldonado
 */
//Nota: Para utilizar el JApplet, es necesario definirlo en tipoPrograma en configuracion.Otros.
package schoolalyzer.tetris.gui;

//import javax.swing.JPanel;
import java.awt.Graphics;

//import java.awt.Color; //PRUEBA!!!

import schoolalyzer.tetris.principal.TetrisMain;

public class TetrisApplet extends javax.swing.JApplet //java.applet.Applet
{

    public TetrisApplet() {
        /*addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
        TetrisFormKeyPressed(evt);
        }
        });*/
        addKeyListener(new schoolalyzer.tetris.logica.Teclado());
    }

    @Override
    public void init() {
        TetrisMain.appletPrincipal = this;
        TetrisMain.main(null);
    }

    //Devuelve el componente PanelJuego:
    public Graphics getGamePanel() {
        return this.getGraphics();
    }

    /*
    public void paint(Graphics g)    
    {
    super.paint(g);
    }
     */

    /*
    private void TetrisFormKeyPressed(java.awt.event.KeyEvent evt)
    {
    Main.procesarTecla(evt.getKeyCode());
    }
     */
}
