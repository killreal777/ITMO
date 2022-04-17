package data.control;

import data.model.CollectionInfo;
import data.model.DataRoot;
import data.model.Organization;
import user_interface.Terminal;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;


public class DataManager {
    private final DataJaxbConverter jaxbConverter;
    private final IdGenerator idGenerator;
    private final DataRoot dataRoot;


    public DataManager(Terminal terminal) {
        this.jaxbConverter = new DataJaxbConverter(terminal);
        this.idGenerator = new IdGenerator();
        this.dataRoot = jaxbConverter.readXml(System.getenv("LAB5_DATA_FILE"));
        idGenerator.loadIdInfo(dataRoot.getCollectionRoot().getCollection());
    }


    public void saveData() {
        try {
            jaxbConverter.writeXml(dataRoot);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }


    public PriorityQueue<Organization> getCollection() {
        return dataRoot.getCollectionRoot().getCollection();
    }

    public CollectionInfo getCollectionInfo() {
        return dataRoot.getCollectionInfo();
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
}
