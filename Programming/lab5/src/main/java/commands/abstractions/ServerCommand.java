package commands.abstractions;

import management.DataManager;

public abstract class ServerCommand extends Command {
    protected DataManager dataManager;

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
