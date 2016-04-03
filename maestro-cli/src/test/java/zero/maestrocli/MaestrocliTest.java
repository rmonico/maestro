package zero.maestrocli;

import zero.utils.test.AbstractEasyMVCOrmliteTest;
import zero.utils.test.TestApplicationFactory;

public class MaestrocliTest extends AbstractEasyMVCOrmliteTest {

    public MaestrocliTest() {
        this((String[]) null);
    }

    public MaestrocliTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected TestApplicationFactory createApplicationFactory() {
        return new MaestrocliTestApplicationFactory();
    }

    @Override
    protected TestApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestrocliTestApplicationFactory(databaseVersion);
    }

}
