package pipeorders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Manages the application's user interface.
 */
public class UI {
    /**
     * Contains a queue of all unprocessed orders.
     */
    private static final Queue<Order> ORDER_QUEUE = new LinkedList<>();

    /**
     * Used to signal when an order is available in the queue.
     */
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

    /**
     * Adds an order into the order queue.
     * @param details An Order instance to queue up.
     */
    public static void addOrderToQueue(Order details) {
        ORDER_QUEUE.add(details);
        ORDER_SIGNALER.release();
    }
}
