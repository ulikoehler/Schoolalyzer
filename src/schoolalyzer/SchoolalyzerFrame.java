/*
 * SchoolalzyerFrame.java
 *
 * Created on 26.11.2010, 20:27:52
 */
package schoolalyzer;

import java.util.logging.Level;
import schoolalyzer.ui.ExcelTablePanel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import schoolalyzer.actions.AbstractCellAction;
import schoolalyzer.util.POIUtil;

/**
 *
 * @author uli
 */
public class SchoolalyzerFrame extends javax.swing.JFrame {

    private HashMap<Workbook, String> inputWorkbooks = new HashMap<Workbook, String>(); //Maps the worbook to the filename (not path!) it was loaded from
    private Workbook outputWorkbook = null;
    private File outputWorkbookFile = null;
    //Icons
    public static ImageIcon informationIcon = new ImageIcon(SchoolalyzerFrame.class.getResource("/schoolalyzer/icons/dialog-information.png"));
    public static ImageIcon warningIcon = new ImageIcon(SchoolalyzerFrame.class.getResource("/schoolalyzer/icons/dialog-warning.png"));
    public static ImageIcon errorIcon = new ImageIcon(SchoolalyzerFrame.class.getResource("/schoolalyzer/icons/dialog-error.png"));
    public static ImageIcon okIcon = new ImageIcon(SchoolalyzerFrame.class.getResource("/schoolalyzer/icons/task-complete.png"));
    public static ImageIcon piIcon = new ImageIcon(SchoolalyzerFrame.class.getResource("/schoolalyzer/icons/preferences-kcalc-constants.png"));
    //File choosers
    private JFileChooser outputChooser = new JFileChooser();
    private JFileChooser templateChooser = new JFileChooser();
    private JFileChooser inputFileChooser = new JFileChooser();
    //Actions
    private HashMap<String, LinkedList<AbstractCellAction>> actions = new HashMap<String, LinkedList<AbstractCellAction>>();
    //Logging
    private static final Logger logger = Logger.getLogger(SchoolalyzerFrame.class.getName());
    //Status variables
    boolean templateSet = false;
    boolean inputsSet = false;
    boolean outputSet = false;
    //Frames
    private ActionListFrame actionListFrame = new ActionListFrame();
    private CSVImporterFrame csvImporterFrame = new CSVImporterFrame();
    private DocumentMergerFrame documentMergerFrame = new DocumentMergerFrame();

    public HashMap<String, LinkedList<AbstractCellAction>> getActions() {
        return actions;
    }

    public void removeCellAction(String sheetName, AbstractCellAction action) {
        LinkedList<AbstractCellAction> actionList = actions.get(sheetName);
        if (!actionList.remove(action)) {
            logger.log(Level.SEVERE, "The action couldn''t be removed from sheet ''{0}''", sheetName);
        }
    }

    /**
     * Updates the JTree in the action list frame
     */
    public void updateActionViewerTree() {
        actionListFrame.update();
    }

    public void addCellAction(String sheetName, AbstractCellAction action) {
        actions.get(sheetName).add(action);
    }

