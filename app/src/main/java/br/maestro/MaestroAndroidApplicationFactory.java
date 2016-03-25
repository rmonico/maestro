package br.maestro;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.maestro.renderers.DrawerListRenderer;
import zero.easymvc.ormlite.ConnectionManager;
import zero.maestro.app.MaestroApplicationFactory;

public class MaestroAndroidApplicationFactory extends MaestroApplicationFactory {

    @Override
    public zero.easymvc.ormlite.DatabaseUpdater getDatabaseUpdater() {
        return super.getDatabaseUpdater();
    }

    @Override
    protected void createRendererList(List<Class<?>> renderers) {
        super.createRendererList(renderers);

        renderers.add(DrawerListRenderer.class);
    }

    @Override
    protected ConnectionManager createConnectionManager() throws SQLException {
        return new ConnectionManager() {
            public ConnectionSource connectionSource;

            @Override
            public ConnectionSource getConnection() {
                if (connectionSource == null) {
                    SQLiteDatabase x = SQLiteDatabase.openOrCreateDatabase("/data/data/br.maestro/maestro_database.sqlite", null);

                    connectionSource = new AndroidConnectionSource(x);
                }

                return connectionSource;
            }
        };
    }
}
