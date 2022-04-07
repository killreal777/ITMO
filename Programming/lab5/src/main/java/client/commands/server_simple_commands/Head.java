package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;
import library.model.Organization;

import java.util.PriorityQueue;

public class Head extends ServerCommand {
    @Override
    public Command getClone() {
        return new Head();
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {
        PriorityQueue<Organization> collection = dataManager.getCollection();
        if (collection.isEmpty())
            this.result.write("Collection is empty");
        else
            this.result.write(collection.peek().toString());
    }


    @Override
    public String getHelp() {
        String name = "head";
        String description = "вывести первый элемент коллекции";
        return String.format("%s: %s", name, description);
    }

    @Override
    public String toString() {
        return "Head";
    }
}
