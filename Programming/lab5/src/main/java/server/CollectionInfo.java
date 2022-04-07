package server;

import java.time.LocalDateTime;

class CollectionInfo {
    private final String collectionType;
    private LocalDateTime initializationDate;
    private int elementsAmount;

    public CollectionInfo() {
        this.collectionType = "PriorityQueue<Organization>";
    }


    public void setInitializationDate(LocalDateTime date) {
        this.initializationDate = date;
    }

    public void incrementElementsAmount() {
        elementsAmount++;
    }

    public void decrementElementsAmount() {
        elementsAmount--;
    }


    @Override
    public String toString() {
        String type = String.format("Collection type: %s\n", collectionType);
        String date = String.format("Initialization date: %s\n", initializationDate);
        String amount = String.format("Elements amount: %s", elementsAmount);
        return type + date + amount;
    }
}
