package ManagingLogic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by skydock on 17.07.2016.
 * modified
 */
public class FifoLifoImplementation extends ManagingMethod {

    protected static final int DEFAULT_QUEUE_SIZE = 5;
    protected Object[] vault;
    protected int size;
    protected int fillIn;
    protected long version;

    public FifoLifoImplementation() {
        this(DEFAULT_QUEUE_SIZE);
    }

    public FifoLifoImplementation(int queueSize) {

        this.size = queueSize;
        vault = new Object[queueSize];
    }

    @Override
    public Object get(int i) throws IndexOutOfBoundsException{

        Object o = null;
        try {
            o =  vault[i];
        } catch (IndexOutOfBoundsException e){
            System.out.println("Out of bounds");
        }
        return o;
    }

    @Override
    public void addValues(Object[] c) {
        if (c.length > (size - fillIn)){
            size = size + c.length;
            vault = Arrays.copyOf(vault, size);
        }
        for (int i = 0; i < c.length; i++){
            vault[fillIn++] = c[i];
        }
    }

    @Override
    public Object getLast() {
        return vault[fillIn - 1];
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

    @Override
    public void clear() {

        for (int i = 0; i < size; i++){
            if (vault[i] != null) {
                vault[i] = null;
            }
        }
        fillIn = 0;
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
    public void removeLast() {
        vault[--fillIn] = null;
        size--;
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
            long version = FifoLifoImplementation.this.version;

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
