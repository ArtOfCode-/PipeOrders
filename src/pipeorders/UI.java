package pipeorders;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Manages the application's user interface.
 * @author Owen Jenkins
 */
public class UI extends JFrame implements ActionListener {
    /**
     * Contains a queue of all unprocessed orders.
     */
    private static final Queue<Order> ORDER_QUEUE = new LinkedList<>();

    /**
     * Used to signal when an order is available in the queue.
     */
    private static final Semaphore ORDER_SIGNALER = new Semaphore(0);
    private HashMap<String, Component> inputs;
    
    /**
     * Blocks the current thread until a customer order is available, and returns it when it is.
     * @return An Order containing the customer's order details.
     * @throws InterruptedException re-thrown from internal calls
     */
    static Order awaitOrder() throws InterruptedException {
        // While this is a console application, we need to get the input here too. When we convert to a GUI,
        // the order submission button should create the order, add it to the queue, and signal it's ready.
        /*System.out.println("Please enter the following details to complete your order:");
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
        ORDER_SIGNALER.release();*/

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

    UI() {
        inputs = new HashMap<>();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        setupFormInterface(contentPanel);
        getContentPane().add(contentPanel);

        setTitle("LongPipes Ordering System");
        setSize(500, 550);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setupFormInterface(JPanel contentPanel) {
        JLabel lengthLabel = new JLabel();
        lengthLabel.setText("Length (metres)");
        addToContainer(contentPanel, lengthLabel);

        JTextField lengthInput = new JTextField();
        addToContainer(contentPanel, lengthInput, 10);
        inputs.put("length", lengthInput);

        JLabel diamLabel = new JLabel();
        diamLabel.setText("Outer diameter (inches)");
        addToContainer(contentPanel, diamLabel);

        JTextField diamInput = new JTextField();
        addToContainer(contentPanel, diamInput, 10);
        inputs.put("diameter", diamInput);

        String[] grades = { "1", "2", "3", "4", "5" };

        JLabel gradeLabel = new JLabel();
        gradeLabel.setText("Plastic grade");
        addToContainer(contentPanel, gradeLabel);

        JComboBox gradeInput = new JComboBox(grades);
        addToContainer(contentPanel, gradeInput, 10);
        inputs.put("grade", gradeInput);

        String[] colors = { "0", "1", "2" };

        JLabel colorLabel = new JLabel();
        colorLabel.setText("Number of colours");
        addToContainer(contentPanel, colorLabel);

        JComboBox colorInput = new JComboBox(colors);
        addToContainer(contentPanel, colorInput, 10);
        inputs.put("colors", colorInput);

        String[] answers = { "No", "Yes" };

        JLabel insulationLabel = new JLabel();
        insulationLabel.setText("Insulation?");
        addToContainer(contentPanel, insulationLabel);

        JComboBox insulationInput = new JComboBox(answers);
        addToContainer(contentPanel, insulationInput, 10);
        inputs.put("insulation", insulationInput);

        JLabel reinforceLabel = new JLabel();
        reinforceLabel.setText("Reinforcement?");
        addToContainer(contentPanel, reinforceLabel);

        JComboBox reinforceInput = new JComboBox(answers);
        addToContainer(contentPanel, reinforceInput, 10);
        inputs.put("reinforcement", reinforceInput);

        JLabel chemLabel = new JLabel();
        chemLabel.setText("Chemical resistance?");
        addToContainer(contentPanel, chemLabel);

        JComboBox chemInput = new JComboBox(answers);
        addToContainer(contentPanel, chemInput, 10);
        inputs.put("chemical", chemInput);

        JLabel qtyLabel = new JLabel();
        qtyLabel.setText("Quantity");
        addToContainer(contentPanel, qtyLabel);

        JTextField qtyInput = new JTextField();
        addToContainer(contentPanel, qtyInput, 20);
        inputs.put("quantity", qtyInput);

        JButton submit = new JButton();
        submit.setText("Calculate Price");
        submit.addActionListener(this);
        addToContainer(contentPanel, submit);

        JLabel messages = new JLabel();
        addToContainer(contentPanel, messages);
        inputs.put("messages", messages);
    }

    /**
     * Adds a child element to a parent container with a fixed 5-pixel margin underneath.
     * @param parent The parent container
     * @param child A child element to add to the container
     */
    private static void addToContainer(Container parent, Component child) {
        parent.add(child);
        parent.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    /**
     * Adds a child element to a parent container with a specified margin underneath.
     * @param parent The parent container
     * @param child A child element to add to the container
     * @param margin The pixel height of the margin to add under the child element
     */
    private static void addToContainer(Container parent, Component child, int margin) {
        parent.add(child);
        parent.add(Box.createRigidArea(new Dimension(0, margin)));
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String selectedGrade = (String) ((JComboBox) inputs.get("grade")).getSelectedItem();
            int grade = Integer.parseInt(selectedGrade, 10);

            String enteredLength = (String) ((JTextField) inputs.get("length")).getText();
            float length = Float.parseFloat(enteredLength);

            String enteredDiam = (String) ((JTextField) inputs.get("diameter")).getText();
            float diameter = Float.parseFloat(enteredDiam);

            String selectedColors = (String) ((JComboBox) inputs.get("colors")).getSelectedItem();
            int colors = Integer.parseInt(selectedColors, 10);

            String inputInsulation = (String) ((JComboBox) inputs.get("insulation")).getSelectedItem();
            boolean insulation = inputInsulation.equals("Yes");

            String inputReinforce = (String) ((JComboBox) inputs.get("reinforcement")).getSelectedItem();
            boolean reinforcement = inputReinforce.equals("Yes");

            String inputChem = (String) ((JComboBox) inputs.get("chemical")).getSelectedItem();
            boolean chemical = inputChem.equals("Yes");

            String inputQty = (String) ((JTextField) inputs.get("quantity")).getText();
            int quantity = Integer.parseInt(inputQty, 10);

            Order details = new Order(grade, length, diameter, colors, insulation, reinforcement,
                                      chemical, quantity);
            ORDER_QUEUE.add(details);
            ORDER_SIGNALER.release();
        }
        catch (NumberFormatException ex) {
            ((JLabel) inputs.get("messages")).setText("Please enter valid input: " + ex.getMessage());
        }
        catch (NullPointerException ex) {
            ((JLabel) inputs.get("messages")).setText("Couldn't get input: " + ex.getMessage());
        }
    }

    void displayCost(double cost) {
        ((JLabel) inputs.get("messages")).setText("Total cost: £" + String.format("%.2f", cost));
    }

    void displayError(String message) {
        ((JLabel) inputs.get("messages")).setText(message);
    }
}
