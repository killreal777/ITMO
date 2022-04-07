package JAXB.model;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"name", "age", "address"})
public class Person {
    private String name;
    private int age;
    private FullAddress address;


    public Person(String name, int age, FullAddress address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, Country country, String streetName, int houseNumber) {
        this.name = name;
        this.age = age;
        this.address = new FullAddress(country, streetName, houseNumber);
    }

    public Person() {   }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public FullAddress getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public void setAddress(FullAddress address) {
        this.address = address;
    }

    public void setAddress(Country country, String streetName, int houseNumber) {
        this.address = new FullAddress(country, streetName, houseNumber);
    }


    @Override
    public String toString() {
        return String.format("%s, %s y.o., %s", name, age, address);
    }
}
