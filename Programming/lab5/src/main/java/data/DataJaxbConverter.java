package data;

import model.FieldDefinitionException;
import model.DataRoot;
import app.Terminal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class converting collection of Organizations between the XML and java object model
 */

public class DataJaxbConverter {
    private final Terminal terminal;
    private final DataFile dataFile;
    private final DataSpecialValidator validator;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;


    public DataJaxbConverter(Terminal terminal) {
        this.terminal = terminal;
        this.dataFile = new DataFile(terminal);
        this.validator = new DataSpecialValidator();
        initJaxbObjects();
    }

    private void initJaxbObjects() {
        try {
            JAXBContext context = JAXBContext.newInstance(DataRoot.class);
            this.marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Reads XML form data file and converts it to the object model
     */
    public DataRoot readXml() throws IOException {
        try {
            FileReader reader = dataFile.createReader();
            DataRoot dataRoot = (DataRoot) unmarshaller.unmarshal(reader);
            reader.close();
            validator.validate(dataRoot.getCollectionRoot().getCollection());
            return dataRoot;
        } catch (JAXBException e) {
            return handleIncorrectDataException("некорректная структура XML");
        } catch (FieldDefinitionException e) {
            return handleIncorrectDataException(e.getMessage());
        }
    }

    private DataRoot handleIncorrectDataException(String message) throws IOException {
        message = "Данные в файле некорректны: " + message;
        String options = "Введите путь к другому файлу или пустую строку для создания коллекции в этом файле: ";
        String filePath = reenter(message, options);
        if (filePath.equals(""))
            return new DataRoot();
        dataFile.setFileByPath(filePath);
        return readXml();
    }


    /**
     * Converts object model to the XML structure and saves it to the data file
     *
     * @param dataRoot Root class of object model
     */
    public void writeXml(DataRoot dataRoot) throws JAXBException, FileNotFoundException {
        try {
            FileWriter writer = dataFile.createWriter();
            marshaller.marshal(dataRoot, writer);
            writer.close();
        } catch (IOException e) {
            handleSavingException(dataRoot);
        }
    }

    private void handleSavingException(DataRoot dataRoot) throws JAXBException, FileNotFoundException {
        String message = "Невозмножно сохранить коллекцию в файле: недостаточно прав ";
        String options = "Введите путь к другому файлу (для остановки этого процесса ввдеите путь к текущему файлу)" +
                "или пустую строку для отмены: ";
        String input = reenter(message, options);
        if (input.equals(""))
            throw new FileNotFoundException();
        dataFile.setFileByPath(input);
        writeXml(dataRoot);
    }


    private String reenter(String message, String options) {
        String invitationMessage = "\033[0;91m" + message + "\n" + options + "\033[0m";     // highlight red
        return terminal.readLineEntire(invitationMessage);
    }
}
