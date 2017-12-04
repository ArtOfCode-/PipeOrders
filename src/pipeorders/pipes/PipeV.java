package pipeorders.pipes;

public class PipeV extends AbstractPipe {
    /**
     * @see AbstractPipe#getMinSupportedGrade
     */
    public int getMinSupportedGrade() {
        return 3;
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
        return true;
    }

    /**
     * @see AbstractPipe#supportsReinforcement
     */
    public boolean supportsReinforcement() {
        return true;
    }
}
