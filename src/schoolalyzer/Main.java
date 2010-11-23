/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author uli
 */
public class Main {

    //The rows and columns to consider
    private static final int[] rows = new int[]{15, 23, 33, 41, 51, 59, 69, 77, 87, 95, 105, 113, 123, 131, 141, 149, 159, 167, 177, 185, 195, 203, 215, 223, 233, 241, 251, 259, 269, 277, 287, 295, 305, 313}; //Real row numbers: lowest is 1
    private static final int[] cols = new int[]{6, 7, 8, 9, 10, 11, 12}; //Real col numbers: lowest is 1

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidFormatException {
        //Get the template
        JFileChooser templateChooser = new JFileChooser();
        templateChooser.setDialogTitle("Select the template");
        templateChooser.setMultiSelectionEnabled(false);
        templateChooser.showOpenDialog(null);
        File template = templateChooser.getSelectedFile();
        //Get the input files
        JFileChooser dataChooser = new JFileChooser();
        dataChooser.setCurrentDirectory(template);
        dataChooser.setDialogTitle("Select the data files");
        dataChooser.setMultiSelectionEnabled(true);
        dataChooser.showOpenDialog(null);
        File[] dataFiles = dataChooser.getSelectedFiles();
        System.out.println("Selected " + dataFiles.length + " data files");
        //Get the output file
        JFileChooser outputChooser = new JFileChooser();
        outputChooser.setCurrentDirectory(template);
        outputChooser.setDialogTitle("Select the output file");
        outputChooser.showSaveDialog(null);
        File outputFile = outputChooser.getSelectedFile();
        //Sum up the values
        InputStream templateIn = new BufferedInputStream(new FileInputStream(template));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile));
        Workbook outputWorkbook = WorkbookFactory.create(templateIn);
        Sheet outputSheet = outputWorkbook.getSheetAt(0);
        for (File inputFile : dataFiles) {
            InputStream is = new BufferedInputStream(new FileInputStream(inputFile));
            //Iterate over the rows and
            Workbook inputWorkbook = WorkbookFactory.create(is);
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            for (int realRow : rows) {
                Row inputRow = inputSheet.getRow(realRow - 1); //-1: realRow is 1-based
                Row outputRow = outputSheet.getRow(realRow - 1);
                for (int realCol : cols) {
                    Cell inputCell = inputRow.getCell(realCol - 1); //-1: realCol is 1-based
                    Cell outputCell = outputRow.getCell(realCol - 1);
                    //Calculate the sum
                    int inputValue = (int) inputCell.getNumericCellValue();
                    //System.out.println(realRow + "," + realCol + "," + inputValue);
                    int outputValue = inputValue + (int) outputCell.getNumericCellValue();
                    outputCell.setCellValue(outputValue);
                }
            }
            //Close the stream
            is.close();
        }
        //Write the data to the output field
        outputWorkbook.write(os);
        //Close the remaining streams
        templateIn.close();
        os.close();

    }
}
