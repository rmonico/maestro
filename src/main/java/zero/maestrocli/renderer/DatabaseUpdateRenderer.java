package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.easymvc.ormlite.DatabaseUpdater;

public class DatabaseUpdateRenderer {

    private DatabaseUpdater updater;
    private int oldDatabaseVersion;

    @Renderer(path = { "--check-and-update-database" })
    public void render() {
        int applicationMajorVersion = updater.getApplicationMajorVersion();
        int applicationMinorVersion = updater.getApplicationMinorVersion();

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
        System.out.println("Database version is 0");
        System.out.println("Application version is 0.1");
        System.out.println("");
        System.out.println("Update done. Everything is OK.");
    }
}
