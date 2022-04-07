package client.commands.server_creation_commands;

import client.commands.server_creation_commands.creators.OrganizationCreator;
import client.user_interface.Terminal;
import library.command.Command;

public class Update extends CreationCommand {
    public Update(Terminal terminal) {
        super(terminal, new OrganizationCreator(terminal));
    }


    @Override
    public Command getClone() {
        return null;
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {

    }


    @Override
    public String getHelp() {
        String name = "update id {element}";
        String description = "обновить значение элемента коллекции, id которого равен заданному";
        return String.format("%s: %s", name, description);
    }
}
