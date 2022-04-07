package JAXB.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "full_address")
public class FullAddress {
    private Country country;
    private String streetName;
    private int houseNumber;

    public FullAddress(Country country, String streetName, int houseNumber) {
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public FullAddress() {  }


    public Country getCountry() {
        return country;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @XmlElement(name = "country")
    public void setCountry(Country country) {
        this.country = country;
    }

    @XmlElement(name = "street_name")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @XmlElement(name = "house_number")
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }


    @Override
    public String toString() {
        return String.format("%s, %s %s", country, streetName, houseNumber);
    }
}
