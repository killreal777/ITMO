package client;

import client.ClientCommandExecutor;
import client.CommandExecutionManager;

public class Client {
    public static void main(String[] args) {
        final ClientCommandExecutor commandExecutor = new CommandExecutionManager();
        while (true) {
            commandExecutor.executeNextCommand();
        }
    }
}
