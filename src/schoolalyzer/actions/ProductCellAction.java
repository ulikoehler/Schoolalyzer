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
public class ProductCellAction extends AbstractCellAction {

    public ProductCellAction(int row, int column) {
        super(row, column);
    }

    @Override
    public String getActionName() {
        return "Produkt";
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
        double product = 1;
        for (Object o : inputValues) {
            product *= (Double) o;
        }
        return product;
    }
}
