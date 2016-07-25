package ManagingLogic;

public class StackImplementation extends ManagingClass {

    public StackImplementation() {

    }
    @Override
    public Object getFirst() {
        return vault[fillIn - 1];
    }

    @Override
    public void removeFirst() {
        vault[--fillIn] = null;
        size--;
    }
}

