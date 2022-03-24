package client.user_interface;

import java.util.ArrayList;
import java.util.Scanner;

class InputReader implements Reader {
    private final Scanner scanner;


    InputReader () {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public String[] readLine(ReadingMode mode) {
        return readLine(mode, ">>> ");
    }


    @Override
    public String[] readLine(ReadingMode mode, String invitationMessage) {
        System.out.print(invitationMessage);
        switch (mode) {
            case SPLIT:
                return parseInputLine(scanner.nextLine());
            case ENTIRE:
                return new String[] {scanner.nextLine()};
        }
        System.err.println("Incorrect reading mode \nEmpty String array has been returned");
        return new String[0];
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
}