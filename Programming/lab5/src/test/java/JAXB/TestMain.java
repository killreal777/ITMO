package JAXB;

import JAXB.model.Country;
import JAXB.model.Person;
import JAXB.model.PersonList;



public class TestMain {
    public static void main(String[] args) {
        try {
            PersonJaxbConverter converter = new PersonJaxbConverter();
            PersonList persons = new PersonList(converter.parseXml("src/test/java/JAXB/data/data.xml"));
            persons.add(new Person("Kirill Kravtsov", 18, Country.RUSSIA, "Prospect Nastavnikov", 45));
            converter.writeXml(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
