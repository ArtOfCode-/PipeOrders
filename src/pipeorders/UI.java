package pipeorders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Manages the application's user interface.
 * @author Owen Jenkins
 */
public class UI {
    private static final Queue<Order> ORDER_QUEUE = new LinkedList<Order>();
    private static final Semaphore ORDER_SIGNALER = new Semaphore(0);
    
    /**
     * Blocks the current thread until a customer order is available, and returns it when it is.
     * @return An Order containing the customer's order details.
     * @throws InterruptedException
     */
    public static Order awaitOrder() throws InterruptedException {
        // Blocks until there's an order available in the queue.
        ORDER_SIGNALER.acquire();
        return ORDER_QUEUE.remove();
    }
    
    public static void addOrderToQueue(Order details) {
        ORDER_QUEUE.add(details);
        ORDER_SIGNALER.release();
    }
}
