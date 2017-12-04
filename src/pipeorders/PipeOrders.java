package pipeorders;

public class PipeOrders {
    public static void main(String[] args) {
        UI userInterface = new UI();
        while (true) {
            try {
                Order order = UI.awaitOrder();
                userInterface.displayCost(order.calculate());
            }
            catch (InterruptedException ex) {
               userInterface.displayError("Operation encountered an error: " + ex.getMessage());
            }
            catch (Exception ex) {
                userInterface.displayError("No available pipe: " + ex.getMessage());
            }
        }
    }
}
