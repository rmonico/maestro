package zero.maestrocli.app;

import java.sql.SQLException;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.dao.MetaInfDao;
import zero.easymvc.ormlite.model.MetaInf;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class DatabaseUpdateCommand {

    @Dependency
    private ConnectionSource source;

    @Dependency
    private MetaInfDao dao;

    @Dependency
    @Bean
    private DatabaseUpdater updater;

    @Bean
    private int oldDatabaseVersion;

    @CommandHandler(path = { "--check-and-update-database" })
    public void run() throws Exception {
        oldDatabaseVersion = getDatabaseVersion();

        updater.update(oldDatabaseVersion);
    }

    private int getDatabaseVersion() throws SQLException {
        if (!metainfTableExists())
            return -1;

        return dao.getDatabaseVersion();
    }

    private boolean metainfTableExists() throws SQLException {
        DatabaseConnection dbConnection = source.getReadWriteConnection();

        return dbConnection.isTableExists(MetaInf.TABLE_NAME);
    }

}
