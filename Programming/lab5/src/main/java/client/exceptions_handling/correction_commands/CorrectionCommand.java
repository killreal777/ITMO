package client.exceptions_handling.correction_commands;

import client.exceptions_handling.correction_logic.CorrectionResult;
import client.exceptions_handling.exceptions.CorrectableException;

public interface CorrectionCommand {
    public CorrectionResult execute(CorrectableException exception);
    public String getMan();
}
