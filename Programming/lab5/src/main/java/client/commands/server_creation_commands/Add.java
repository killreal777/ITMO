package client.commands.server_creation_commands;

import client.commands.server_creation_commands.creators.OrganizationCreator;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.user_interface.Terminal;
import library.command.Command;
import library.organization.Organization;

import java.util.PriorityQueue;

public class Add extends CreationCommand {
    private final Terminal terminal;
    private Organization organization;


    public Add(Terminal terminal) {
        super(terminal, new OrganizationCreator(terminal));
        this.terminal = terminal;
    }

    @Override
    public void execute() {
        PriorityQueue<Organization> dataCollection = this.dataManager.getCollection();
        dataCollection.add(organization);
        this.result.write("Элемент успешно добавлен");
    }

    @Override
    public void setArgs(String[] args) {
        if (!isCreationStarted) {
            if (args.length != 0)
                throw new ArgumentsAmountException(args, 0);
            isCreationStarted = true;
            creator.setReadArgs();
        } else {
            creator.setExternalArgs(args);
        }
        organization = (Organization) creator.getResult();
    }

    @Override
    public Command getUsableClone() {
        return new Add(terminal);
    }
}