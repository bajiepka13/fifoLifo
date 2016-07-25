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

        System.out.println("first of Queue: " + myQueue.getFirst());
        System.out.println("first of Stack: " + myStack.getFirst());

        myQueue.removeFirst();
        myStack.removeFirst();

        System.out.println("\nRemove first of Queue:\n" + myQueue.toString());
        System.out.println("Remove first of Stack\n" + myStack.toString());

        System.out.println("first of Queue: " + myQueue.getFirst());
        System.out.println("first of Stack: " + myStack.getFirst());

        System.out.println("\nClearing");
        myQueue.clear();
        myStack.clear();

        System.out.println("\nQueue\n" + myQueue.toString());
        System.out.println("\nStack\n" + myStack.toString() + "\n");
        System.out.println("Queue capacity: " + myQueue.capacity());
        System.out.println("Stack capacity: " + myStack.capacity());
        System.out.println("Queue size: " + myQueue.size());
        System.out.println("Stack size: " + myStack.size() + "\n");

        myStack.addValues(proverbsForQueue);
        myQueue.addValues(proverbsForQueue);
        myStack.addValues(proverbsForStack);
        myQueue.addValues(proverbsForStack);

        System.out.println("Queue\n" + myQueue.toString());
        System.out.println("Stack\n" + myStack.toString());

        System.out.println("first of Queue: " + myQueue.getFirst());
        System.out.println("first of Stack: " + myStack.getFirst());
    }
}

