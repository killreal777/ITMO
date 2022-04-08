package server;

import library.command.Command;
import library.command.ServerDataManager;
import library.data.CollectionInfo;
import library.data.IdGenerator;
import library.data.subject.Organization;

import java.util.PriorityQueue;

public class DataManager implements ServerDataManager {
    private final PriorityQueue<Organization> collection;
    private final CollectionInfo info;
    private final CommandHistory history;

    public DataManager(PriorityQueue<Organization> collection, CollectionInfo info, IdGenerator idInfo) {
        this.collection = collection;
        this.info = info;
        this.history = new CommandHistory();
    }

    @Override
    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    @Override
    public String getInfo() {
        return "Info works";
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
