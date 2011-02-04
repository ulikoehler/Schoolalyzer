/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DocumentMergerFrame.java
 *
 * Created on 28.01.2011, 16:31:37
 */
package schoolalyzer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import schoolalyzer.ui.ExcelColumnNameList;
import schoolalyzer.util.POIUtil;

/**
 *
 * @author uli
 */
public class DataValidationFrame extends javax.swing.JFrame {

    //File choosers
    private JFileChooser inputFileChooser = new JFileChooser(new File("."));
    //Logging
    private static final Logger logger = Logger.getLogger(DataValidationFrame.class.getName());
    //Status variables
    boolean inputsSet = false;
    //IO data
    private List<Workbook> inputWorkbooks = new LinkedList<Workbook>();
    private File outputWorkbookFile = null;

    /** Creates new form DocumentMergerFrame */
    public DataValidationFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
    }

    /**
     * Saves the output workbook in the output file
     */
    private void saveOutputWorkbook() throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(outputWorkbookFile));
        os.close();
    }

    private ComboBoxModel getConstraintsModel()
    {
        List<String> list = new LinkedList<String>();
        list.add("Keine");
        list.add("Nichtleer");
        list.add("Leer");
        list.add("Zahl");
        list.add("Kleiner als");
        list.add("Größer als");
        return new DefaultComboBoxModel(list.toArray(new String[list.size()]));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        selectInputFilesButton = new javax.swing.JButton();
        inputFilesLabel = new javax.swing.JLabel();
        inputStatusLabel = new javax.swing.JLabel();
        startRowLabel = new javax.swing.JLabel();
        startRowSpinner = new schoolalyzer.ui.NumberSpinner();
        startColLabel = new javax.swing.JLabel();
        startColSpinner = new javax.swing.JSpinner();
        sheetIndexLabel = new javax.swing.JLabel();
        sheetIndexSpinner = new schoolalyzer.ui.NumberSpinner();
        colCountLabel = new javax.swing.JLabel();
        colCountSpinner = new schoolalyzer.ui.NumberSpinner();
        constraintsLabel = new javax.swing.JLabel();
        currentColumnSpinner = new schoolalyzer.ui.NumberSpinner();
        Spalte = new javax.swing.JLabel();
        currentColumnConstraintComboBox = new javax.swing.JComboBox();

        setTitle("Schoolalyzer - Dokumente zusammenführen");
        setIconImage(SchoolalyzerFrame.piIcon.getImage());

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/task-complete.png"))); // NOI18N
        okButton.setText("Überprüfen");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        selectInputFilesButton.setText("Auswählen");
        selectInputFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInputFilesButtonActionPerformed(evt);
            }
        });

        inputFilesLabel.setText("Eingabedateien:");

        inputStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/dialog-information.png"))); // NOI18N
        inputStatusLabel.setText("Bitte Eingabedateien laden!");

        startRowLabel.setText("Ab Zeile:");

        startRowSpinner.setIntValue(1);
        startRowSpinner.setMinimum(new Integer(1));

        startColLabel.setText("Ab Spalte:");

        startColSpinner.setModel(new SpinnerListModel(new ExcelColumnNameList()));

        sheetIndexLabel.setText("Blattnummer:");

        sheetIndexSpinner.setIntValue(1);
        sheetIndexSpinner.setMinimum(new Integer(1));

        colCountLabel.setText("Spaltenanzahl:");

        colCountSpinner.setIntValue(1);
        colCountSpinner.setMinimum(new Integer(1));

        constraintsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        constraintsLabel.setText("Bedingungen:");

        Spalte.setText("Spalte:");

        currentColumnConstraintComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startColLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sheetIndexLabel)
                            .addComponent(startRowLabel))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sheetIndexSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(startRowSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(startColSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputFilesLabel)
                        .addGap(6, 6, 6)
                        .addComponent(selectInputFilesButton)
                        .addGap(18, 18, 18)
                        .addComponent(inputStatusLabel)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colCountLabel)
                        .addGap(18, 18, 18)
                        .addComponent(colCountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(constraintsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(Spalte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(currentColumnConstraintComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentColumnSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sheetIndexLabel)
                    .addComponent(sheetIndexSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startRowLabel)
                    .addComponent(startRowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startColLabel)
                    .addComponent(startColSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colCountLabel)
                    .addComponent(colCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFilesLabel)
                    .addComponent(inputStatusLabel)
                    .addComponent(selectInputFilesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(constraintsLabel)
                    .addComponent(Spalte)
                    .addComponent(currentColumnSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentColumnConstraintComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (!inputsSet) {
            JOptionPane.showMessageDialog(this, "Bitte Eingabedateien laden!", "Eingabedateien nicht geladen", JOptionPane.ERROR_MESSAGE, SchoolalyzerFrame.errorIcon);
            return;
        }
        //Read the start and the stop row
        int colCount = colCountSpinner.getIntValue();
        int sheetNum = sheetIndexSpinner.getIntValue() - 1;
        int startRow = startRowSpinner.getIntValue() - 1; //-1: 1-based must be converted to 0-based
        int startCol = POIUtil.getColumnNumber(((SpinnerListModel) startColSpinner.getModel()).getValue().toString());
        for (Workbook inputWorkbook : inputWorkbooks) {
            Sheet inputSheet = inputWorkbook.getSheetAt(sheetNum);
            int currentInputRowIndex = startRow;
            while (true) { //Iterate over all rows
                //If all columns are empty, break
                boolean breakRowLoop = true; //Set to true if the loop iterating over all rows shouldn't be broken
                for (int i = startCol; i < (startCol + colCount); i++) { //Sets breakRowLoop to false if neccessary
                    //System.out.println("Breaking at row " + currentInputRowIndex);
                    if (!POIUtil.isEmpty(inputSheet, currentInputRowIndex, i)) { //Break only if all cols are empty
                        breakRowLoop = false;
                    }
                }
                if (breakRowLoop) { //Break if neccessary
                    break;
                }
                //Process the current row
                int currentInputColIndex = startCol;
                for (int i = 0; i < colCount; i++) { //Iterate over the columns in the current row until one is empty
                    //The cell is not empty --> copy the value into the output document
                    
                }
                currentInputRowIndex++;
            }
        }
        try {
            //Save the output workbook
            saveOutputWorkbook();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Schreiben des Dokuments: " + ex.getLocalizedMessage(), "Schreibfehler", JOptionPane.ERROR_MESSAGE, SchoolalyzerFrame.errorIcon);

        }
        JOptionPane.showMessageDialog(this, "Die Berechnung wurde erfolgreich abgeschlossen!", "Erfolg", JOptionPane.INFORMATION_MESSAGE, SchoolalyzerFrame.okIcon);
}//GEN-LAST:event_okButtonActionPerformed

    private void selectInputFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectInputFilesButtonActionPerformed
        //Let the user select the files to load
        inputFileChooser.setDialogTitle("Eingabedateien auswählen");
        inputFileChooser.setMultiSelectionEnabled(true);
        if (inputFileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File[] dataFiles = inputFileChooser.getSelectedFiles();
        if (dataFiles.length == 0) {
            return; //No files to be processed
        }
        //Reset the input workbook data
        try {
            for (File dataFile : dataFiles) {
                inputWorkbooks.add(POIUtil.loadWorkbook(dataFile));
            }
        } catch (IOException ex) {
            inputStatusLabel.setIcon(SchoolalyzerFrame.errorIcon);
            inputStatusLabel.setText("Eingabefehler - bitte Vorlage erneut laden!");
            inputsSet = false;
            return;
        } catch (InvalidFormatException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen der Vorlage: Das Dateiformat wird nicht unterstützt: " + ex.getLocalizedMessage(), "Format nicht unterstützt", JOptionPane.ERROR_MESSAGE, SchoolalyzerFrame.errorIcon);
            inputStatusLabel.setIcon(SchoolalyzerFrame.errorIcon);
            inputStatusLabel.setText("Formatfehler - bitte Vorlage erneut laden!");
            inputsSet = false;
            return;
        }
        //Set the status message
        inputsSet = true;
        inputStatusLabel.setIcon(SchoolalyzerFrame.okIcon);
        inputStatusLabel.setText(dataFiles.length + " Eingabedateien erfolgreich geladen");
}//GEN-LAST:event_selectInputFilesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DataValidationFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Spalte;
    private javax.swing.JLabel colCountLabel;
    private schoolalyzer.ui.NumberSpinner colCountSpinner;
    private javax.swing.JLabel constraintsLabel;
    private javax.swing.JComboBox currentColumnConstraintComboBox;
    private schoolalyzer.ui.NumberSpinner currentColumnSpinner;
    private javax.swing.JLabel inputFilesLabel;
    private javax.swing.JLabel inputStatusLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JButton selectInputFilesButton;
    private javax.swing.JLabel sheetIndexLabel;
    private schoolalyzer.ui.NumberSpinner sheetIndexSpinner;
    private javax.swing.JLabel startColLabel;
    private javax.swing.JSpinner startColSpinner;
    private javax.swing.JLabel startRowLabel;
    private schoolalyzer.ui.NumberSpinner startRowSpinner;
    // End of variables declaration//GEN-END:variables
}