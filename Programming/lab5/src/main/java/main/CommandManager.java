package main;

import exceptions_handling.exceptions.CorrectableException;
import exceptions_handling.exceptions.NoSuchCommandException;
import user_interface.Terminal;
import commands.abstractions.Command;
import commands.local_commands.ExecuteScript;
import commands.local_commands.Exit;
import commands.local_commands.Help;
import commands.local_commands.History;
import commands.server_creation_commands.Add;
import commands.server_creation_commands.AddIfMax;
import commands.server_creation_commands.RemoveByAddress;
import commands.server_creation_commands.Update;
import commands.server_simple_commands.*;

import java.util.HashMap;


public class CommandManager {
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
        commands.put("save", new Save());

        // local commands
        commands.put("history", new History());
        commands.put("execute_script", new ExecuteScript());
        commands.put("help", new Help(commands));
        commands.put("exit", new Exit());
    }


    public void prepareCommand(String name) throws NoSuchCommandException {
        if (commands.containsKey(name))
            currentCommand = commands.get(name).getClone();
        else
            throw new NoSuchCommandException(name);
    }

    public Command getPreparedCommand(String[] args) throws CorrectableException {
        currentCommand.setArgs(args);
        return currentCommand;
    }
}
