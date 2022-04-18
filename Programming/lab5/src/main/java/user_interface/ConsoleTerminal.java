package user_interface;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;


public class ConsoleTerminal implements Terminal {
    private final Stack<String> executingScripts;
    private final Stack<Scanner> scanners;


    public ConsoleTerminal() {
        this.executingScripts = new Stack<>();
        this.scanners = new Stack<>();
        scanners.push(new Scanner(System.in));
    }


    @Override
    public String[] readLineSplit() {
        return readLineSplit(">>> ");
    }

    @Override
    public String[] readLineSplit(String invitationMessage) {
        return readLineEntire(invitationMessage).split("\\s+");
    }


    @Override
    public String readLineEntire() {
        return readLineEntire(">>> ");
    }

    @Override
    public String readLineEntire(String invitationMessage) {
        checkCurrentScanner();
        if (executingScripts.isEmpty())
            System.out.print(invitationMessage);
        try {
            return scanners.peek().nextLine().trim();
        } catch (NoSuchElementException e) {
            if (!executingScripts.isEmpty())                            // means that script ended incorrectly
                return readLineEntire(invitationMessage);
            System.out.println("\033[0;91m" + "Ctrl+D" + "\033[0m");    // means that user entered Ctrl+D
            System.exit(0);
            throw new AssertionError();
        }
    }

    private void checkCurrentScanner() {
        if (!executingScripts.isEmpty() && !scanners.peek().hasNext()) {
            executingScripts.pop();
            scanners.pop();
        }
    }


    @Override
    public void readScript(String fileName) throws FileNotFoundException {
        File script = new File(fileName);
        if (executingScripts.contains(script.getAbsolutePath())) {
            throw new IllegalArgumentException();
        }
        executingScripts.push(script.getAbsolutePath());
        scanners.push(new Scanner(script));

    }


    @Override
    public void print(String message) {
        System.out.print(message + "\n");
    }
}
