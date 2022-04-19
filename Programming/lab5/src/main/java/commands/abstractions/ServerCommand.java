package commands.abstractions;

import data.DataManager;

/**
 * Superclass for all Commands, which deal with DataManager
 */

public abstract class ServerCommand extends Command {
    protected DataManager dataManager;

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
