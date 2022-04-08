package exceptions_handling.correction_logic;

import user_interface.Terminal;

class AttemptCounter {
    private final Terminal terminal;
    private int attempts;

    AttemptCounter(Terminal terminal) {
        this.terminal = terminal;
        this.attempts = 5;
    }

    void decrementAttempts() {
        attempts--;
        switch (attempts) {
            case 3:
                terminal.print("Осталось попыток: 3");
                break;
            case 2:
                terminal.print("Осталось попыток: 2");
                break;
            case 1:
                terminal.print("Осталось попыток: 1\nВ случае неудачи программа завершит свою работу");
                break;
            case 0:
                System.exit(0);
        }
    }
}
