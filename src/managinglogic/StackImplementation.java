package managinglogic;

import java.util.NoSuchElementException;

public class StackImplementation extends ManagingClass {

    @Override
    public Object getFirst() {
        return vault[fillIn - 1];
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            vault[--fillIn] = null;
            size--;
        } else {
            throw new NoSuchElementException("There is no stack to work with");
        }

    }
}
