package main;

public class Main {
    public static void main(String[] args) {
        ExecutionManager executionManager = new ExecutionManager();
        while (true) {
            executionManager.executeNextCommand();
        }
    }
}
