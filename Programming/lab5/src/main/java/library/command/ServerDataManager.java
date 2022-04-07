package library.command;

import library.model.Organization;

import java.util.PriorityQueue;

public interface ServerDataManager {
    PriorityQueue<Organization> getCollection();
    String getInfo();
    String getHistory();
    void addToHistory(Command command);
}
