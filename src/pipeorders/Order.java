package pipeorders;

import pipeorders.pipes.AbstractPipe;

public class Order {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;
    
    private final int grade;
    private final float length;
    private final float outerDiameter;
    private final int colors;
    private final boolean insulation;
    private final boolean reinforcement;
    private final boolean chemicalResistance;
    private final int quantity;
    
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
    
    public int getGrade() {
        return grade;
    }
    
    public float getLength() {
        return length;
    }
    
    public float getOuterDiameter() {
        return outerDiameter;
    }
    
    public int getColors() {
        return colors;
    }
    
    public boolean requiresInsulation() {
        return insulation;
    }
    
    public boolean requiresReinforcement() {
        return reinforcement;
    }
    
    private boolean requiresChemicalResistance() {
        return chemicalResistance;
    }
    
    private int getQuantity() {
        return quantity;
    }
    
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
            throw new Exception("Invalid order.");
        }
    }
}