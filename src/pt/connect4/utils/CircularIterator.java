package pt.connect4.utils;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @param <T>
 * usage CircularIterator<Class> ci = new CircularIterator<>(variable);
 *       ci.next();
 */
public class CircularIterator<T> implements Iterator<T> {

    private List<T> _internalList;
    private int _currentIndex;

    public CircularIterator (List<T> list){
        _internalList = list;
        _currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T next() {
        _currentIndex = (_currentIndex+1)%_internalList.size();
        return _internalList.get(_currentIndex);
    }

    @Override
    public void remove() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        throw new RuntimeException("Not implemented");
    }
}
