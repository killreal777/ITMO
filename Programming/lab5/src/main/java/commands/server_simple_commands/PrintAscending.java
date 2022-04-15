package commands.server_simple_commands;


import commands.abstractions.ServerCommand;
import data.model.Organization;

import java.util.stream.Collectors;

public class PrintAscending extends ServerCommand {
    public PrintAscending() {
        this.name = "print_ascending";
        this.description = "вывести элементы коллекции в порядке возрастания";
    }

    @Override
    public void execute() {
        for (Object organization : dataManager.getCollection().stream().sorted().toArray()) {
            if (result != "")
                result += "\n";
            this.result += organization.toString();
        }
        if (result.equals(""))
            this.result = "Коллекция пуста";
    }
}
