package pipeorders;

public class PipeOrders {
    private static double total = 0.0;
    private static GUI mainGUI;
    
    /**
     * Main entry point for the application
     * @param args Arguments passed to the application from the command-line.
     */
    public static void main(String[] args) {
        mainGUI = new GUI();
        mainGUI.setVisible(true);
        while (true) {
            try {
                Order details = UI.awaitOrder();
                double cost = details.calculate();
                total += cost;
                mainGUI.displayCost(total);
            }
            catch (InterruptedException e) {
                mainGUI.displayText("Encountered an unexpected error: " + e.getMessage());
            }
            catch (Exception e) {
                mainGUI.displayText("Unable to validate order: " + e.getMessage());
            }
        }
    }
    
    /**
     * Resets the total order cost back to zero.
     */
    public static void resetTotal() {
        total = 0.0;
        mainGUI.displayCost(total);
    }
}
