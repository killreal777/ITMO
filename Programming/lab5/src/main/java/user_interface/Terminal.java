package user_interface;

import java.io.FileNotFoundException;

public interface Terminal {
    String[] readLineSplit();
    String[] readLineSplit(String invitationMessage);
    String readLineEntire();
    String readLineEntire(String invitationMessage);
    void readScript(String fileName) throws FileNotFoundException;
    void print(String message);
}
