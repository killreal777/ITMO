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
    private DataRoot dataRoot;


    public DataManager(Terminal terminal) {
        this.jaxbConverter = new DataJaxbConverter(terminal);
        this.idGenerator = new IdGenerator();
        loadData();
    }

    private void loadData() {
        try {
            this.dataRoot = jaxbConverter.readXml();
            idGenerator.loadIdInfo(dataRoot.getCollectionRoot().getCollection());
        } catch (IOException ignored) {}
    }


    public void saveData() throws FileNotFoundException {
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
