package library.organization;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private float z;
    private String name; //Поле может быть null

    public Location(Long x, int y, float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString() {
        return Long.toString(x) + "\n" + Integer.toString(y) + "\n" + Float.toString(z) + "\n" + name;
    }
}
