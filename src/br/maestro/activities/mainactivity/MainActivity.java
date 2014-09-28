package br.maestro.activities.mainactivity;

import br.maestro.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView drawerList;
    DrawerLayout mainActivityLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        initializeControls();

        assignEventHandlers();

        setDrawerAdapter();
    }

    private void initializeControls() {
        drawerList = (ListView) findViewById(R.id.mainactivity_drawerlist);
        mainActivityLayout = (DrawerLayout) findViewById(R.id.mainactivity);
    }

    private void assignEventHandlers() {
        drawerToggle = new DrawerToggle(this);

        mainActivityLayout.setDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void setDrawerAdapter() {
        ListAdapter adapter = new DrawerAdapter();
        drawerList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
