/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author uli
 */
public class CSVParser {

    private String enclosator = "\"";
    private String columnSeparator = ",";
    private BufferedReader streamSource = null;

    public CSVParser(InputStream inputSource, String enclosator, String columnSeparator) {
        this.streamSource = new BufferedReader(new InputStreamReader(inputSource));
        this.enclosator = enclosator;
        this.columnSeparator = columnSeparator;
    }

    /**
     * @return An array list of the elements of this CSV line or null if there is no line left
     */
    public ArrayList<String> next() throws IOException {
        /**
         * If the next code is executed, the buffer is empty,
         * so try to get the data
         */
        String line = streamSource.readLine();
        if (line == null) {
            streamSource.close();
            return null;
        }

        ArrayList<String> lineData = new ArrayList<String>(32); //It's unlikely there are more than 32 fields
        StringBuilder sb = new StringBuilder();
        boolean inEnclosedRegion = false;

        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);
            String cAsString = new Character(c).toString(); //String representation of c
            if (this.enclosator.contains(cAsString)) {
                inEnclosedRegion = !inEnclosedRegion;
            } else if (this.columnSeparator.contains(String.valueOf(cAsString)) && !inEnclosedRegion) {
                //Append the string buffer content to the list and clear the buffer
                lineData.add(sb.toString());
                sb.setLength(0);
            } else { //'Normal' character
                sb.append(c);
            }
        }
        if (sb.length() > 0) { //If there is content in the string buffer
            //Append the string buffer content to the list
            lineData.add(sb.toString());
        }
        return lineData;
    }
}
