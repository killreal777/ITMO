package data.control;

import data.model.Organization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class IdGenerator {
    private final ArrayList<Integer> removedIds;
    private int currentHighestId;


    public IdGenerator() {
        removedIds = new ArrayList<>();
    }


    public int generateId() {
        if (removedIds.isEmpty()) {
            currentHighestId++;
            return currentHighestId;
        } else
            return removedIds.remove(0);
    }

    public void removeId(int id) {
        removedIds.add(id);
    }


    public void loadIdInfo(Collection<Organization> collection) {
        if (collection.isEmpty())
            return;
        ArrayList<Integer> ids = new ArrayList<>();
        for (Organization organization : collection)
            ids.add(organization.getId());
        this.currentHighestId = Collections.max(ids);
        for (int id = 1; id < currentHighestId; id++) {
            if (!ids.contains(id))
                removedIds.add(id);
        }
    }
}
