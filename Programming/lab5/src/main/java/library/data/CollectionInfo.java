package library.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;


@XmlRootElement(name = "collection_info")
@XmlType(propOrder = {"collection_type", "initialization_date", "elements_amount"})
public class CollectionInfo {
    private String collectionType;
    private LocalDateTime initializationDate;
    private int elementsAmount;


    public CollectionInfo() {}


    public void incrementElementsAmount() {
        elementsAmount++;
    }

    public void decrementElementsAmount() {
        elementsAmount--;
    }


    @XmlElement(name = "collection_type")
    public String getCollectionType() {
        return collectionType;
    }

    @XmlElement(name = "initialization_date")
    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    @XmlElement(name = "elements_amount")
    public int getElementsAmount() {
        return elementsAmount;
    }


    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public void setInitializationDate(LocalDateTime initializationDate) {
        this.initializationDate = initializationDate;
    }

    public void setElementsAmount(int elementsAmount) {
        this.elementsAmount = elementsAmount;
    }


    @Override
    public String toString() {
        String type = String.format("Collection type: %s\n", collectionType);
        String date = String.format("Initialization date: %s\n", initializationDate);
        String amount = String.format("Elements amount: %s", elementsAmount);
        return type + date + amount;
    }
}
