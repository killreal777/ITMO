package server;

import java.util.ArrayList;

public class IdGenerator {
    private final ArrayList<Integer> cleanedId;
    private int currentHighestId;

    public IdGenerator() {
        this.cleanedId = new ArrayList<>();
        this.currentHighestId = 0;
    }

    public int generateId() {
        if (cleanedId.isEmpty())
            return currentHighestId++;
        else
            return cleanedId.remove(0);
    }

    public void clearId(int id) {
        cleanedId.add(id);
    }
}
