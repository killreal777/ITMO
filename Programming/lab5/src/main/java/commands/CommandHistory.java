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
        String out = "";
        for (int i = 0; i < 10; i++) {
            if (history[i] == null)
                break;
            if (!out.equals(""))
                out += "\n";
            out += String.format("-%2d: %s", i + 1, history[i].toString().split(" ")[0]);
        }
        return out.toString();
    }
}
