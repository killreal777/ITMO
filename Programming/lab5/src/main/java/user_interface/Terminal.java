package user_interface;

import java.io.FileNotFoundException;

public interface Terminal {
    String[] readLine(ReadingMode mode);
    String[] readLine(ReadingMode mode, String invitationMessage);
    void readFile(String fileName) throws FileNotFoundException;
    void print(String message);

    enum ReadingMode {
        SPLIT, ENTIRE
    }
}
