/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author uli
 */
public class CellTypeException extends IllegalStateException {

    public CellTypeException(Throwable cause) {
        super(cause);
    }

    public String getUnderlyingCauseLocalizedMessage() {
        return getCause().getLocalizedMessage();
    }
    private Sheet sheet = null;

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }
}
