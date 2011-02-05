/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ActionSelectionFrame.java
 *
 * Created on 05.02.2011, 15:56:56
 */

package schoolalyzer;

/**
 *
 * @author rudi
 */
public class IntroFrame extends javax.swing.JFrame {
    //Frames
    private CalculationFrame calculateFrame = new CalculationFrame();
    private CSVImporterFrame csvImporterFrame = new CSVImporterFrame();
    private DocumentMergerFrame documentMergerFrame = new DocumentMergerFrame();

    /** Creates new form ActionSelectionFrame */
    public IntroFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculateMultiTableButton = new javax.swing.JButton();
        importCSVButton = new javax.swing.JButton();
        mergeSheetsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Schoolalyzer");
        setResizable(false);

        calculateMultiTableButton.setText("<html>Berechnungen über<p>\nmehrere Tabellen durchführen");
        calculateMultiTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateMultiTableButtonActionPerformed(evt);
            }
        });

        importCSVButton.setText("<html>CSV-Daten importieren");
        importCSVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importCSVButtonActionPerformed(evt);
            }
        });

        mergeSheetsButton.setText("<html>Excel-Tabellen zusammenführen");
        mergeSheetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeSheetsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calculateMultiTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importCSVButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mergeSheetsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculateMultiTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(importCSVButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(mergeSheetsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calculateMultiTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateMultiTableButtonActionPerformed
        calculateFrame.setVisible(true);
    }//GEN-LAST:event_calculateMultiTableButtonActionPerformed

    private void importCSVButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importCSVButtonActionPerformed
        csvImporterFrame.setVisible(true);
    }//GEN-LAST:event_importCSVButtonActionPerformed

    private void mergeSheetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeSheetsButtonActionPerformed
        documentMergerFrame.setVisible(true);
    }//GEN-LAST:event_mergeSheetsButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntroFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateMultiTableButton;
    private javax.swing.JButton importCSVButton;
    private javax.swing.JButton mergeSheetsButton;
    // End of variables declaration//GEN-END:variables

}