    /**
     * Saves the output workbook in the output file
     */
    private void saveOutputWorkbook() throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(outputWorkbookFile));
        outputWorkbook.write(os);
        os.close();
    }

    /** Creates new form SchoolalzyerFrame */
    public SchoolalyzerFrame() {
        initComponents();
        setLocationRelativeTo(null);
        //Set the current file chooser directory to the current directory
        outputChooser.setCurrentDirectory(new File("."));
        inputFileChooser.setCurrentDirectory(new File("."));
        templateChooser.setCurrentDirectory(new File("."));
        //Initialize the child frames
        actionListFrame.setParentFrame(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputFilesLabel = new javax.swing.JLabel();
        selectInputFilesButton = new javax.swing.JButton();
        templateFileLabel = new javax.swing.JLabel();
        selectTemplateButton = new javax.swing.JButton();
        outputFileLabel = new javax.swing.JLabel();
        selectOutputFileButton = new javax.swing.JButton();
        tablesTabbedPane = new javax.swing.JTabbedPane();
        templateStatusLabel = new javax.swing.JLabel();
        outputStatusLabel = new javax.swing.JLabel();
        inputStatusLabel = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        actionListButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        extrasMenu = new javax.swing.JMenu();
        importCSVMenuItem = new javax.swing.JMenuItem();
        mergeDocumentsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Schoolalyzer");
        setIconImage(piIcon.getImage());

        inputFilesLabel.setText("Eingabedateien:");

        selectInputFilesButton.setText("Auswählen");
        selectInputFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInputFilesButtonActionPerformed(evt);
            }
        });

        templateFileLabel.setText("Vorlage:");

        selectTemplateButton.setText("Auswählen");
        selectTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTemplateButtonActionPerformed(evt);
            }
        });

        outputFileLabel.setText("Ausgabedatei:");

        selectOutputFileButton.setText("Auswählen");
        selectOutputFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOutputFileButtonActionPerformed(evt);
            }
        });

        templateStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/dialog-information.png"))); // NOI18N
        templateStatusLabel.setText("Bitte Vorlage laden!");

        outputStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/dialog-information.png"))); // NOI18N
        outputStatusLabel.setText("Bitte Ausgabedatei auswählen !");

        inputStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/dialog-information.png"))); // NOI18N
        inputStatusLabel.setText("Bitte Eingabedateien laden!");

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolalyzer/icons/task-complete.png"))); // NOI18N
        applyButton.setText("Anwenden");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        actionListButton.setText("Liste der Berechnungen");
        actionListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionListButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("Datei");

        exitMenuItem.setText("Beenden");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        extrasMenu.setText("Extras");

        importCSVMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        importCSVMenuItem.setText("CSV-Importer");
        importCSVMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importCSVMenuItemActionPerformed(evt);
            }
        });
        extrasMenu.add(importCSVMenuItem);

        mergeDocumentsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mergeDocumentsMenuItem.setText("Tabellen zusammenführen");
        mergeDocumentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeDocumentsMenuItemActionPerformed(evt);
            }
        });
        extrasMenu.add(mergeDocumentsMenuItem);

        menuBar.add(extrasMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(actionListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 895, Short.MAX_VALUE)
                        .addComponent(applyButton))
                    .addComponent(tablesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputFilesLabel)
                            .addComponent(templateFileLabel)
                            .addComponent(outputFileLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectTemplateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectInputFilesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectOutputFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputStatusLabel)
                            .addComponent(templateStatusLabel)
                            .addComponent(outputStatusLabel))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(templateFileLabel)
                    .addComponent(selectTemplateButton)
                    .addComponent(templateStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFilesLabel)
                    .addComponent(selectInputFilesButton)
                    .addComponent(inputStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectOutputFileButton)
                    .addComponent(outputFileLabel)
                    .addComponent(outputStatusLabel))
                .addGap(18, 18, 18)
                .addComponent(tablesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(actionListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        inputWorkbooks.clear();
        //Open all the files as Workbooks
        for (File file : dataFiles) {
            try {
                inputWorkbooks.put(POIUtil.loadWorkbook(file), file.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Eingabefehler beim Lesen der Datei " + file.getName(), "Eingabefehler", JOptionPane.ERROR_MESSAGE, errorIcon);
                inputStatusLabel.setIcon(errorIcon);
                inputStatusLabel.setText("Eingabefehler - bitte Dateien erneut laden!");
                inputsSet = true;
            } catch (InvalidFormatException ex) {
                JOptionPane.showMessageDialog(this, "Das Format der Datei " + file.getName() + " wird nicht unterstützt", "Format nicht unterstützt", JOptionPane.ERROR_MESSAGE, errorIcon);
                inputStatusLabel.setIcon(errorIcon);
                inputStatusLabel.setText("Formatfehler - bitte Dateien erneut laden!");
                inputsSet = false;
            }
        }
        //Find all sheet being present in all workbooks
        //Algorithm: Initialize a list with the sheets of the first input document;
        //  then iterate over the workbooks and remove sheet names not being in the workbook
        LinkedList<String> sheetNames = new LinkedList<String>();
        boolean isFirstWorkbook = true;
        Workbook firstWorkbook = null;
        for (Workbook workbook : inputWorkbooks.keySet()) {
            if (isFirstWorkbook) {
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    sheetNames.add(workbook.getSheetName(i));
                }
                firstWorkbook = workbook;
                isFirstWorkbook = false;
            } else {
                for (String sheetName : sheetNames) {
                    if (workbook.getSheet(sheetName) == null) {
                        sheetNames.remove(sheetName);
                    }
                }
            }
        }
        //Add the common sheets as tabs
        for (String sheetName : sheetNames) {
            ExcelTablePanel panel = new ExcelTablePanel();
            panel.setParentFrame(this);
            Sheet sheet = firstWorkbook.getSheet(sheetName);
            panel.setSheet(sheet);
            tablesTabbedPane.addTab(sheetName, panel);
            actions.put(sheet.getSheetName(), new LinkedList<AbstractCellAction>());
        }
        //Set the status message
        inputsSet = true;
        inputStatusLabel.setIcon(okIcon);
        inputStatusLabel.setText(inputWorkbooks.size() + " Eingabedateien erfolgreich geladen");
    }//GEN-LAST:event_selectInputFilesButtonActionPerformed

    private void selectOutputFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectOutputFileButtonActionPerformed
        outputChooser.setDialogTitle("Select the output file");
        if (outputChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        outputSet = false;
        File tempOutputFile = outputChooser.getSelectedFile();
        if (tempOutputFile.exists()) {
            int overwrite = JOptionPane.showConfirmDialog(this, "Datei existiert - überschreiben?", "Überschreiben", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (overwrite != JOptionPane.YES_OPTION) {
                return;
            }
        }
        if (!tempOutputFile.canWrite() && (!tempOutputFile.exists() && !tempOutputFile.getParentFile().canWrite())) {
            JOptionPane.showMessageDialog(this, "In diese Datei kann nicht geschrieben werden! Bitte andere Ausgabedatei wählen!", "Schreiben nicht erlaubt", JOptionPane.ERROR_MESSAGE, errorIcon);
            return;
        }
        //Everything's OK, so set the status label and the output file member variable
        outputWorkbookFile = tempOutputFile;
        outputStatusLabel.setIcon(okIcon);
        outputStatusLabel.setText("Ausgabedatei erfolgreich gesetzt");
        outputSet = true;
    }//GEN-LAST:event_selectOutputFileButtonActionPerformed

    private void selectTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTemplateButtonActionPerformed
        //Show a dialog
        templateChooser.setDialogTitle("Vorlage auswählen");
        templateChooser.setMultiSelectionEnabled(false);
        if (templateChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File templateFile = templateChooser.getSelectedFile();
        //If the action does not succeed, the users sees the standard message
        templateSet = false;
        templateStatusLabel.setText("Bitte Vorlage laden!");
        templateStatusLabel.setIcon(informationIcon);
        //Load the template
        try {
            outputWorkbook = POIUtil.loadWorkbook(templateFile); //There is no separate templateWorkbook variable because the only use of the template file is to provide empty fields for the output
            templateStatusLabel.setIcon(okIcon);
            templateStatusLabel.setText("Vorlage erfolgreich geladen");
            templateSet = true;
        } catch (IOException ex) {
            templateStatusLabel.setIcon(errorIcon);
            templateStatusLabel.setText("Eingabefehler - bitte Vorlage erneut laden!");
        } catch (InvalidFormatException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen der Vorlage: Das Dateiformat wird nicht unterstützt: " + ex.getLocalizedMessage(), "Format nicht unterstützt", JOptionPane.ERROR_MESSAGE, errorIcon);
            templateStatusLabel.setIcon(errorIcon);
            templateStatusLabel.setText("Formatfehler - bitte Vorlage erneut laden!");
        }
    }//GEN-LAST:event_selectTemplateButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        //Check if everything is set
        if (!templateSet) {
            JOptionPane.showMessageDialog(this, "Bitte Vorlage laden!", "Vorlage nicht geladen", JOptionPane.ERROR_MESSAGE, errorIcon);
            return;
        }
        if (!outputSet) {
            JOptionPane.showMessageDialog(this, "Bitte Ausgabedatei setzen!", "Ausgabedatei nicht gesetzt", JOptionPane.ERROR_MESSAGE, errorIcon);
            return;
        }
        if (!inputsSet) {
            JOptionPane.showMessageDialog(this, "Bitte Eingabedateien laden!", "Eingabedateien nicht geladen", JOptionPane.ERROR_MESSAGE, errorIcon);
            return;
        }
        //Apply all actions
        for (Map.Entry<String, LinkedList<AbstractCellAction>> entry : actions.entrySet()) {
            //Build a list of sheets to apply the action on
            HashMap<Sheet, Workbook> sheetToWorkbook = new HashMap<Sheet, Workbook>();
            LinkedList<Sheet> sheets = new LinkedList<Sheet>();
            for (Workbook workbook : inputWorkbooks.keySet()) {
                Sheet sheet = workbook.getSheet(entry.getKey());
                sheetToWorkbook.put(sheet, workbook);
                sheets.add(sheet);
            }

            //Apply all actions to the sheet list
            for (AbstractCellAction action : entry.getValue()) {
                if (action == null) {
                    logger.severe("Internal Error: The action is null!");
                }
                try {
                    action.apply(sheets, outputWorkbook.getSheet(entry.getKey()));
                } catch (CellTypeException ex) {
                    JOptionPane.showMessageDialog(this, "Fehler in der Datei '" + inputWorkbooks.get(sheetToWorkbook.get(ex.getSheet())) + "' (Blatt '" + entry.getKey() + "') :\n" + ex.getUnderlyingCauseLocalizedMessage(), "Datenfehler", JOptionPane.ERROR_MESSAGE, errorIcon);
                    return;
                }
            }
        }
        try {
            //Save the workbook
            saveOutputWorkbook();
            JOptionPane.showMessageDialog(this, "Die Berechnung wurde erfolgreich abgeschlossen!", "Erfolg", JOptionPane.INFORMATION_MESSAGE, okIcon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Schreiben des Dokuments: " + ex.getLocalizedMessage(), "Schreibfehler", JOptionPane.ERROR_MESSAGE, errorIcon);
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void actionListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionListButtonActionPerformed
        actionListFrame.update();
        actionListFrame.setVisible(true);
    }//GEN-LAST:event_actionListButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void importCSVMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importCSVMenuItemActionPerformed
        csvImporterFrame.setVisible(true);
    }//GEN-LAST:event_importCSVMenuItemActionPerformed

    private void mergeDocumentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeDocumentsMenuItemActionPerformed
        documentMergerFrame.setVisible(true);
    }//GEN-LAST:event_mergeDocumentsMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SchoolalyzerFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionListButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu extrasMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem importCSVMenuItem;
    private javax.swing.JLabel inputFilesLabel;
    private javax.swing.JLabel inputStatusLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mergeDocumentsMenuItem;
    private javax.swing.JLabel outputFileLabel;
    private javax.swing.JLabel outputStatusLabel;
    private javax.swing.JButton selectInputFilesButton;
    private javax.swing.JButton selectOutputFileButton;
    private javax.swing.JButton selectTemplateButton;
    private javax.swing.JTabbedPane tablesTabbedPane;
    private javax.swing.JLabel templateFileLabel;
    private javax.swing.JLabel templateStatusLabel;
    // End of variables declaration//GEN-END:variables
}
