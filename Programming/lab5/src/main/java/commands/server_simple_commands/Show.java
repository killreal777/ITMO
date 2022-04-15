package commands.server_simple_commands;

import commands.abstractions.ServerCommand;
import data.model.Organization;


public class Show extends ServerCommand {
    public Show() {
        this.name = "show";
        this.description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute() {
        System.out.printf("DATA Manager: %s%n", dataManager);   // for test
        for (Organization org : dataManager.getCollection()) {
            if (result != "")
                result += "\n";
            this.result += org.toString();
        }
        if (result.equals(""))
            this.result = "Коллекция пуста";
    }
}
