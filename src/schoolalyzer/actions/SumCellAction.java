/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.actions;

import java.util.List;

/**
 * Action summing cell values
 * @author uli
 */
public class SumCellAction extends AbstractCellAction {

    public SumCellAction(int row, int column) {
        super(row, column);
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
        for (Object o : inputValues) {
            sum += (Double) o;
        }
        return sum;
    }
}
