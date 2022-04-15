package commands.abstractions;

import data.control.DataManager;

public abstract class ServerCommand extends Command {
    protected DataManager dataManager;

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
