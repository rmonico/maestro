package zero.maestrocli;

import zero.utils.test.AbstractEasyMVCOrmliteTest;
import zero.utils.test.TestApplicationFactory;

public class MaestroTest extends AbstractEasyMVCOrmliteTest {

    public MaestroTest() {
        this((String[]) null);
    }

    public MaestroTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected TestApplicationFactory createApplicationFactory() {
        return new MaestroTestApplicationFactory();
    }

    @Override
    protected TestApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestroTestApplicationFactory(databaseVersion);
    }

}
