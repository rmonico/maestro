package zero.maestrocli;

import zero.easymvc.ormlite.DatabaseVersion;
import zero.utils.test.DBUnitUpdater;
import zero.utils.test.TestApplicationFactory;

import com.j256.ormlite.support.ConnectionSource;

public class MaestrocliTestApplicationFactory extends MaestrocliApplicationFactory implements TestApplicationFactory {

    private String[] datasetFileNames;

    public MaestrocliTestApplicationFactory() {
        super(MaestrocliApplicationFactory.BASENAME + "_test");

    }

    @Override
    public void setDatabaseFileNames(String[] datasetFileNames) {
        this.datasetFileNames = datasetFileNames;
    }

    @Override
    protected DatabaseVersion createDatabaseVersion() throws Exception {
        ConnectionSource connection = connectionManager.getConnection();

        MaestrocliTestUpdater previousVersion = new MaestrocliTestUpdater(connection, super.createDatabaseVersion());

        return new DBUnitUpdater(connection, previousVersion, datasetFileNames);
    }

}
