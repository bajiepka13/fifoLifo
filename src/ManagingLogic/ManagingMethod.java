package ManagingLogic;

abstract class ManagingMethod implements Iterable {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions, returning true upon success and throwing an IllegalStateException
     * if no space is currently available.
     */
    public abstract void add(Object o);

    /**
     * Inserts the incoming array into collection, beginning from the first existing element
     * @param c - array[]
     */
    public abstract void addValues(Object[] c);

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions. When using a capacity-restricted queue, this method is generally
     * preferable to add, which can fail to insert an element only by throwing an exception.
     */
    public abstract Object get(int i);

    /**
     * Returns returns the last value of collection that depends on subclass type (last entered for LIFO
     * or first entered for FIFO subclass)
     * @return Object
     */
    public abstract Object getLast();

    /**
     * Retrieves and removes the head of this queue. This method differs from poll only in that it
     * throws an exception if this queue is empty.
     */
    public abstract Object remove();

    /**
     * Retrieves and removes the head of this queue. This method differs from poll only in that it
     * throws an exception if this queue is empty.
     */
    public abstract void removeLast();

    /**
     * returns the number of elements, added to collection (quantity of elements included)
     * @return quantity of elements in collection
     */
    public abstract int size();

    /**
     * returns the size of collection
     * @return size of collection
     */
    public abstract int capacity();

    /**
     * delete all values of collection, but doesn't resize it.
     */
    public abstract void clear();
}

