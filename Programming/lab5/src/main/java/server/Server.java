package server;

import library.command.ExecutionResult;
import library.command.ServerCommand;
import library.command.ServerDataManager;
import library.data.CollectionInfo;
import library.data.Data;
import library.data.DataJaxbConverter;
import library.data.IdGenerator;
import library.data.subject.Organization;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.PriorityQueue;

public class Server implements ServerCommandExecutor {
    private ServerDataManager dataManager;
    private DataJaxbConverter converter;


    public Server() {
        this.converter = new DataJaxbConverter("src/main/java/library/data/data.xml");
        try {
            Data data = converter.parseXml();
            PriorityQueue<Organization> collection = data.getCollection();
            CollectionInfo collectionInfo = data.getCollectionInfo();
            IdGenerator idInfo = data.getIdInfo();
            this.dataManager = new DataManager(collection, collectionInfo, idInfo);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ExecutionResult executeCommand(ServerCommand command) {
        command.setDataManager(dataManager);
        command.execute();
        dataManager.addToHistory(command);

        return command.getResult();
    }
}
