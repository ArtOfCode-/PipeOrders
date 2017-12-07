package pipeorders.pipes;

public class PipeI extends AbstractPipe {
    /**
     * @see AbstractPipe#getMinSupportedGrade
     */
    public int getMinSupportedGrade() {
        return 1;
    }

    /**
     * @see AbstractPipe#getMaxSupportedGrade
     */
    public int getMaxSupportedGrade() {
        return 3;
    }

    /**
     * @see AbstractPipe#supportsColorPrintType(int)
     */
    public boolean supportsColorPrintType(int colors) {
        return colors == 0;
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