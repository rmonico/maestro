package br.maestro.activities.mainactivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.IOException;
import java.sql.SQLException;

import br.maestro.MaestroAndroidApplicationFactory;
import ch.qos.logback.classic.Logger;
import zero.easymvc.EasyMVC;
import zero.easymvc.EasyMVCException;
import zero.easymvc.StringArrayCommand;
import zero.easymvc.ormlite.factory.AbstractApplicationFactory;
import zero.environment.ApplicationPropertyKeys;
import zero.environment.Environment;

public class TagDrawerListAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void loadData() throws IOException, SQLException, EasyMVCException {
        AbstractApplicationFactory factory = new MaestroAndroidApplicationFactory();

        Environment.get().setProperty("MAESTRO_HOME", "/data/data/br.maestro/");
        Environment.get().setProperty(ApplicationPropertyKeys.JDBC_DRIVER_CLASS_KEY, "org.sqlite.JDBC");

        factory.makeProperties();

        Logger logger = factory.makeLogger();

        String jdbcUrl = Environment.get().getProperty(ApplicationPropertyKeys.JDBC_URL_KEY);

        Log.d("BOOT", jdbcUrl == null ? "<null>" : jdbcUrl);

        String appHomeFolder = Environment.get().getProperty(ApplicationPropertyKeys.APP_HOME_PROPERTY_KEY);

        Log.d("BOOT", appHomeFolder == null ? "<null>" : appHomeFolder);

        factory.makeConnectionManager();

        factory.makeDaoManager();

        EasyMVC controller = factory.makeController();

        controller.run(new StringArrayCommand("tag", "ls"));
    }
}
