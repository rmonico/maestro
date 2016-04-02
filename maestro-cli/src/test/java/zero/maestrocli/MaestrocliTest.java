package zero.maestrocli;

import zero.utils.test.AbstractEasyMVCOrmliteTest;
import zero.utils.test.IApplicationFactory;

public class MaestrocliTest extends AbstractEasyMVCOrmliteTest {

    public MaestrocliTest() {
        this((String[]) null);
    }

    public MaestrocliTest(String... defaultDBUnitDatasetFileNames) {
        super("%%HOME%%/.config/maestro_test", defaultDBUnitDatasetFileNames);
    }

    @Override
    protected IApplicationFactory createApplicationFactory() {
        return new MaestrocliTestApplicationFactory();
    }

    @Override
    protected IApplicationFactory createApplicationFactory(int databaseVersion) {
        return new MaestrocliTestApplicationFactory(databaseVersion);
    }

}
