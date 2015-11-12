package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.easymvc.ormlite.DatabaseUpdater;

public class DatabaseUpdateRenderer {

    private DatabaseUpdater updater;
    private int oldDatabaseVersion;

    @Renderer(path = { "--check-and-update-database" })
    public void render() {
        System.out.println("Checking database structure for updates...");

        makeUpdateActionMessage();

        makeDatabaseStatusMessage();
    }

    private void makeUpdateActionMessage() {
        String message;
        if (oldDatabaseVersion == -1) {
            message = "Database not found! Creating it!";
        } else {
            message = String.format("Database on version %d found. Updating it to version %d", oldDatabaseVersion, updater.getUpdaterVersion());
        }

        System.out.println(message);
        System.out.println("");
    }

    private void makeDatabaseStatusMessage() {
        String currentDatabaseVersionMessage = String.format("Database version is %d", updater.getUpdaterVersion());
        System.out.println(currentDatabaseVersionMessage);

        int applicationMajorVersion = updater.getApplicationMajorVersion();
        int applicationMinorVersion = updater.getApplicationMinorVersion();
        String applicationVersionMessage = String.format("Application version is %d.%d", applicationMajorVersion, applicationMinorVersion);

        System.out.println(applicationVersionMessage);
        System.out.println("");
        System.out.println("Update done. Everything is OK.");
    }
}
