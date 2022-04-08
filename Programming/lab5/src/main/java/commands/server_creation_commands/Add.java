package commands.server_creation_commands;

import commands.server_creation_commands.creators.OrganizationCreator;
import exceptions_handling.exceptions.ArgumentsAmountException;
import user_interface.Terminal;
import commands.abstractions.Command;
import data.subject.Organization;

import java.util.PriorityQueue;

public class Add extends CreationCommand {
    private final Terminal terminal;
    private Organization organization;


    public Add(Terminal terminal) {
        super(terminal, new OrganizationCreator(terminal));
        this.terminal = terminal;
    }


    @Override
    public Command getClone() {
        return new Add(terminal);
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
    public void execute() {
        PriorityQueue<Organization> dataCollection = this.dataManager.getCollection();
        dataCollection.add(organization);
        this.result.write("Элемент успешно добавлен");
    }


    @Override
    public String getHelp() {
        String name = "add {element}";
        String description = "добавить новый элемент в коллекцию";
        return String.format("%s: %s", name, description);
    }
}
