package zero.maestrocli;

import zero.easymvc.ormlite.factory.ApplicationFactory;
import zero.utils.test.AbstractEasyMVCOrmliteTest;

public class MaestrocliTest extends AbstractEasyMVCOrmliteTest {

    public MaestrocliTest() {
        this((String[]) null);
    }

    public MaestrocliTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected ApplicationFactory createApplicationFactory() {
        return new MaestrocliTestApplicationFactory();
    }

    @Override
    protected ApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestrocliTestApplicationFactory(databaseVersion);
    }

}
