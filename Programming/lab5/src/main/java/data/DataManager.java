package data;

import model.CollectionInfo;
import model.DataRoot;
import model.Organization;
import app.Terminal;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;


/**
 * Class for managing data collection in object model form
 *
 * Provides data collection and some tools for working with it
 */


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


    /**
     * Saves collection to data file
     */
    public void saveData() throws FileNotFoundException {
        try {
            jaxbConverter.writeXml(dataRoot);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Provides data collection
     */
    public PriorityQueue<Organization> getCollection() {
        return dataRoot.getCollectionRoot().getCollection();
    }

    /**
     * Provides collection information
     */
    public CollectionInfo getCollectionInfo() {
        return dataRoot.getCollectionInfo();
    }

    /**
     * Provides IdGenerator
     */
    public IdGenerator getIdGenerator() {
        return idGenerator;
    }
}
