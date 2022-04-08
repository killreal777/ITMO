package main;

import data.Data;
import data.subject.Organization;

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
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Data.class);
            this.marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public DataJaxbConverter(String filePath) {
        new DataJaxbConverter().setFilePath(filePath);
    }


    public Data parseXml() throws JAXBException, IOException {
        FileReader reader = new FileReader(filePath);
        Data data = (Data) unmarshaller.unmarshal(reader);
        reader.close();
        return data;
    }

    public void writeXml(Data data) throws JAXBException, IOException {
        FileWriter writer = new FileWriter("src/main/java/data/data.xml");
        marshaller.marshal(data, writer);
        writer.close();
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
