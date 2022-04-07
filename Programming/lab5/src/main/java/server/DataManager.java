package server;

import library.command.Command;
import library.command.ServerDataManager;
import library.model.Organization;

import java.util.PriorityQueue;

public class DataManager implements ServerDataManager {
    private final PriorityQueue<Organization> collection;
    private final CollectionInfo info;
    private final CommandHistory history;
    private final IdGenerator idGenerator;

    public DataManager() {
        this.collection = new PriorityQueue<Organization>();
        this.info = new CollectionInfo();
        this.history = new CommandHistory();
        this.idGenerator = new IdGenerator();
    }

    @Override
    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    @Override
    public String getInfo() {
        return "Info works yeah";
        //return info.toString();    // TODO
    }

    @Override
    public String getHistory() {
        return history.toString();
    }

    @Override
    public void addToHistory(Command command) {
        history.addCommand(command);
    }
}
