package JAXB.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "collection")
public class PersonList {
    @XmlElement(name = "person")
    private ArrayList<Person> collection = new ArrayList<>();

    public PersonList() {}

    public PersonList(ArrayList<Person> collection) {
        this.collection = collection;
    }

    public ArrayList<Person> getCollection() {
        return collection;
    }

    public void add(Person person) {
        collection.add(person);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("COLLECTION\n##############");
        for (Person person : collection)
            out.append("\n").append(person.toString());
        out.append("\n##############");
        return out.toString();
    }
}
