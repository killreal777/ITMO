package data_xml;

import data_xml.auxiliary_structures.DataRoot;
import data_xml.subject_area_structure.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;


public class DataJaxbConverter {
    private final PriorityQueue<Organization> emptyCollectionPattern;    // for correct XML saving
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String filePath;

    {
        this.emptyCollectionPattern = new PriorityQueue<>();
        Organization emptyOrganization = new Organization();
        emptyOrganization.setName("MT");
        emptyOrganization.setFullName("Empty");
        emptyCollectionPattern.add(emptyOrganization);
    }


    public DataJaxbConverter() {
        try {
            JAXBContext context = JAXBContext.newInstance(DataRoot.class);
            this.marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public DataRoot readXml() throws JAXBException, IOException {
        FileReader reader = new FileReader(filePath);
        DataRoot dataRoot = (DataRoot) unmarshaller.unmarshal(reader);
        if (dataRoot.getCollectionRoot().getCollection().peek().getName().equals("MT")) {
            dataRoot.getCollectionRoot().setCollection(new PriorityQueue<>());
            System.err.println("Collection cleared");
        }
        reader.close();
        return dataRoot;
    }

    public void writeXml(DataRoot dataRoot) throws JAXBException, IOException {
        FileWriter writer = new FileWriter("src/main/java/data/data.xml");
        if (dataRoot.getCollectionRoot().getCollection().isEmpty()) {
            dataRoot.getCollectionRoot().setCollection(emptyCollectionPattern);
            System.err.println("Collection patternized");
        }
        marshaller.marshal(dataRoot, writer);
        writer.close();
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
