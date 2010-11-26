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
import javax.xml.bind.JAXB;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author uli
 */
public class ExcelCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            System.out.println("adad");
            JLabel label = new JLabel("");
            if (isSelected) {
                label.setForeground(Color.WHITE);
                label.setBackground(Color.BLUE);
            }
            return label;
        }
        //else: the value = the cell is not null
        Cell cell = (Cell) value;
        //Set the text
        JLabel label = new JLabel(POIUtil.getStringCellValueSafe(cell));
        label.setOpaque(true);
        //Set the foreground and the background colors
        if (isSelected) {
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLUE);
        } else {
            //Set the colors from the Excel document
            CellStyle cellStyle = cell.getCellStyle();
            //label.setForeground(POIUtil.getForegroundColor(cellStyle));
            Color backgroundColor = POIUtil.getBackgroundColor(cellStyle);
            label.setForeground(POIUtil.getVisibleForegroundColor(backgroundColor));
            label.setBackground(backgroundColor);
        }
        return label;
    }
}
