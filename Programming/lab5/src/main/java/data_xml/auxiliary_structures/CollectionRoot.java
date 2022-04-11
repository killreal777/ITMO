package data_xml.auxiliary_structures;

import data_xml.subject_area_structure.Organization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.PriorityQueue;


@XmlRootElement(name = "collection")
public class CollectionRoot {
    private PriorityQueue<Organization> collection;


    public CollectionRoot() {}


    @XmlElement(name = "organization")
    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    public void setCollection(PriorityQueue<Organization> collection) {
        this.collection = collection;
    }
}
