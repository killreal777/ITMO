package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;
import library.model.Organization;

public class Show extends ServerCommand {
    @Override
    public Command getClone() {
        return new Show();
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {
        if (dataManager.getCollection().iterator().hasNext()) {
            for (Organization org : dataManager.getCollection())
                this.result.write(org.toString());
        } else
            this.result.write("Коллекция пуста");
    }


    @Override
    public String getHelp() {
        String name = "show";
        String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
        return String.format("%s: %s", name, description);
    }
}
