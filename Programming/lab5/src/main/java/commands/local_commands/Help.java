package commands.local_commands;

import commands.abstractions.Command;

import java.util.HashMap;


public class Help extends Command {
    private final HashMap<String, Command> commands;


    public Help(HashMap<String, Command> commands) {
        this.name = "help";
        this.description = "вывести справку по доступным командам";
        this.commands = commands;
    }


    @Override
    public void execute() {
        for (Command command : commands.values()) {
            String help = command.getHelp();
            String coloredHelp = highlightCommandName(help);
            if (result != "")
                result += "\n";
            result += (coloredHelp);
        }
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
