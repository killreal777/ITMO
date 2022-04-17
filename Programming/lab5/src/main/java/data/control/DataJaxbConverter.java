package data.control;

import data.model.DataRoot;
import user_interface.Terminal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
        } catch (JAXBException e) {
            terminal.print("Данные в файле некорректны. " +
                    "Введите путь к другому файлу или пустую строку для создания новой коллекции в этом файле");
            filePath = terminal.readLine(Terminal.ReadingMode.ENTIRE)[0];
            if (filePath.equals("")) {
                return new DataRoot();
            }
            return readXml(filePath);
        }
    }

    private FileReader createFileReader(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            dataFilePath = filePath;
            return fileReader;
        } catch (FileNotFoundException | NullPointerException e) {
            terminal.print("Файл с коллекцией не найден (возможно, файл закрыт для чтения). Введите путь к другому файлу.");
            filePath = terminal.readLine(Terminal.ReadingMode.ENTIRE)[0];
            return createFileReader(filePath);
        }
    }

    private DataRoot parseData(FileReader reader) throws JAXBException {
        try {
            DataRoot dataRoot = (DataRoot) unmarshaller.unmarshal(reader);
            reader.close();
            return dataRoot;
        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }


    public void writeXml(DataRoot dataRoot) throws JAXBException, IOException {
        System.out.println(dataFilePath);
        FileWriter writer = new FileWriter(dataFilePath);
        marshaller.marshal(dataRoot, writer);
        writer.close();
    }
}
