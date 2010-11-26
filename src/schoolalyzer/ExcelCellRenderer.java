/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author uli
 */
public class ExcelCellRenderer implements TableCellRenderer {

    private Sheet sheet = null;

    public ExcelCellRenderer(Sheet sheet) {
        this.sheet = sheet;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel(value.toString());
        if (isSelected) {
            label.setBackground(Color.BLUE);
            label.setForeground(Color.WHITE);
        } else {
            //Set the colors from the Excel document
            CellStyle cellStyle = sheet.getRow(row).getCell(column).getCellStyle();
            label.setBackground(new Color(cellStyle.getFillBackgroundColor()));
            label.setForeground(new Color(cellStyle.getFillForegroundColor()));
        }
        return label;
    }
}
