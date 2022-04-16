package data.control;

import data.model.CollectionInfo;
import data.model.DataRoot;
import data.model.Organization;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;


public class DataManager {
    private final DataJaxbConverter jaxbConverter;
    private final IdGenerator idGenerator;
    private DataRoot dataRoot;


    public DataManager() {
        this.jaxbConverter = new DataJaxbConverter();
        this.idGenerator = new IdGenerator();
        //jaxbConverter.setFilePath(System.getenv("LAB5_DATA_COLLECTION_FILE"));
        jaxbConverter.setFilePath("src/main/java/data/data.xml");
        loadData();
    }


    private void loadData() {
        try {
            this.dataRoot = jaxbConverter.readXml();
            idGenerator.loadIdInfo(dataRoot.getCollectionRoot().getCollection());
        } catch (FileNotFoundException e) {
            System.err.println("File not found \nCreated new file");
            this.dataRoot = new DataRoot();
            idGenerator.loadIdInfo(dataRoot.getCollectionRoot().getCollection());
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
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
