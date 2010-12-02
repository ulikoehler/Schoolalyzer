/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.ui;

import schoolalyzer.util.POIUtil;
import javax.swing.table.AbstractTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Table model returning POI Cells. Needs a special renderer.
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
        return POIUtil.getCellSafe(sheet, rowIndex, columnIndex);
    }
}
