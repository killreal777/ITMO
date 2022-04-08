package commands.local_commands;

import exceptions_handling.exceptions.ArgumentsAmountException;
import commands.abstractions.Command;

import java.util.HashMap;


public class Help extends Command {
    private final HashMap<String, Command> commands;


    public Help(HashMap<String, Command> commands) {
        this.commands = commands;
    }


    @Override
    public Command getClone() {
        return new Help(commands);
    }

    @Override
    public void setArgs(String[] args) throws ArgumentsAmountException {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public void execute() {
        for (Command command : commands.values()) {
            String help = command.getHelp();
            String coloredHelp = highlightCommandName(help);
            result.write(coloredHelp);
        }
    }


    @Override
    public String getHelp() {
        String name = "help";
        String description = "вывести справку по доступным командам";
        return String.format("%s: %s", name, description);
    }


    private String highlightCommandName(String help) {
        String divider = ": ";

        String[] nameAndDescription = help.split(divider);
        String name = nameAndDescription[0];
        String description = nameAndDescription[1];

        String formatOpen = "\033[1;93m";     // red underlined
        String formatClose = "\033[0m";       // red underlined

        return formatOpen + name + formatClose + divider + description;
    }
}
