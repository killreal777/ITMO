package client.exceptions_handling.correction_logic;

public class CorrectionResult {
    private String[] correctedArgs;
    private final boolean isCorrectionRequested;

    public CorrectionResult(boolean isCorrectionRequested, String[] correctedArgs) {
        this.correctedArgs = correctedArgs;
        this.isCorrectionRequested = isCorrectionRequested;
    }

    public CorrectionResult(boolean isCorrectionRequested) {
        this.isCorrectionRequested = isCorrectionRequested;
    }

    public String[] getCorrectedArgs() {
        return correctedArgs;
    }

    public boolean isCorrectionRequested() {
        return isCorrectionRequested;
    }
}
