package zero.maestrocli;

import zero.easymvc.ormlite.factory.ApplicationFactory;
import zero.utils.test.AbstractEasyMVCOrmliteTest;

public class MaestroTest extends AbstractEasyMVCOrmliteTest {

    public MaestroTest() {
        this((String[]) null);
    }

    public MaestroTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected ApplicationFactory createApplicationFactory() {
        return new MaestroTestApplicationFactory();
    }

    @Override
    protected ApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestroTestApplicationFactory(databaseVersion);
    }

}
