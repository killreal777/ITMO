package library.model;

public enum OrganizationType {
    COMMERCIAL("Коммерческая организация", 0),
    TRUST("Траст", 1),
    PRIVATE_LIMITED_COMPANY("Общество с ограниченной ответственностью", 2),
    OPEN_JOINT_STOCK_COMPANY("Открытое акционерное общество", 3);

    private final String name;
    private final int id;

    OrganizationType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static OrganizationType getByID(int id) throws InvalidIDException {
        switch (id) {
            case 0:
                return COMMERCIAL;
            case 1:
                return TRUST;
            case 2:
                return PRIVATE_LIMITED_COMPANY;
            case 3:
                return OPEN_JOINT_STOCK_COMPANY;
        }
        throw new InvalidIDException();
    }

    @Override
    public String toString() {
        return name;
    }


    public static class InvalidIDException extends RuntimeException {
    }
}
