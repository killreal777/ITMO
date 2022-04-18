package commands.server_creation_commands.creators;

import data.FieldDefinitionException;
import user_interface.Terminal;


public abstract class Creator<CreatingObject> {
    protected final Terminal terminal;
    protected CreatingObject creatingObject;

    protected Creator(Terminal terminal) {
        this.terminal = terminal;
    }

    public CreatingObject create() {
        try {
            if (creatingObject == null)
                creatingObject = createNewInstance();
            defineFields();
            CreatingObject definedObject = creatingObject;
            creatingObject = null;
            return definedObject;
        } catch (FieldDefinitionException e) {
            terminal.print(e.getMessage());
            return create();
        }
    }

    protected void checkArgumentsAmount(String[] args, int correctAmount) {
        if (args.length != correctAmount)
            throw new FieldDefinitionException(String.format("Неверное число аргументов (введено: %s, ожидалось: %s)",
                    args.length, correctAmount));
    }

    protected String formatRequirements(String requirements) {
        return "\033[3;90m(" + requirements + ")\033[0m ";
    }

    protected abstract CreatingObject createNewInstance();
    protected abstract void defineFields() throws FieldDefinitionException;
}
