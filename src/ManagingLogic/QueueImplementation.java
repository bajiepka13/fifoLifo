package ManagingLogic;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class QueueImplementation extends ManagingMethod {
    private static final int DEFAULT_QUEUE_SIZE = 5;
    private Object[] vault;
    private int size;
    private int fillIn;
    private long version;

    public QueueImplementation() {
        this(DEFAULT_QUEUE_SIZE);
    }

    public QueueImplementation(int queueSize) {

        this.size = queueSize;
        vault = new Object[queueSize];
    }

    @Override
    public boolean add(Object o) {

        if (fillIn <= this.size - 1) {
            vault[fillIn++] = o;
            version++;
        } else {
            throw new IllegalStateException("IllegalStateException");
        }
        return true;
    }

    @Override
    public Object remove() {
        Object r = null;
        if (!isEmpty()) {
            r = vault[fillIn--];
            vault[fillIn + 1] = null;
        } else {
            throw new NoSuchElementException("NoSuchElementException");
        }
        return r;
    }

    @Override
    public Object element() {

        if (!isEmpty()) {
            return vault[fillIn - 1];
        } else {
            throw new NoSuchElementException("NoSuchElementException");
        }
    }

    @Override
    public boolean offer(Object o) {

        if (fillIn < this.size) {
            vault[fillIn++] = o;
            version++;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Object peek() {
        Object r = null;
        if (fillIn - 1 <= this.size) {
            r = vault[fillIn - 1];
        }
        return r;
    }

    @Override
    public Object poll() {
        Object r = null;
        if (!isEmpty()) {
            r = vault[--fillIn];
            vault[fillIn] = null;
        }
        return r;
    }

    @Override
    public int size() {
        return fillIn;
    }

    @Override
    public int capacity() {
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            int iPosition;
            long version = QueueImplementation.this.version;

            @Override
            public boolean hasNext() {
                return iPosition < fillIn;
            }

            @Override
            public Object next() {
                return vault[iPosition++];
            }
        };
    }

    private boolean isEmpty() {
        return this.fillIn > 0 && this.fillIn - 1 < this.size ? false : true;

    }
}
