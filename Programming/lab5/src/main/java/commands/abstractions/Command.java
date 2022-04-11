package commands.abstractions;

public abstract class Command {
    protected String result;

    public Command() {
        this.result = "";
    }

    public String getResult() {
        return result;
    }

    abstract public Command getClone();
    abstract public void setArgs(String[] args);
    abstract public void execute();
    abstract public String getHelp();
}
