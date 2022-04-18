package data.control;

import data.FieldDefinitionException;
import data.model.DataRoot;
import data.model.Organization;
import user_interface.Terminal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DataJaxbConverter {
    private final Terminal terminal;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String dataFilePath;


    public DataJaxbConverter(Terminal terminal) {
        this.terminal = terminal;
        try {
            JAXBContext context = JAXBContext.newInstance(DataRoot.class);
            this.marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public DataRoot readXml(String filePath) {
        try {
            FileReader fileReader = createFileReader(filePath);
            return parseData(fileReader);
        } catch (JAXBException | FieldDefinitionException e) {
            return handleIncorrectData(e.getMessage());
        }
    }

    private DataRoot handleIncorrectData(String exceptionMessage) {
        String message = "Данные в файле некорректны: ";
        if (exceptionMessage == null)
            message += "некорректная структура XML";
        else
            message += exceptionMessage;
        message += "\nВведите путь к другому файлу или пустую строку для создания новой коллекции в этом файле: ";
        String newFilePath = terminal.readLineEntire("\033[0;91m" + message + "\033[0m");
        if (newFilePath.equals("")) {
            return new DataRoot();
        }
        return readXml(newFilePath);
    }

    private FileReader createFileReader(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            dataFilePath = filePath;
            return fileReader;
        } catch (FileNotFoundException | NullPointerException e) {
            String message = "Файл с коллекцией не найден (возможно, файл закрыт для чтения). Введите путь к другому файлу: ";
            filePath = terminal.readLineEntire("\033[0;91m" + message + "\033[0m");
            return createFileReader(filePath);
        }
    }

    private DataRoot parseData(FileReader reader) throws JAXBException, FieldDefinitionException {
        try {
            DataRoot dataRoot = (DataRoot) unmarshaller.unmarshal(reader);
            checkIdUniqueness(dataRoot);
            reader.close();
            return dataRoot;
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    private void checkIdUniqueness(DataRoot dataRoot) throws FieldDefinitionException {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Organization org : dataRoot.getCollectionRoot().getCollection()) {
            if (ids.contains(org.getId()))
                throw new FieldDefinitionException("Обнаружен неуникальный ID: " + org.getId());
            else
                ids.add(org.getId());
        }
    }


    public void writeXml(DataRoot dataRoot) throws JAXBException, IOException {
        FileWriter writer = new FileWriter(dataFilePath);
        marshaller.marshal(dataRoot, writer);
        writer.close();
    }
}
