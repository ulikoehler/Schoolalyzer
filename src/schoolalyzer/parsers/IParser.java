/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.parsers;

import java.io.IOException;
import java.util.Vector;
import schoolalyzer.parsers.AbstractParser.AbstractParserIterator;

/**
 *
 * @author uli
 */
public interface IParser {

    /**
     * Gets the number of columns of the first dataset from the input source
     * @return
     * @throws IOException
     */
    public int getColumnCount() throws IOException;

    /**
     * Returns a dataset iterator
     * Of all methods this is most effective
     * because the data doesn't have to be saved in memory.
     * Note that this may cause little overhead because the
     * data is not read before the call
     * @return A dataset iterator
     */
    public AbstractParserIterator getDataIterator() throws IOException;

    /**
     * Parses the first n datasets from the input source
     * This method
     * @param n The number of datasets to be read
     * @return A vector of the row vectors
     * @throws IOException If an IO error occurs
     */
    public Vector readFirstDatasets(int n) throws IOException;
}
