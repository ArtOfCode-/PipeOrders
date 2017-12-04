package pipeorders;

public class PipeOrders {
    public static void main(String[] args) {
        while (true) {
            try {
                Order order = UI.awaitOrder();
                System.out.println("Total: £" + String.format("%.2f", order.calculate()));
                System.out.println("");
            }
            catch (InterruptedException ex) {
                // TODO
            }
            catch (Exception ex) {
                System.out.println("No available pipe: " + ex.getMessage());
            }
        }
    }
}
