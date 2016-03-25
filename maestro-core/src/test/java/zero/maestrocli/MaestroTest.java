package zero.maestrocli;

import zero.easymvc.ormlite.factory.AbstractApplicationFactory;
import zero.utils.test.AbstractEasyMVCOrmliteTest;

public class MaestroTest extends AbstractEasyMVCOrmliteTest {

    public MaestroTest() {
        this((String[]) null);
    }

    public MaestroTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected AbstractApplicationFactory createApplicationFactory() {
        return new MaestroTestApplicationFactory();
    }

    @Override
    protected AbstractApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestroTestApplicationFactory(databaseVersion);
    }

}
