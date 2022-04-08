package data;

import data.subject.Organization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.PriorityQueue;


@XmlRootElement(name = "collection")
public class OrganizationCollection {
    private PriorityQueue<Organization> collection;


    public OrganizationCollection() {}


    @XmlElement(name = "organization")
    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    public void setCollection(PriorityQueue<Organization> collection) {
        this.collection = collection;
    }
}
