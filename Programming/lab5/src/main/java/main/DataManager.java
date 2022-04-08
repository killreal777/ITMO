package main;

import commands.abstractions.Command;
import data.CollectionInfo;
import data.Data;
import data.IdGenerator;
import data.OrganizationCollection;
import data.subject.Organization;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.PriorityQueue;


public class DataManager {
    private final DataJaxbConverter jaxbConverter;
    private Data data;
    private CommandHistory history;


    public DataManager() {
        this.jaxbConverter = new DataJaxbConverter();
        this.history = new CommandHistory();
    }


    public void loadData(String filePath) {
        jaxbConverter.setFilePath(filePath);
        try {
            this.data = jaxbConverter.parseXml();
        } catch (JAXBException | IOException e) {
            this.data = new Data();
            data.setCollection(new OrganizationCollection());
            data.getCollection().setCollection(new PriorityQueue<>());
            data.setCollectionInfo(new CollectionInfo());
            data.setIdGenerator(new IdGenerator());
        }
    }

    public void saveData() {
        try {
            jaxbConverter.writeXml(data);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }





    public PriorityQueue<Organization> getCollection() {
        return data.getCollection().getCollection();
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
