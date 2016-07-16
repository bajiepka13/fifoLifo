import ManagingLogic.QueueImplementation;

import java.util.Iterator;
import java.util.Queue;

public class InventoryManager {
    public static void main(String[] args) {

        Queue javaDoc = null;

        QueueImplementation myQueue = new QueueImplementation();
        boolean state = false;

        System.out.println("------------------ADD---------------------------");
        System.out.println("[added] " + myQueue.add("Birds of a feather flock together"));
        System.out.println("[added] " + myQueue.add("Keep your friends close and your enemies closer"));
        System.out.println("[added] " + myQueue.add("A picture is worth a thousand words"));
        System.out.println("[added] " + myQueue.add("There's no such thing as a free lunch"));
        System.out.println("[added] " + myQueue.add("There's no place like home"));
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");

        System.out.println("------------------ITERATING---------------------");
        Iterator iterator = myQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------------------------\n");

        System.out.println("------------------PEEK--------------------------");
        System.out.println(myQueue.peek());
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");

        System.out.println("------------------POLL--------------------------");
        System.out.println(myQueue.poll());
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");

        System.out.println("------------------ELEMENT-----------------------");
        System.out.println(myQueue.element());
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");

        System.out.println("------------------OFFER-------------------------");
        System.out.println("[added] " + myQueue.offer("Never look a gift horse in the mouth"));
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");

        System.out.println("------------------OFFER-------------------------");
        System.out.println("[added] " + myQueue.offer("You can't make an omelet without breaking a few eggs"));
        System.out.println("------------------SIZE: " + myQueue.size() + "(" + myQueue.capacity() + ")--------------------\n");
    }
}

