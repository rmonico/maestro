package zero.maestrocli;

import zero.utils.test.AbstractEasyMVCOrmliteTest;
import zero.utils.test.IApplicationFactory;

public class MaestroTest extends AbstractEasyMVCOrmliteTest {

    public MaestroTest() {
        this((String[]) null);
    }

    public MaestroTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected IApplicationFactory createApplicationFactory() {
        return new MaestroTestApplicationFactory();
    }

    @Override
    protected IApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestroTestApplicationFactory(databaseVersion);
    }

}
