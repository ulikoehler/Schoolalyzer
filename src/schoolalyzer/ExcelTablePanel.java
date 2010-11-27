/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExcelTablePanel.java
 *
 * Created on 26.11.2010, 20:34:52
 */

package schoolalyzer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import org.apache.poi.ss.usermodel.Sheet;
import schoolalyzer.actions.ActionManager;

/**
 *
 * @author uli
 */
public class ExcelTablePanel extends javax.swing.JPanel {
    private Sheet sheet = null;
    private SchoolalzyerFrame parentFrame = null;

    /** Creates new form ExcelTablePanel */
    public ExcelTablePanel() {
        initComponents();
    }

    public void setParentFrame(SchoolalzyerFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
        table.setDefaultRenderer(Object.class, new ExcelCellRenderer());
        table.setModel(new ExcelTableModel(sheet));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setCellSelectionEnabled(true);
        //Resize the columns
        /*for(int i = 0; i < table.getColumnCount() ; i++)
        {
            table.getColumnModel().getColumn(i).setPreferredWidth(sheet.getColumnWidth(i));
        }*/
        JPopupMenu popupMenu = new JPopupMenu();
        for(String name : ActionManager.getInstance().getActionNames())
        {
            JMenuItem menuItem = new JMenuItem(name);
            menuItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    for(int selectedRow : table.getSelectedRows())
                    {
                        for(int selectedColumn : table.getSelectedColumns())
                        {
                            
                        }
                    }
                }
            });
            popupMenu.add(menuItem);
        }
        table.setComponentPopupMenu();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        tableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableScrollPane.setViewportView(table);

        add(tableScrollPane);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
