/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.util;

import java.awt.Color;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

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

    /**
     * @return The cell or null if it doesn't exist.
     */
    public static Cell getCellSafe(Sheet sheet, int rowIndex, int columnIndex) {
        if (sheet == null) {
            throw new IllegalArgumentException("The sheet argument is null!");
        }
        if (rowIndex > sheet.getLastRowNum()) {
            return null;
        }
        Row row = sheet.getRow(rowIndex);
        if (row == null) //undefined row
        {
            return null;
        }
        if (row.getLastCellNum() - 1 < columnIndex) {
            return null;
        }
        return row.getCell(columnIndex);
    }

    public static Color getVisibleForegroundColor(Color backgroundColor) {
        if ((backgroundColor.getRed() + backgroundColor.getGreen() + backgroundColor.getBlue()) / 127.0 > 127) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

    public static Color getForegroundColor(CellStyle cellStyle) {
        short[] foregroundTriplet = ((HSSFColor) cellStyle.getFillForegroundColorColor()).getTriplet();
        return new Color(foregroundTriplet[0], foregroundTriplet[1], foregroundTriplet[2]);
    }

    public static Color getBackgroundColor(CellStyle cellStyle) {
        if (cellStyle.getFillPattern() != CellStyle.SOLID_FOREGROUND) {
            return Color.WHITE;
        }
        short[] backgroundTriplet = ((HSSFColor) cellStyle.getFillBackgroundColorColor()).getTriplet();
        return new Color((int) backgroundTriplet[0], (int) backgroundTriplet[1], (int) backgroundTriplet[2]);
    }
}
