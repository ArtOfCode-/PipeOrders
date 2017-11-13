package pipeorders.pipes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import pipeorders.Order;

public abstract class AbstractPipe {
    /**
     * Validation constraint: the maximum length of a single pipe that can be supplied, in metres.
     */
    public static final float MAX_LENGTH = 100.0f;
    
    /**
     * Validation constraint: the minimum length of a single pipe that can be supplied, in metres.
     */
    public static final float MIN_LENGTH = 0.001f;
    
    /**
     * Validation constraint: the maximum outer diameter of a pipe that can be supplied, in inches.
     */
    public static final float MAX_DIAMETER = 240.0f;
    
    /**
     * A list of all pipe types that can be supplied.
     */
    public static final List<AbstractPipe> PIPE_TYPES = Arrays.asList();
    
    public abstract int getMinSupportedGrade();
    public abstract int getMaxSupportedGrade();
    
    public abstract float getPricePerCubicInch();
    
    public abstract boolean supportsColorPrintType(int colors);
    public abstract boolean supportsInsulation();
    public abstract boolean supportsReinforcement();
    
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
