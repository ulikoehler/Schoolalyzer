/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.actions;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import schoolalyzer.CellTypeException;

/**
 * This abstract class represents an action to be applied on one cell
 * @author uli
 */
public abstract class AbstractCellAction {

    private int row;
    private int column;

    public AbstractCellAction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void apply(Collection<Sheet> inputSheets, Sheet outputSheet) {
        //Get the input values
        LinkedList<Object> inputValues = new LinkedList<Object>();
        for (Sheet sheet : inputSheets) {
            Cell inputCell = sheet.getRow(row).getCell(column);
            try {
                switch (getInputType()) {
                    case BOOLEAN: {
                        inputValues.add(inputCell.getBooleanCellValue());
                        break;
                    }
                    case DATE: {
                        inputValues.add(inputCell.getDateCellValue());
                        break;
                    }
                    case DOUBLE: {
                        inputValues.add(inputCell.getNumericCellValue());
                        break;
                    }
                    case STRING: {
                        inputValues.add(inputCell.getStringCellValue());
                        break;
                    }
                }
            } catch (IllegalStateException ex) {
                //This code implements the exception translator pattern
                CellTypeException newEx = new CellTypeException(ex);
                newEx.setSheet(sheet);
                throw newEx;
            }
        }
        //Execute the action
        Object result = doAction(inputValues);
        //Write the result to the output cell
        Cell outputCell = outputSheet.getRow(row).getCell(column);
        switch (getResultType()) {
            case BOOLEAN: {
                outputCell.setCellValue((Boolean) result);
                break;
            }
            case DATE: {
                outputCell.setCellValue((Date) result);
                break;
            }
            case DOUBLE: {
                outputCell.setCellValue((Double) result);
                break;
            }
            case STRING: {
                outputCell.setCellValue((String) result);
                break;
            }
        }
    }

    /**
     * @return The ame of this action
     */
    public abstract String getActionName();

    /**
     * Must be implemented by an action implementation to tell
     * this class what class is returned by doAction.
     * @return The type of the result this action implementation returns.
     */
    protected abstract CellValueType getResultType();

    /**
     * Must be implemented by an action implementation to tell
     * this class what class is needed as parameter to doAction()
     * @return The type of parameter this implementation needs in doAction()
     */
    protected abstract CellValueType getInputType();

    protected abstract Object doAction(List<? extends Object> inputValues);
}
