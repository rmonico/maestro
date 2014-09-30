package br.maestro.activities.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import br.maestro.R;

public class MainActivity extends Activity {

    ListView drawerList;
    DrawerLayout mainActivityLayout;
    ActionBarDrawerToggle drawerToggle;
    private ListView userObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        initializeControls();

        assignEventHandlers();

        setDrawerListAdapter();

        setUserObjectListAdapter();
    }

    private void initializeControls() {
        drawerList = (ListView) findViewById(R.id.mainactivity_drawerlist);
        mainActivityLayout = (DrawerLayout) findViewById(R.id.mainactivity);
        userObjectList = (ListView) findViewById(R.id.mainactivity_userobjectlist);
    }

    private void assignEventHandlers() {
        drawerToggle = new DrawerToggle(this);

        mainActivityLayout.setDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        drawerList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                mainActivityLayout.closeDrawer(drawerList);
            }
        });
    }

    private void setDrawerListAdapter() {
        ListAdapter adapter = new DrawerAdapter();
        drawerList.setAdapter(adapter);
    }

    private void setUserObjectListAdapter() {
        ListAdapter adapter = new UserObjectListAdapter(this);
        userObjectList.setAdapter(adapter);
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
