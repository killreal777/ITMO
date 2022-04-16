package commands;

import commands.abstractions.Command;

public class CommandHistory {
    private final Command[] history;

    CommandHistory() {
        this.history = new Command[10];
    }

    public void addCommand(Command command) {
        for (int i = 9; i > 0; i--)
            history[i] = history[i - 1];
        history[0] = command;
    }

    public String toString() {
        if (history[0] == null)
            return "History is empty";
        StringBuilder out = new StringBuilder("HISTORY");
        for (int i = 0; i < 10; i++) {
            if (history[i] == null)
                break;
            out.append(String.format("\n-%2d: %s", i + 1, history[i]));
        }
        return out.toString();
    }
}
