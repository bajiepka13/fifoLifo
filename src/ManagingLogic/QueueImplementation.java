package ManagingLogic;

public class QueueImplementation extends ManagingClass {

    public QueueImplementation() {
        super();
    }

    @Override
    public Object getLast() {
        return super.get(0);
    }

    @Override
    public void removeLast() {

        for (int i = 0; i < size; i++) {
            vault[i] = (size > i + 1) ? vault[i + 1] : null;
        }
        fillIn--;
        size--;
    }
}
