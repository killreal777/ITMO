package management;

import commands.local_commands.EmptyCommand;
import exceptions_handling.correction_logic.ArgumentCorrector;
import exceptions_handling.correction_logic.CorrectionResult;
import exceptions_handling.correction_logic.Corrector;
import exceptions_handling.exceptions.CorrectableException;
import exceptions_handling.exceptions.NoSuchCommandException;
import commands.abstractions.Command;
import commands.abstractions.ServerCommand;
import user_interface.ReadingMode;
import user_interface.Terminal;
import user_interface.UserTerminal;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExecutionManager {
    private final Terminal terminal;
    private final CommandManager commandManager;
    private final DataManager dataManager;
    private final CommandHistory history;
    private final ArgumentCorrector corrector;


    public ExecutionManager() {
        this.terminal = new UserTerminal();
        this.commandManager = new CommandManager(terminal);
        this.dataManager = new DataManager();
        this.history = new CommandHistory();
        this.corrector = new Corrector(terminal);
        loadData();
        terminal.print("Программа запущена \nДля вывода справки по доступным командам введите \"help\"");
    }

    private void loadData() {
        try {
            dataManager.loadData("src/main/java/data/data.xml");
        } catch (FileNotFoundException e) {
            System.err.println("File not found \nCreated new file");
            dataManager.createData();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }


    public void executeNextCommand() {
        try {
            String[] inputLine = terminal.readLine(ReadingMode.SPLIT);
            if (inputLine.length == 0)
                return;
            commandManager.prepareCommand(inputLine[0]);
            Command command = requestCommand(Arrays.copyOfRange(inputLine, 1, inputLine.length));
            executeCommand(command);
        } catch (NoSuchCommandException e) {
            terminal.print(e.getMessage());
        }
    }


    private Command requestCommand(String[] args) {
        try {
            return commandManager.getPreparedCommand(args);
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
        if (command instanceof ServerCommand)
            ((ServerCommand) command).setDataManager(dataManager);
        command.execute();
        history.addCommand(command);
        terminal.print(command.getResult().toString());
    }
}
