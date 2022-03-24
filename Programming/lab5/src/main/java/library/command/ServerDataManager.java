package library.command;

import library.organization.Organization;

import java.util.PriorityQueue;

public interface ServerDataManager {
    PriorityQueue<Organization> getCollection();
    String getInfo();
    String getHistory();
    void addToHistory(Command command);
}
