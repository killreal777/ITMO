package library.command;

public abstract class ServerCommand extends Command {
    protected ServerDataManager dataManager;

    public void setDataManager(ServerDataManager dataManager) {
        this.dataManager = dataManager;
    }
}
