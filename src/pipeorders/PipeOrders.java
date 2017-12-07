package pipeorders;

public class PipeOrders {
    /**
     * Main entry point for the application
     * @param args Arguments passed to the application from the command-line.
     */
    public static void main(String[] args) {
        GUI mainGUI = new GUI();
        mainGUI.setVisible(true);
        while (true) {
            try {
                Order details = UI.awaitOrder();
                mainGUI.displayCost(details.calculate());
            }
            catch (InterruptedException e) {
                mainGUI.displayText("Encountered an unexpected error: " + e.getMessage());
            }
            catch (Exception e) {
                mainGUI.displayText("Unable to validate order: " + e.getMessage());
            }
        }
    }
}
