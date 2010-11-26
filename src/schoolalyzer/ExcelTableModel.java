/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import javax.swing.table.AbstractTableModel;
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
        return 8192;
    }

    public int getColumnCount() {
        return 26; //A-Z
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return sheet.getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
    }
}
