package commands.server_simple_commands;

import commands.abstractions.ServerCommand;
import data.model.Organization;

import java.util.PriorityQueue;


public class Head extends ServerCommand {
    public Head() {
        this.name = "head";
        this.description = "вывести первый элемент коллекции";
    }

    @Override
    public void execute() {
        PriorityQueue<Organization> collection = dataManager.getCollection();
        if (collection.isEmpty())
            this.result = "Collection is empty";
        else
            this.result = collection.peek().toString();
    }
}
