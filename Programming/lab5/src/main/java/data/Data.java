package data;

import data.subject.Organization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.PriorityQueue;


@XmlRootElement(name = "data")
@XmlType(propOrder = {"collectionInfo", "collection", "idGenerator"})
public class Data {
    private CollectionInfo collectionInfo;
    private OrganizationCollection collection;
    private IdGenerator idGenerator;


    public Data() {}


    @XmlElement(name = "collection")
    public OrganizationCollection getCollection() {
        return collection;
    }

    @XmlElement(name = "collection_info")
    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    @XmlElement(name = "id_info")
    public IdGenerator getIdGenerator() {
        return idGenerator;
    }


    public void setCollection(OrganizationCollection collection) {
        this.collection = collection;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
