package commands.abstractions;

public class ExecutionResult {
    private String result;

    public ExecutionResult() {
        this.result = "";
    }

    public void write(String result) {
        this.result += result;
        this.result += '\n';
    }

    @Override
    public String toString() {
        return result;
    }
}
