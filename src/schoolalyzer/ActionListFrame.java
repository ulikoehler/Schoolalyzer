/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * actionListFrame.java
 *
 * Created on 28.11.2010, 02:30:59
 */
package schoolalyzer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import schoolalyzer.util.Tuple;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import schoolalyzer.actions.AbstractCellAction;
import schoolalyzer.util.SchoolalyzerUtil;

/**
 *
 * @author uli
 */
public class ActionListFrame extends javax.swing.JFrame {

    private CalculationFrame parentFrame = null;

    /** Creates new form actionListFrame */
    public ActionListFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void update() {
        tree.setModel(getModel());
    }

    public void setParentFrame(CalculationFrame parentFrame) {
        this.parentFrame = parentFrame;
        tree.setModel(getModel());
        //Add the popup menu
        JPopupMenu treePopupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Löschen");
        final CalculationFrame finalParent = parentFrame;
        deleteMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                for (TreePath path : tree.getSelectionPaths()) {
                    DataMutableTreeNode node = (DataMutableTreeNode) path.getLastPathComponent();
                    if (node.getType().equals("action")) {
                        Tuple<String, AbstractCellAction> tuple = (Tuple<String, AbstractCellAction>) node.getData();
                        finalParent.removeCellAction(tuple.getLeft(), tuple.getRight());
                        update();
                    }
                }
            }
        });
        treePopupMenu.add(deleteMenuItem);
        tree.setComponentPopupMenu(treePopupMenu);
    }

    private DefaultTreeModel getModel() {
        DataMutableTreeNode rootNode = new DataMutableTreeNode("Blätter");
        for (Map.Entry<String, LinkedList<AbstractCellAction>> entry : parentFrame.getActions().entrySet()) {
            DataMutableTreeNode sheetNode = new DataMutableTreeNode(entry.getKey());
            sheetNode.setType("sheet");
            for (AbstractCellAction action : entry.getValue()) {
                String label = String.format("%s: %s%d", action.getActionName(), SchoolalyzerUtil.getColumnName(action.getColumn()), action.getRow());
                DataMutableTreeNode actionNode = new DataMutableTreeNode(label);
                actionNode.setType("action");
                actionNode.setData(new Tuple<String, AbstractCellAction>(entry.getKey(), action));
                sheetNode.add(actionNode);
            }
            rootNode.add(sheetNode);
        }
        return new DefaultTreeModel(rootNode);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeScrollPane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        setTitle("Schoolalyzer - Berechnungen");
        setIconImage(CalculationFrame.piIcon.getImage());
        setLocationByPlatform(true);

        treeScrollPane.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables
}
