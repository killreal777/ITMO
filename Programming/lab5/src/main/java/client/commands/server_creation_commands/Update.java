package client.commands.server_creation_commands;

import client.commands.server_creation_commands.creators.OrganizationCreator;
import client.user_interface.Terminal;
import library.command.Command;

public class Update extends CreationCommand {
    public Update(Terminal terminal) {
        super(terminal, new OrganizationCreator(terminal));
    }

    @Override
    public void execute() {

    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public Command getUsableClone() {
        return null;
    }
}
