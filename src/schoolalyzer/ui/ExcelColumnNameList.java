/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schoolalyzer.ui;

import java.util.AbstractList;
import schoolalyzer.util.POIUtil;

/**
 *
 * @author uli
 */
public class ExcelColumnNameList extends AbstractList<String> {

    @Override
    public String get(int index) {
        return POIUtil.generateColumnName(index);
    }

    @Override
    public int size() {
        return 1000;
    }


}
