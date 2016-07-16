package ManagingLogic;

import java.util.Collection;
import java.util.Objects;

abstract class ManagingMethod implements Iterable {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions, returning true upon success and throwing an IllegalStateException
     * if no space is currently available.
     */
    public abstract boolean add(Object o);

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions. When using a capacity-restricted queue, this method is generally
     * preferable to add, which can fail to insert an element only by throwing an exception.
     */
    public abstract boolean offer(Object o);

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     */
    public abstract Object peek();

    /**
     * Retrieves, but does not remove, the head of this queue. This method differs from peek only in
     * that it throws an exception if this queue is empty.
     */
    public abstract Object element();

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     */
    public abstract Object poll();

    /**
     * Retrieves and removes the head of this queue. This method differs from poll only in that it
     * throws an exception if this queue is empty.
     */
    public abstract Object remove();

    public abstract int size();

    public abstract int capacity();
}

