package pipeorders.pipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import pipeorders.Order;

public abstract class AbstractPipe {
    /**
     * Validation constraint: the maximum length of a single pipe that can be supplied, in metres.
     */
    private static final float MAX_LENGTH = 100.0f;
    
    /**
     * Validation constraint: the minimum length of a single pipe that can be supplied, in metres.
     */
    private static final float MIN_LENGTH = 0.001f;
    
    /**
     * Validation constraint: the maximum outer diameter of a pipe that can be supplied, in inches.
     */
    private static final float MAX_DIAMETER = 240.0f;
    
    /**
     * A list of all pipe types that can be supplied.
     */
    private static final List<AbstractPipe> PIPE_TYPES = Arrays.asList(new PipeI(), new PipeII(), new PipeIII(),
                                                                       new PipeIV(), new PipeV());

    private static HashMap<Integer, Double> GRADED_PRICES;
    static {
        GRADED_PRICES = new HashMap<Integer, Double>();
        GRADED_PRICES.put(1, 0.4);
        GRADED_PRICES.put(2, 0.6);
        GRADED_PRICES.put(3, 0.75);
        GRADED_PRICES.put(4, 0.8);
        GRADED_PRICES.put(5, 0.95);
    }

    /**
     * Identify the minimum supported grade of plastic this pipe type supports.
     * @return An integer: the minimum supported grade.
     */
    public abstract int getMinSupportedGrade();

    /**
     * Identify the maximum supported grade of plastic this pipe type supports.
     * @return An integer: the maximum supported grade.
     */
    public abstract int getMaxSupportedGrade();

    /**
     * Query whether this pipe type supports a certain number of colors for color print.
     * @param colors The number of colors requested.
     * @return A boolean, indicating whether the pipe supports the requested number of colors.
     */
    public abstract boolean supportsColorPrintType(int colors);

    /**
     * Query whether this pipe type supports inner insulation.
     * @return A boolean, indicating whether or not the pipe supports insulation.
     */
    public abstract boolean supportsInsulation();

    /**
     * Query whether this pipe type supports outer reinforcement.
     * @return A boolean, indicating whether or not the pipe supports reinforcement.
     */
    public abstract boolean supportsReinforcement();

    /**
     * Get the price per cubic inch of plastic for this pipe. Based on plastic grade.
     * @param grade The grade of plastic to be used in the pipe.
     * @return A double containing a price per unit volume.
     */
    public double getPricePerCubicInch(int grade) {
        return GRADED_PRICES.get(grade);
    }

    /**
     * Request a pipe type to be returned that supports the details requested in the provided order.
     * @param details An Order containing the requested pipe specifications.
     * @return An AbstractPipe, representing the first type of pipe that supports the requested details.
     * @throws Exception if no valid pipe type can be found.
     */
    public static AbstractPipe findSupportingPipe(Order details) throws Exception {
        for (AbstractPipe type : PIPE_TYPES) {
            if (details.getGrade() >= type.getMinSupportedGrade() &&
                details.getGrade() <= type.getMaxSupportedGrade() &&
                type.supportsColorPrintType(details.getColors()) &&
                details.getLength() <= MAX_LENGTH &&
                details.getLength() >= MIN_LENGTH &&
                details.getOuterDiameter() <= MAX_DIAMETER &&
                (!details.requiresInsulation() || type.supportsInsulation()) &&
                (!details.requiresReinforcement() || type.supportsReinforcement())) {
                return type;
            }
        }

        throw new Exception("No known pipe type supports the requirements of the order.");
    }
}
