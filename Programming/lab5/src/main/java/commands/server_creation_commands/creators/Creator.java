package commands.server_creation_commands.creators;

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
            defineArguments();
            CreatingObject definedObject = creatingObject;
            creatingObject = null;
            return definedObject;
        } catch (CreationException e) {
            terminal.print(e.getMessage());
            return create();
        }
    }

    protected abstract CreatingObject createNewInstance();
    protected abstract void defineArguments() throws CreationException;
}
