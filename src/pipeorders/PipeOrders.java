package pipeorders;

public class PipeOrders {
    public static void main(String[] args) {
        while (true) {
            try {
                Order order = UI.awaitOrder();
                System.out.println(order);
                System.out.println("Total: " + order.calculate());
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
