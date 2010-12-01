/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uli
 */
public class CSVParser extends AbstractParser {

    private String enclosator = "\"";
    private String columnSeparator = ",";

    public CSVParser(InputStream inputSource, String enclosator, String columnSeparator) {
        this.streamSource = inputSource;
        this.enclosator = enclosator;
        this.columnSeparator = columnSeparator;
    }

    public CSVIterator getDataIterator() {
        return new CSVIterator(streamSource, enclosator, columnSeparator);
    }

    public class CSVIterator extends AbstractParserIterator {

        public CSVIterator(InputStream streamSource, String enclosator, String columnSeparator) {
            this.inputSource = new BufferedReader(new InputStreamReader(streamSource));
            this.enclosator = enclosator;
            this.columnSeparator = columnSeparator;
        }

        public boolean hasNext(boolean useBuffer) {
            try {
                if (inputSource.ready() || (rowBuffer.size() > 0 && useBuffer)) {
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        public Vector<String> next(boolean useBuffer) {
            try {
                /**
                 *  First try to get the dataset from the buffer
                 */
                if (rowBuffer.size() > 0 && useBuffer) {
                    return rowBuffer.poll();
                }
                /**
                 * If the next code is executed, the buffer is empty,
                 * so try to get the data
                 */
                String line = inputSource.readLine();

                Vector<String> lineData = new Vector<String>();
                StringBuffer sb = new StringBuffer();
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
                    } else //'Normal' character
                    {
                        sb.append(c);
                    }
                }
                if (sb.length() > 0) //If there is content in the string buffer
                {
                    //Append the string buffer content to the list
                    lineData.add(sb.toString());
                }
                return lineData;
            } catch (NullPointerException ex) {
                /**
                 * Remark: This may be a buggy behaviour but adding a line cache
                 * may also be because this would make the user call
                 */
                return new Vector<String>();
            } catch (IOException ex) {
                //Return a vector containing the error message
                Vector v = new Vector();
                v.add(ex.getMessage());
                return v;
            }
        }
        private BufferedReader inputSource = null;
        private String enclosator = "\"";
        private String columnSeparator = ",";
    }
}
