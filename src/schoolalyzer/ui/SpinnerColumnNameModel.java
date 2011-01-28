/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.ui;

import javax.swing.AbstractSpinnerModel;
import javax.swing.SpinnerModel;
import schoolalyzer.util.POIUtil;

/**
 * Implements a spinner model providing excel/OOo column names (A, B, ..., AA, ...)
 * @author uli
 */
public class SpinnerColumnNameModel extends AbstractSpinnerModel {

    public int index = 0; //current 0-based column index

    public int getColumnIndex() {
        return index;
    }

    public Object getValue() {
        return POIUtil.generateColumnName(index);
    }

    public void setValue(Object value) {
        if (value instanceof Number) {
            Number n = (Number) value;
            //Try to generate a column name from the number;
            //if it's out of range, an IllegalArgumentException will be raised
            POIUtil.generateColumnName(n.intValue());
            //If this code is executed, the number is valid
            this.index = n.intValue();
        } else if (value instanceof String) {
            this.index = POIUtil.getColumnNumber((String) value); //Auto-raises IllegalArgumentException on invalid string
        }
    }

    public Object getNextValue() {
        return POIUtil.generateColumnName(index + 1);
    }

    public Object getPreviousValue() {
        if (index == 0) {
            return null;
        }
        return POIUtil.generateColumnName(index - 1);
    }
}
