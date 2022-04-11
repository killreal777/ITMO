package management;

import commands.abstractions.Command;
import data_xml.DataJaxbConverter;
import data_xml.auxiliary_structures.CollectionInfo;
import data_xml.auxiliary_structures.DataRoot;
import data_xml.auxiliary_structures.IdGenerator;
import data_xml.auxiliary_structures.CollectionRoot;
import data_xml.subject_area_structure.Organization;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.PriorityQueue;


public class DataManager {
    private final DataJaxbConverter jaxbConverter;
    private final CommandHistory history;
    private DataRoot dataRoot;


    public DataManager() {
        this.jaxbConverter = new DataJaxbConverter();
        this.history = new CommandHistory();
    }


    public void loadData(String filePath) throws JAXBException, IOException {
        jaxbConverter.setFilePath(filePath);
        this.dataRoot = jaxbConverter.readXml();
    }

    public void createData() {
        this.dataRoot = new DataRoot();
        dataRoot.setCollectionRoot(new CollectionRoot());
        dataRoot.getCollectionRoot().setCollection(new PriorityQueue<>());
        dataRoot.setCollectionInfo(new CollectionInfo());
        dataRoot.setIdGenerator(new IdGenerator());
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

    public String getInfo() {
        return "Info works";
        //return info.toString();    // TODO
    }

    public String getHistory() {
        return history.toString();
    }

    public void addToHistory(Command command) {
        history.addCommand(command);
    }
}
