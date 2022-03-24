package library.organization;

public class Address {
    private final String zipCode; //Длина строки не должна быть больше 16, Поле не может быть null
    private final Location town; //Поле не может быть null

    public Address(String zipCode, Long x, int y, float z, String name) {
        this.zipCode = zipCode;
        this.town = new Location(x, y, x, name);
    }

    @Override
    public String toString() {
        return zipCode + "\n" + town.toString();
    }
}
