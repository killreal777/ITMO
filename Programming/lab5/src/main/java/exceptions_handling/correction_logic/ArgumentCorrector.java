package exceptions_handling.correction_logic;

import exceptions_handling.exceptions.CorrectableException;

public interface ArgumentCorrector {
    CorrectionResult getCorrectionResult(CorrectableException exception);
}
