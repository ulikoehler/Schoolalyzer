/** 
 * 
 * @author Joan Alba Maldonado
 */
//Falta: en totes les classes, impedir ficar valors no possibles en els sets (valors negatius, etc).
package schoolalyzer.tetris.logica;

import java.util.TimerTask;

public class TimerRepintado extends TimerTask {

    protected TetrisGame juego;

    public TimerRepintado(TetrisGame juego) {
        super();
        this.juego = juego;
    }

    @Override
    public void run() {
        if (this.juego != null) {
            this.juego.representarTodo(this.juego.getContenedorGrafico());
        }
    }
}
