package client.transport;

import library.command.ExecutionResult;
import library.command.ServerCommand;

public interface Transporter {
    ExecutionResult executeOnServer(ServerCommand command);
}
