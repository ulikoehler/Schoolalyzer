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

    private char[] enclosers = "\"".toCharArray();
    private char[] columnSeparators = ",".toCharArray();
    private BufferedReader streamSource = null;

    public CSVParser(InputStream inputSource, String enclosers, String columnSeparator) {
        this.streamSource = new BufferedReader(new InputStreamReader(inputSource));
        this.enclosers = enclosers.toCharArray();
        this.columnSeparators = columnSeparator.toCharArray();
    }

    /**
     * Checks if a given character array contains a specific character.
     * Unlike Arrays.binarySearch the array doesn't need to be sorted
     * @param array The array to check
     * @param c The character to check
     * @return True if and only if the char is contained in the array; false otherwise
     */
    public static boolean containsChar(char[] array, char c) {
        for (char a : array) {
            if (a == c) {
                return true;
            }
        }
        return false;
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

        System.out.println(new String(enclosers));

        char[] lineAsCharArray = line.toCharArray();

        ArrayList<String> lineData = new ArrayList<String>(32); //It's unlikely there are more than 32 fields
        StringBuilder sb = new StringBuilder(256); //Field lengths > 256 are unlikely
        boolean inEnclosedRegion = false;
        char currentEnclosingCharacter = 0;

        for (int j = 0; j < line.length(); j++) {
            char currentChar = lineAsCharArray[j];
            if (containsChar(enclosers, currentChar)) {
                if (inEnclosedRegion) {
                    if (currentChar == currentEnclosingCharacter) {
                        inEnclosedRegion = false;
                    }
                    else { //The current char is treated as a 'normal' character
                        sb.append(currentChar);
                    }
                } else { //!inEnclosedRegion
                    inEnclosedRegion = true;
                    currentEnclosingCharacter = currentChar;
                }
            } else if (containsChar(columnSeparators, currentChar) && !inEnclosedRegion) {
                //Append the string buffer content to the list and clear the buffer
                lineData.add(sb.toString());
                sb.setLength(0);
            } else { //'Normal' character
                sb.append(currentChar);
            }
        }
        if (sb.length() > 0) { //If there is content left in the string buffer
            //Append the string buffer content to the list
            lineData.add(sb.toString());
        }
        return lineData;
    }
}
