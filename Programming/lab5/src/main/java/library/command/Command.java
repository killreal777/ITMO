package library.command;

public abstract class Command {
    protected final ExecutionResult result;

    public Command() {
        this.result = new ExecutionResult();
    }

    public ExecutionResult getResult() {
        return result;
    }

    abstract public Command getClone();
    abstract public void setArgs(String[] args);
    abstract public void execute();
    abstract public String getHelp();
}
