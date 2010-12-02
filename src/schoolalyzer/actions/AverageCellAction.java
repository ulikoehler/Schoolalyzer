/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.actions;

import java.util.List;

/**
 *
 * @author uli
 */
public class AverageCellAction extends AbstractCellAction {

    public AverageCellAction(int row, int column) {
        super(row, column);
    }

    @Override
    public String getActionName() {
        return "Mittelwert (arithmetisch)";
    }

    @Override
    protected CellValueType getResultType() {
        return CellValueType.DOUBLE;
    }

    @Override
    protected CellValueType getInputType() {
        return CellValueType.DOUBLE;
    }

    @Override
    protected Object doAction(List<? extends Object> inputValues) {
        double sum = 0;
        int count = 0;
        for (Object o : inputValues) {
            sum += (Double) o;
        }
        return sum / count;
    }
}
