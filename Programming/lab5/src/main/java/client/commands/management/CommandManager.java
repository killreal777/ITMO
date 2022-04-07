package client.commands.management;

import client.commands.local_commands.*;
import client.commands.server_creation_commands.*;
import client.commands.server_simple_commands.*;

import client.exceptions_handling.exceptions.CorrectableException;
import client.exceptions_handling.exceptions.NoSuchCommandException;
import client.user_interface.Terminal;
import library.command.Command;

import java.util.HashMap;

public class CommandManager implements CommandProvider {
    private final HashMap<String, Command> commands;
    private Command currentCommand;

    public CommandManager(Terminal terminal) {
        commands = new HashMap<>();

        // server creation commands
        commands.put("add", new Add(terminal));
        commands.put("add_if_max", new AddIfMax(terminal));
        commands.put("update", new Update(terminal));
        commands.put("remove_any_by_official_address", new RemoveByAddress());

        // server simple commands
        commands.put("remove_by_id", new RemoveByID());
        commands.put("clear", new Clear());
        commands.put("show", new Show());
        commands.put("head", new Head());
        commands.put("print_ascending", new PrintAscending());
        commands.put("filter_starts_with_name", new FilterStartsWithName());
        commands.put("info", new Info());
        commands.put("save", new Head());

        // local commands
        commands.put("history", new History());
        commands.put("execute_script", new ExecuteScript());
        commands.put("help", new Help(commands));
        commands.put("exit", new Exit());
    }


    @Override
    public void prepareCommand(String name) throws NoSuchCommandException {
        if (commands.containsKey(name))
            currentCommand = commands.get(name).getClone();
        else
            throw new NoSuchCommandException(name);
    }

    @Override
    public Command getPreparedCommand(String[] args) throws CorrectableException {
        currentCommand.setArgs(args);
        return currentCommand;
    }
}
