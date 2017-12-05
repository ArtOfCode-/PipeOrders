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
        // While this is a console application, we need to get the input here too. When we convert to a GUI,
        // the order submission button should create the order, add it to the queue, and signal it's ready.
        System.out.println("Please enter the following details to complete your order:");
        Scanner input = new Scanner(System.in);
        float length = (float) getInput("What length of pipe do you need, in metres? ", input, Float.class);
        float diameter = (float) getInput("What outer diameter do you need, in inches? ", input, Float.class);
        int grade = (int) getInputWithinRange("What grade of plastic do you need (1 through 5)? ", input, Integer.class,
                                              1, 5);
        int colors = (int) getInputWithinRange("Do you need 0, 1, or 2-coloured plastic? ", input, Integer.class, 0, 2);
        boolean reinforced = (boolean) getInput("Do you need extra reinforcement (y/N)? ", input, Boolean.class);
        boolean insulated = (boolean) getInput("Do you need insulation (y/N)? ", input, Boolean.class);
        boolean chemResist = (boolean) getInput("Do you need chemical resistance (y/N)? ", input, Boolean.class);
        int quantity = (int) getInput("How many of these pipes do you need? ", input, Integer.class);
        Order customerOrder = new Order(grade, length, diameter, colors, insulated, reinforced, chemResist, quantity);
        
        ORDER_QUEUE.add(customerOrder);
        ORDER_SIGNALER.release();

        // Blocks until there's an order available in the queue.
        ORDER_SIGNALER.acquire();
        
        return ORDER_QUEUE.remove();
    }
    
    /**
     * Asks the user for input, and repeats the question until non-empty input is provided.
     * @param message A message to display to the user about this input.
     * @param sc A Scanner instance to use to read the input.
     * @return A String containing the user input.
     */
    private static String getInput(String message, Scanner sc) {
        String result = "";
        while (result.equals("")) {
            System.out.println(message);
            result = sc.nextLine();
        }
        return result;
    }
    
    /**
     * Asks the user for input, and repeats the question until non-empty, valid input is provided.
     * @param message A message to display to the user about this input.
     * @param sc A Scanner instance to use to read the input.
     * @param type The type to attempt to coerce the input to.
     * @return An Object containing the user input; requires casting to the desired type.
     * @throws IllegalArgumentException if type is not a supported class.
     */
    private static Object getInput(String message, Scanner sc, Class type) throws IllegalArgumentException {
        while (true) {
            System.out.println(message);
            String in = sc.nextLine();
            if (type.equals(Integer.class)) {
                try {
                    return Integer.parseInt(in, 10);
                }
                catch (NumberFormatException ex) {
                    System.out.println("Invalid input.");
                }
            }
            else if (type.equals(Float.class)) {
                try {
                    return Float.parseFloat(in);
                }
                catch (NumberFormatException ex) {
                    System.out.println("Invalid input.");
                }
            }
            else if (type.equals(Boolean.class)) {
                switch (in.toLowerCase()) {
                    case "y":
                        return true;
                    case "n":
                        return false;
                    default:
                        System.out.println("You responded '" + in + "' - invalid, defaulting to No");
                        return false;
                }
            }
            else {
                throw new IllegalArgumentException("Can't convert to type " + type.toString());
            }
        }
    }
    
    /**
     * Asks the user for input, and repeats the question until non-empty, valid, within range input is
     * provided.
     * @param message A message to display to the user about this input.
     * @param sc A Scanner instance to use to read the input.
     * @param type The type to attempt to coerce the input into.
     * @param min The lower end of the valid range, inclusive.
     * @param max The higher end of the valid range, inclusive.
     * @return An Object containing the user input; requires casting to the desired class.
     * @throws IllegalArgumentException if type is not a supported class.
     */
    private static Object getInputWithinRange(String message, Scanner sc, Class type, float min, float max)
        throws IllegalArgumentException {
        while (true) {
            Object input = getInput(message, sc, type);
            float in;
            if (type.equals(Integer.class)) {
                in = 1.0f * (int) input;
            }
            else {
                in = (float) input;
            }
            
            if (in >= min && in <= max) {
                return input;
            }
            else {
                System.out.println("Invalid input: must be >=" + min + " and <=" + max);
            }
        }
    }
}
