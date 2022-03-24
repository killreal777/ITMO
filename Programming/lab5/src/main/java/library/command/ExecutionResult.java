package library.command;

public class ExecutionResult {
    private String result;

    public ExecutionResult() {
        this.result = "";
    }

    public void write(String result) {
        if (result != "")
            this.result += '\n';
        this.result += result;
    }

    @Override
    public String toString() {
        return result;
    }
}
