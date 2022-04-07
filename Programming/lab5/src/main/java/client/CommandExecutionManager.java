package client;

import client.commands.management.CommandManager;
import client.commands.management.CommandProvider;
import client.commands.management.EmptyCommand;
import client.exceptions_handling.correction_logic.ArgumentCorrector;
import client.exceptions_handling.correction_logic.CorrectionResult;
import client.exceptions_handling.correction_logic.Corrector;
import client.exceptions_handling.exceptions.CorrectableException;
import client.exceptions_handling.exceptions.NoSuchCommandException;
import client.user_interface.*;
import client.transport.*;
import com.sun.media.jfxmediaimpl.HostUtils;
import library.command.Command;
import library.command.ExecutionResult;
import library.command.ServerCommand;

import java.util.Arrays;

public class CommandExecutionManager implements ClientCommandExecutor {
    private final Terminal terminal;
    private final CommandProvider provider;
    private final ArgumentCorrector corrector;
    private final Transporter transporter;


    public CommandExecutionManager() {
        this.terminal = new UserTerminal();
        this.provider = new CommandManager(terminal);
        this.corrector = new Corrector(terminal);
        this.transporter = new ClientTransporter();

        terminal.print("Программа запущена \nДля вывода справки по доступным командам введите \"help\"");
    }


    @Override
    public void executeNextCommand() {
        try {
            String[] inputLine = terminal.readLine(ReadingMode.SPLIT);
            if (inputLine.length == 0)
                return;
            provider.prepareCommand(inputLine[0]);
            Command command = requestCommand(Arrays.copyOfRange(inputLine, 1, inputLine.length));
            executeCommand(command);
        } catch (NoSuchCommandException e) {
            terminal.print(e.getMessage());
        }
    }


    private Command requestCommand(String[] args) {
        try {
            return provider.getPreparedCommand(args);
        } catch (CorrectableException e) {
            CorrectionResult result = corrector.getCorrectionResult(e);
            if (result.isCorrectionRequested()) {
                String[] correctedArgs = result.getCorrectedArgs();
                return requestCommand(correctedArgs);
            } else
                return new EmptyCommand();
        }
    }


    private void executeCommand(Command command) {
        ExecutionResult result;
        if (command instanceof ServerCommand) {
            result = transporter.executeOnServer((ServerCommand) command);
        } else {
            command.execute();
            result = command.getResult();
        }
        terminal.print(result.toString());
    }
}
