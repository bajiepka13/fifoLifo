import ManagingLogic.*;

public class InventoryManager {
    public static void main(String[] args) {

        ManagingMethod myQueue = new QueueImplementation();
        ManagingMethod myStack = new StackImplementation();

        String[] proverbs = new String[]{"God helps those who help themselves.",
                "You can't always get what you want.",
                "Cleanliness is next to godliness.",
                "A watched pot never boils."};

        String[] proverbs2 = new String[]{
                "Beggars can't be choosers.",
                "Actions speak louder than words.",
                "If it ain't broke, don't fix it.",
                "Practice makes perfect.",
                "Too many cooks spoil the broth."
        };

        myQueue.addValues(proverbs);
        myStack.addValues(proverbs2);

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());

        myStack.removeLast();
        myQueue.removeLast();

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());

        System.out.println("\nClear");
        myQueue.clear();
        myStack.clear();

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());
        System.out.println("Queue capacity: " + myQueue.capacity());
        System.out.println("Stack capacity: " + myStack.capacity());
        System.out.println("Queue size: " + myQueue.size());
        System.out.println("Stack size: " + myStack.size() + "\n");

        myQueue.addValues(proverbs);
        myStack.addValues(proverbs2);
        myQueue.addValues(proverbs2);
        myStack.addValues(proverbs);

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());
    }
}

