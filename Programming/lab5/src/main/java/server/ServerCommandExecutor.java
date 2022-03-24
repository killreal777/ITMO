package server;

import library.command.ExecutionResult;
import library.command.ServerCommand;

public interface ServerCommandExecutor {
    ExecutionResult executeCommand(ServerCommand command);
}
