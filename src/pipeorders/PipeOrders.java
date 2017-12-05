package pipeorders;

public class PipeOrders {
    /**
     * Main entry point for the application
     * @param args Arguments passed to the application from the command-line.
     */
    public static void main(String[] args) {
        while (true) {
            try {
                Order order = UI.awaitOrder();
                System.out.println("Total: £" + String.format("%.2f", order.calculate()));
                System.out.println("");
            }
            catch (InterruptedException ex) {
                System.out.println("Operation encountered an error: " + ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println("No available pipe: " + ex.getMessage());
            }
        }
    }
}
