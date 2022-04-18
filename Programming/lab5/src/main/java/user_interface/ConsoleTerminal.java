package user_interface;

import commands.abstractions.CommandArgumentException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
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
    public void readScript(String fileName) throws CommandArgumentException, FileNotFoundException {
        File script = new File(fileName);
        if (!script.exists() || !script.isFile())
            throw new FileNotFoundException();
        if (!script.canRead())
            throw new CommandArgumentException("недостаточно прав");
        if (executingScripts.contains(script.getAbsolutePath())) {
            throw new CommandArgumentException("обнаружена рекурсия");
        }
        executingScripts.push(script.getAbsolutePath());
        scanners.push(new Scanner(script));
    }


    @Override
    public void print(String message) {
        System.out.print(message + "\n");
    }
}
