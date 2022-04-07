package client;

public class Main {
    public static void main(String[] args) {
        final ClientCommandExecutor commandExecutor = new CommandExecutionManager();
        while (true) {
            commandExecutor.executeNextCommand();
        }
    }
}
