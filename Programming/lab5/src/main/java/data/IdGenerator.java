package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;


@XmlRootElement(name = "id_info")
@XmlType(propOrder = {"currentHighestId", "removedIds"})
public class IdGenerator {
    private int currentHighestId;
    private ArrayList<Integer> removedIds;


    public IdGenerator() {}


    public int generateId() {
        if (removedIds.isEmpty())
            return currentHighestId++;
        else
            return removedIds.remove(0);
    }

    public void removeId(int id) {
        removedIds.add(id);
    }


    @XmlElement(name = "current_highest_id")
    public int getCurrentHighestId() {
        return currentHighestId;
    }

    @XmlElement(name = "removed_ids")
    public ArrayList<Integer> getRemovedIds() {
        return removedIds;
    }


    public void setCurrentHighestId(int currentHighestId) {
        this.currentHighestId = currentHighestId;
    }

    public void setRemovedIds(ArrayList<Integer> removedIds) {
        this.removedIds = removedIds;
    }
}
