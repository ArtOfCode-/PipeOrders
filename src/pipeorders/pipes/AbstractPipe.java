package pipeorders.pipes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
     * Identify the price of this type of pipe per cubic inch of plastic.
     * @return A float: the pipe price per unit area.
     */
    public abstract float getPricePerCubicInch();

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
     * Request a pipe type to be returned that supports the details requested in the provided order.
     * @param details An Order containing the requested pipe specifications.
     * @return An AbstractPipe, representing the first type of pipe that supports the requested details.
     * @throws Exception if no valid pipe type can be found.
     */
    public static AbstractPipe findSupportingPipe(Order details) throws Exception {
        Optional<AbstractPipe> supportingType = PIPE_TYPES.stream().filter((type) -> {
            return details.getGrade() >= type.getMinSupportedGrade() &&
                   details.getGrade() <= type.getMaxSupportedGrade() &&
                   type.supportsColorPrintType(details.getColors()) &&
                   details.getLength() <= MAX_LENGTH &&
                   details.getLength() >= MIN_LENGTH && 
                   details.getOuterDiameter() <= MAX_DIAMETER &&
                   details.requiresInsulation() ? type.supportsInsulation() : !type.supportsInsulation() &&
                   details.requiresReinforcement() ? type.supportsReinforcement() : !type.supportsReinforcement();
        }).findFirst();
        
        if (supportingType.isPresent()) {
            return supportingType.get();
        }
        else {
            throw new Exception("No known pipe type supports the requirements of the order.");
        }
    }
}
