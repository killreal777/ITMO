package user_interface;

public class UserTerminal implements Terminal {
    private final Reader reader;
    private final Printer printer;

    public UserTerminal() {
        this.reader = new InputReader();
        this.printer = new OutputPrinter();
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }

    @Override
    public String[] readLine(ReadingMode mode) {
        return reader.readLine(mode);
    }

    @Override
    public String[] readLine(ReadingMode mode, String invitationMessage) {
        return reader.readLine(mode, invitationMessage);
    }
}
