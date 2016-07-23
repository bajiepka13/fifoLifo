package ManagingLogic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ManagingClass implements Iterable {
    private static final int DEFAULT_QUEUE_SIZE = 5;
    Object[] vault;
    int size;
    int fillIn;
    private long version;

    public ManagingClass() {
        this(DEFAULT_QUEUE_SIZE);
    }

    private ManagingClass(int queueSize) {

        this.size = queueSize;
        vault = new Object[queueSize];
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions, returning true upon success and throwing an IllegalStateException
     * if no space is currently available.
     */
    public void add(Object o) {
        if (fillIn <= this.size - 1) {
            vault[fillIn++] = o;
            version++;
        } else {
            throw new IllegalStateException("IllegalStateException");
        }
    }

    /**
     * Inserts the incoming array into collection, beginning from the first existing element
     *
     * @param c - array[]
     */
    public void addValues(Object[] c) {
        if (c.length > (size - fillIn)) {
            size = size + c.length;
            vault = Arrays.copyOf(vault, size);
        }
        for (Object element : c) {
            vault[fillIn++] = element;
        }
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions. When using a capacity-restricted queue, this method is generally
     * preferable to add, which can fail to insert an element only by throwing an exception.
     */
    public Object get(int i) {
        Object o = null;
        try {
            o = vault[i];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        return o;
    }


    /**
     * Retrieves and removes the head of this queue. This method differs from poll only in that it
     * throws an exception if this queue is empty.
     */
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

    /**
     * returns the number of elements, added to collection (quantity of elements included)
     *
     * @return quantity of elements in collection
     */
    public int size() {
        return fillIn;
    }

    /**
     * returns the size of collection
     *
     * @return size of collection
     */
    public int capacity() {
        return this.size;
    }

    /**
     * delete all values of collection, but doesn't resize it.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null) {
                vault[i] = null;
            }
        }
        fillIn = 0;
    }

    /**
     * Returns returns the last value of collection that depends on subclass type (last entered for LIFO
     * or first entered for FIFO subclass)
     *
     * @return Object
     */
    public abstract Object getLast();


    /**
     * Retrieves and removes the head of this queue. This method differs from poll only in that it
     * throws an exception if this queue is empty.
     */
    public abstract void removeLast();


    @Override
    public Iterator iterator() {
        return new Iterator() {

            int iPosition;
            long version = ManagingClass.this.version;

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
        return !(this.fillIn > 0 && this.fillIn - 1 < this.size);

    }

    @Override
    public String toString() {
        String s = "";
        if (fillIn != 0) {
            for (int i = 0; i < vault.length; i++) {
                if (vault[i] != null) {
                    s = s + "[" + i + "]" + vault[i] + "\n";
                }
            }
        } else {

            s = "Collection is empty";
        }
        return s;
    }


}
