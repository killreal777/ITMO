package client.exceptions_handling.correction_logic;

import client.exceptions_handling.exceptions.CorrectableException;

public interface ArgumentCorrector {
    CorrectionResult getCorrectionResult(CorrectableException exception);
}
