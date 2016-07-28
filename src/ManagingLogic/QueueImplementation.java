package ManagingLogic;

import java.util.NoSuchElementException;

public class QueueImplementation extends ManagingClass {

    @Override
    public Object getFirst() {
        return super.get(0);
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                vault[i] = (size > i + 1) ? vault[i + 1] : null;
            }
            fillIn--;
            size--;
        } else {
            throw new NoSuchElementException("There is no queue to work with");
        }

    }
}


