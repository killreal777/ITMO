package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;
import library.organization.Organization;

public class Show extends ServerCommand {
    @Override
    public void execute() {
        if (dataManager.getCollection().iterator().hasNext()) {
            for (Organization org : dataManager.getCollection())
                this.result.write(org.toString());
        } else
            this.result.write("Коллекция пуста");
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public Command getUsableClone() {
        return new Show();
    }
}
