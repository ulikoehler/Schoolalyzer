package schoolalyzer.util;

import java.util.Iterator;

/**
 * Provides an Iterable wrapper for Iterators.
 * This makes it easy to use an Iterator in for loop.
 * For example instead of
 * while(it.hasNext())
 * { Object o = it.next(); ... }
 * you could write
 * for(Object o : new IteratorIterable<Object>(it))
 * { ... }
 */
public class IteratorIterable<T> implements Iterable<T> {

    private Iterator<T> it = null;

    public IteratorIterable(Iterator<T> it) {
        this.it = it;
    }

    @Override
    public Iterator<T> iterator() {
        return it;
    }
}
