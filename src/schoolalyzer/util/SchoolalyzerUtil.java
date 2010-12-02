/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.util;

/**
 *
 * @author uli
 */
public class SchoolalyzerUtil {

    private static final String columnNames = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getColumnName(int index) {
        return Character.toString(columnNames.charAt(index));
    }
}
