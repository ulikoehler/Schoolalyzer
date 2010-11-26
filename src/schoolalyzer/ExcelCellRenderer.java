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

/**
 *
 * @author uli
 */
public class ExcelCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel(value.toString());
        if (isSelected) {
            label.setBackground(Color.BLUE);
            label.setForeground(Color.WHITE);
        }
        return label;
    }
}
