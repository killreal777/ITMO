package data_xml.auxiliary_structures;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "data_xml")
@XmlType(propOrder = {"collectionInfo", "collectionRoot", "idGenerator"})
public class DataRoot {
    private CollectionInfo collectionInfo;
    private CollectionRoot collectionRoot;
    private IdGenerator idGenerator;


    public DataRoot() {}


    @XmlElement(name = "collection")
    public CollectionRoot getCollectionRoot() {
        return collectionRoot;
    }

    @XmlElement(name = "collection_info")
    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    @XmlElement(name = "id_info")
    public IdGenerator getIdGenerator() {
        return idGenerator;
    }


    public void setCollectionRoot(CollectionRoot collectionRoot) {
        this.collectionRoot = collectionRoot;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
