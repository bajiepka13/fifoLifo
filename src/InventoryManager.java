import ManagingLogic.*;

public class InventoryManager {
    public static void main(String[] args) {

        ManagingClass myQueue = new QueueImplementation();
        ManagingClass myStack = new StackImplementation();

        String[] proverbsForQueue = new String[]{
                "God helps those who help themselves.",
                "You can't always get what you want.",
                "Cleanliness is next to godliness.",
                "A watched pot never boils.",
                "Actions speak louder than words.",
                "If it ain't broke, don't fix it."
        };

        String[] proverbsForStack = proverbsForQueue.clone();

        myQueue.addValues(proverbsForQueue);
        myStack.addValues(proverbsForStack);

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());

        myStack.removeLast();
        myQueue.removeLast();

        System.out.println("\nRemove last of Queue:\n" + myQueue.toString());
        System.out.println("Remove last of Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());

        System.out.println("\nClearing");
        myQueue.clear();
        myStack.clear();

        System.out.println("\nQueue\n" + myQueue.toString());
        System.out.println("\nStack\n" + myStack.toString());
        System.out.println("Queue capacity: " + myQueue.capacity());
        System.out.println("Stack capacity: " + myStack.capacity());
        System.out.println("Queue size: " + myQueue.size());
        System.out.println("Stack size: " + myStack.size() + "\n");

        myQueue.addValues(proverbsForQueue);
        myStack.addValues(proverbsForStack);
        myQueue.addValues(proverbsForStack);
        myStack.addValues(proverbsForQueue);

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("last of Stack: " + myStack.getLast());
        System.out.println("last of Queue: " + myQueue.getLast());
    }
}

