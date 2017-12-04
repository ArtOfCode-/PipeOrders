package pipeorders.pipes;

public class PipeIII extends AbstractPipe {
    /**
     * @see AbstractPipe#getMinSupportedGrade
     */
    public int getMinSupportedGrade() {
        return 2;
    }

    /**
     * @see AbstractPipe#getMaxSupportedGrade
     */
    public int getMaxSupportedGrade() {
        return 5;
    }

    /**
     * @see AbstractPipe#supportsColorPrintType(int)
     */
    public boolean supportsColorPrintType(int colors) {
        return colors == 2;
    }

    /**
     * @see AbstractPipe#supportsInsulation
     */
    public boolean supportsInsulation() {
        return false;
    }

    /**
     * @see AbstractPipe#supportsReinforcement
     */
    public boolean supportsReinforcement() {
        return false;
    }
}
