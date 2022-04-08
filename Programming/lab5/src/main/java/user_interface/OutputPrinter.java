package user_interface;

class OutputPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
