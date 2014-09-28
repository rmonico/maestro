package br.maestro;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView drawerList;
    private DrawerLayout mainActivityLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        initializeControls();

        setDrawerAdapter();
    }

    private void initializeControls() {
        drawerList = (ListView) findViewById(R.id.mainactivity_drawerlist);
        mainActivityLayout = (DrawerLayout) findViewById(R.id.mainactivity);

        drawerToggle = new ActionBarDrawerToggle(this, mainActivityLayout, R.drawable.ic_launcher, R.string.mainactivity_draweropened, R.string.mainactivity_drawerclosed);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void setDrawerAdapter() {
        ListAdapter adapter = new DrawerAdapter();
        drawerList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
