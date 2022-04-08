package library.data;

import library.data.subject.Organization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.PriorityQueue;


@XmlRootElement(name = "data")
@XmlType(propOrder = {"collection_info", "collection", "id_info"})
public class Data {
    private CollectionInfo collectionInfo;
    private PriorityQueue<Organization> collection;
    private IdGenerator idInfo;


    public Data() {}


    @XmlElement(name = "collection")
    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    @XmlElement(name = "collection_info")
    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    @XmlElement(name = "id_info")
    public IdGenerator getIdInfo() {
        return idInfo;
    }


    public void setCollection(PriorityQueue<Organization> collection) {
        this.collection = collection;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public void setIdInfo(IdGenerator idInfo) {
        this.idInfo = idInfo;
    }
}
