package server;

import library.command.ExecutionResult;
import library.command.ServerCommand;
import library.command.ServerDataManager;

public class Server implements ServerCommandExecutor {
    private final ServerDataManager dataManager;

    public Server() {
        this.dataManager = new DataManager();
    }

    @Override
    public ExecutionResult executeCommand(ServerCommand command) {
        command.setDataManager(dataManager);
        command.execute();
        dataManager.addToHistory(command);
        return command.getResult();
    }
}
