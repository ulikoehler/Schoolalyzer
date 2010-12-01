/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 *
 * @author uli
 */
public abstract class AbstractParser implements IParser {

    /**
     * {@inheritDoc}
     */
    public int getColumnCount() throws IOException {
        /**
         * First check if the cached column count
         * is greater than -1 (default value);
         * if it is, some datasets have already been read
         */
        if (cachedColumnCount > -1) {
            return cachedColumnCount;
        }
        //Return the max. number of elements in the first five datasets
        Vector<Vector<String>> datasets = readFirstDatasets(5);
        int maxSize = 0;
        for (Vector v : datasets) {
            if (v.size() > maxSize) {
                maxSize = v.size();
            }
        }
        return maxSize;
    }

    /**
     * {@inheritDoc}
     */
    public Vector readFirstDatasets(int n) throws IOException {
        AbstractParserIterator it = getDataIterator();
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (int i = 0; i < n && it.hasNext(); i++) {
            /**
             * If we'd use the buffer here, the method would return
             * the same dataset n times because it is read from the buffer
             * and then instantly appended to the buffer again
             */
            Vector<String> next = it.next(false);
            data.add(next);
            //Append the row to the buffer
            rowBuffer.add(next);
            /**
             * If the column count of the last data set is
             * greater than the cahced column count,
             * set the cached one to the size of the last dataset
             */
            if (next.size() > cachedColumnCount) {
                cachedColumnCount = next.size();
            }
        }
        return data;
    }

    @Override
    protected void finalize() throws Throwable {
        streamSource.close();
        super.finalize();
    }
    protected InputStream streamSource;
    private int cachedColumnCount = -1;
    //This list saves the data read in by readFirstDatasets(n)
    protected Queue<Vector<String>> rowBuffer = new LinkedList<Vector<String>>();

    public abstract class AbstractParserIterator implements Iterator<Vector<String>> {

        public abstract boolean hasNext(boolean useBuffer);

        public boolean hasNext() {
            return hasNext(true);
        }

        /**
         * Reads the next dataset with optionally using the buffer
         * @param useBuffer A boolean indicating if to use the buffer
         * @return A vector containing the next dataset
         */
        public abstract Vector<String> next(boolean useBuffer);

        /**
         * {@inheritDoc}
         */
        public Vector<String> next() {
            return next(true);
        }

        /**
         * Editing and so also removing elements is not supported
         */
        public void remove() {
            throw new UnsupportedOperationException("Data is read-only.");
        }
    }
}
