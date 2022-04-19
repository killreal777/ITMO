package commands.server_simple_commands;

import commands.abstractions.ServerCommand;
import model.Organization;


public class Show extends ServerCommand {
    public Show() {
        this.name = "show";
        this.description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute() {
        for (Organization org : dataManager.getCollection()) {
            if (result != "")
                result += "\n";
            this.result += org.toString();
        }
        if (result.equals(""))
            this.result = "Коллекция пуста";
    }
}
