package JAXB;

import JAXB.model.Person;
import JAXB.model.PersonList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;

public class PersonJaxbConverter {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public PersonJaxbConverter() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PersonList.class);
        this.marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        this.unmarshaller = context.createUnmarshaller();
    }

    public ArrayList<Person> parseXml(String fileName) throws JAXBException, FileNotFoundException {
        FileReader reader = new FileReader(fileName);
        PersonList personList = (PersonList) unmarshaller.unmarshal(reader);
        return personList.getCollection();
    }

    public void writeXml(PersonList persons) throws JAXBException, IOException {
        FileWriter writer = new FileWriter("src/test/java/JAXB/data/data.xml");
        marshaller.marshal(persons, writer);
    }
}
