package ManagingLogic;

public class StackImplementation extends ManagingClass {

    public StackImplementation() {

    }
    @Override
    public Object getLast() {
        return vault[fillIn - 1];
    }

    @Override
    public void removeLast() {
        vault[--fillIn] = null;
        size--;
    }
}

