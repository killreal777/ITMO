package user_interface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ConsoleTerminal implements Terminal {
    private Scanner scanner;
    private boolean fileReadingMode;


    public ConsoleTerminal() {
        this.scanner = new Scanner(System.in);
        this.fileReadingMode = false;
    }


    @Override
    public String[] readLine(ReadingMode mode) {
        return readLine(mode, ">>> ");
    }

    @Override
    public String[] readLine(ReadingMode mode, String invitationMessage) {
        checkReadingMode(invitationMessage);
        try {
            switch (mode) {
                case SPLIT: return parseInputLine(scanner.nextLine());
                case ENTIRE: return new String[]{scanner.nextLine()};
            }
            throw new AssertionError();
        } catch (NoSuchElementException e) {
            System.exit(0);
            throw new AssertionError();
        }
    }

    private void checkReadingMode(String invitationMessage) {
        if (fileReadingMode && !scanner.hasNext()) {
            this.scanner = new Scanner(System.in);
            fileReadingMode = false;
        }
        if (!fileReadingMode)
            System.out.print(invitationMessage);
    }

    private String[] parseInputLine(String inputLine) {
        String[] spaceSplintedLine = inputLine.split(" ");
        ArrayList<String> cleanedInputLine = new ArrayList<>();
        for (String s : spaceSplintedLine) {
            if (s.length() > 0)
                cleanedInputLine.add(s);
        }
        String[] parsedInputLine = new String[cleanedInputLine.size()];
        return cleanedInputLine.toArray(parsedInputLine);
    }


    @Override
    public void readFile(String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new FileReader(fileName));
        fileReadingMode = true;
    }


    @Override
    public void print(String message) {
        System.out.print(message + "\n");
    }
}
