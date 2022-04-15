package JAXB;

import JAXB.model.Country;
import JAXB.model.Person;
import JAXB.model.PersonList;

import java.util.ArrayList;


public class TestMain {
    public static void main(String[] args) {
        try {
            PersonJaxbConverter converter = new PersonJaxbConverter();
            PersonList personList = new PersonList(converter.parseXml("src/test/java/JAXB/data/data.xml"));
            System.out.println(personList);
            ArrayList<Person> collection = personList.getCollection();
            collection.clear();

            converter.writeXml(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
