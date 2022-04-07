package JAXB.model;

public enum Country {
    USA("United States of America"),
    UK("United Kingdom"),
    FRANCE("France"),
    GERMANY("Germany"),
    RUSSIA("Russian Federation");

    private String name;

    private Country(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
