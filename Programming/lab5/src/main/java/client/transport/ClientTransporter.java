package client.transport;

import library.command.ExecutionResult;
import library.command.ServerCommand;
import server.Server;
import server.ServerCommandExecutor;

public class ClientTransporter implements Transporter {
    private final ServerCommandExecutor server;

    public ClientTransporter() {
        this.server = new Server();
    }

    @Override
    public ExecutionResult executeOnServer(ServerCommand command) {
        return server.executeCommand(command);
    }
}
