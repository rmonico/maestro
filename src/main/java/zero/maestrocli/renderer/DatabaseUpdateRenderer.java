package zero.maestrocli.renderer;

import zero.easymvc.Renderer;

public class DatabaseUpdateRenderer {

    @Renderer(path = { "--check-and-update-database" })
    public void render() {
        System.out.println("Checking database structure for updates...");
        System.out.println("Database not found! Creating it!");
        System.out.println("");
        System.out.println("Database version is 0");
        System.out.println("Application version is 0.1");
        System.out.println("");
        System.out.println("Update done. Everything is OK.");
    }
}
