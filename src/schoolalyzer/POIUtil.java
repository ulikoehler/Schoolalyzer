/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author uli
 */
public class POIUtil {

    /**
     * Returns a cell value as a String no matter of the cell type
     * @param cell The cell to get the value from
     * @return The cell value as a String
     */
    public static String getStringCellValueSafe(Cell cell) {
        //Check if the cell is null
        if (cell == null) {
            throw new IllegalArgumentException("Cell argument is null!");
        }
        //Check the cell type
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return ((Boolean) cell.getBooleanCellValue()).toString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            return ((Byte) cell.getErrorCellValue()).toString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return ((Double) cell.getNumericCellValue()).toString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        }
        throw new IllegalStateException("The cell has an unknown type!");
    }
}
