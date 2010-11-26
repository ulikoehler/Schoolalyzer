/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import javax.swing.table.AbstractTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author uli
 */
public class ExcelTableModel extends AbstractTableModel {

    private Sheet sheet = null;

    public ExcelTableModel(Sheet sheet) {
        this.sheet = sheet;
    }

    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    public int getColumnCount() {
        return 64; //Just an arbitrary value
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cell cell = sheet.getRow(rowIndex).getCell(columnIndex);
        if (cell == null) {
            throw new IllegalStateException("The returned Cell is null for row = " + rowIndex + " and column = " + columnIndex);
        }
        return POIUtil.getStringCellValueSafe(cell);
    }
}
