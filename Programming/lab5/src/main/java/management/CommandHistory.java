package management;

import commands.abstractions.Command;

class CommandHistory {
    private final Command[] history;

    CommandHistory() {
        this.history = new Command[10];
    }

    void addCommand(Command command) {
        for (int i = 0; i < 9; i++)
            history[i] = history[i + 1];
        history[9] = command;
    }

    public String toString() {
        if (history[9] == null)
            return "History is empty";
        StringBuilder out = new StringBuilder();
        for (Command command: history) {
            if (command == null)
                continue;
            out.append(command.toString()).append("\n");
        }
        out.delete(out.lastIndexOf("\n"), out.lastIndexOf("\n") + 1);
        return out.toString();
    }
}
