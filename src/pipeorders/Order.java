package pipeorders;

import pipeorders.pipes.AbstractPipe;

public class Order {
    /**
     * The minimum number of pipes that can be fulfilled in one order.
     */
    private static final int MIN_QUANTITY = 1;

    /**
     * The maximum number of pipes that can be fulfilled in one order.
     */
    private static final int MAX_QUANTITY = 1000;
    
    private final int grade;
    private final float length;
    private final float outerDiameter;
    private final int colors;
    private final boolean insulation;
    private final boolean reinforcement;
    private final boolean chemicalResistance;
    private final int quantity;

    /**
     * Construct an Order object.
     * @param grade The requested grade of plastic
     * @param length The requested pipe length, in meters
     * @param outerDiameter The requested outer diameter, in inches
     * @param colors The number of colors requested
     * @param insulation Whether insulation should be included or not
     * @param reinforcement Whether reinforcement should be included or not
     * @param chemicalResistance Whether chemical resistance should be included or not
     * @param quantity The number of pipes requested
     */
    Order(int grade, float length, float outerDiameter, int colors, boolean insulation, boolean reinforcement,
            boolean chemicalResistance, int quantity) {
        this.grade = grade;
        this.length = length;
        this.outerDiameter = outerDiameter;
        this.colors = colors;
        this.insulation = insulation;
        this.reinforcement = reinforcement;
        this.chemicalResistance = chemicalResistance;
        this.quantity = quantity;
    }

    /**
     * Get the grade requested for this order
     * @return An integer containing the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Get the pipe length requested for this order
     * @return A float containing the pipe length
     */
    public float getLength() {
        return length;
    }

    /**
     * Get the outer diameter requested for this order
     * @return A float containing the outer diameter
     */
    public float getOuterDiameter() {
        return outerDiameter;
    }

    /**
     * Get the number of colors requested for this order
     * @return An integer containing the colors requested
     */
    public int getColors() {
        return colors;
    }

    /**
     * Query whether insulation was requested for this order
     * @return A boolean indicating whether insulation is required
     */
    public boolean requiresInsulation() {
        return insulation;
    }

    /**
     * Query whether reinforcement was requested for this order
     * @return A boolean indicating whether reinforcement is required
     */
    public boolean requiresReinforcement() {
        return reinforcement;
    }

    /**
     * Query whether chemical resistance was requested for this order
     * @return A boolean indicating whether chemical resistance is required
     */
    private boolean requiresChemicalResistance() {
        return chemicalResistance;
    }

    /**
     * Get the number of pipes requested for this order
     * @return An integer containing the quantity of pipes
     */
    private int getQuantity() {
        return quantity;
    }

    /**
     * Get a string representation of this object for debugging purposes
     * @return A string containing the details of this object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order<");
        sb.append("grade=").append(grade).append(" ");
        sb.append("length=").append(length).append(" ");
        sb.append("outerDiameter=").append(outerDiameter).append(" ");
        sb.append("colors=").append(colors).append(" ");
        sb.append("insulation=").append(insulation).append(" ");
        sb.append("reinforcement=").append(reinforcement).append(" ");
        sb.append("chemicalResistance=").append(chemicalResistance).append(" ");
        sb.append("quantity=").append(quantity).append(">");
        return sb.toString();
    }

    /**
     * Get the total cost of this order based on the details provided.
     * @return A double containing the total price of the order
     * @throws Exception if the order is invalid or can't be fulfilled
     */
    double calculate() throws Exception {
        if (quantity >= MIN_QUANTITY && quantity <= MAX_QUANTITY) {
            AbstractPipe pipe = AbstractPipe.findSupportingPipe(this);
            double pricePerUnit = pipe.getPricePerCubicInch(getGrade());
            double inchLength = getLength() * 39.37;
            double outerRadius = getOuterDiameter() / 2.0f;
            double innerRadius = outerRadius * 0.9;
            double outerSA = Math.PI * Math.pow(outerRadius, 2);
            double innerSA = Math.PI * Math.pow(innerRadius, 2);
            double outerVol = outerSA * inchLength;
            double innerVol = innerSA * inchLength;
            double finalVol = outerVol - innerVol;

            double finalCost = finalVol * pricePerUnit;

            if (getColors() == 1) {
                finalCost *= 1.12;
            }
            if (getColors() == 2) {
                finalCost *= 1.16;
            }
            if (requiresInsulation()) {
                finalCost *= 1.13;
            }
            if (requiresReinforcement()) {
                finalCost *= 1.17;
            }
            if (requiresChemicalResistance()) {
                finalCost *= 1.14;
            }

            return finalCost * getQuantity();
        }
        else {
            throw new Exception("Quantity not in valid range (1-1000).");
        }
    }
}