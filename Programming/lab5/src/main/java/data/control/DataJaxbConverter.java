package data.control;

import data.model.DataRoot;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DataJaxbConverter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String filePath;


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
        reader.close();
        return dataRoot;
    }

    public DataRoot readXml(String filePath) throws JAXBException, IOException {
        setFilePath(filePath);
        return readXml();
    }

    public void writeXml(DataRoot dataRoot) throws JAXBException, IOException {
        FileWriter writer = new FileWriter("src/main/java/data/data.xml");
        marshaller.marshal(dataRoot, writer);
        writer.close();
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
