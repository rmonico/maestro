package br.maestro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        initializeControls();

        setDrawerAdapter();
    }

    private void initializeControls() {
        drawerList = (ListView) findViewById(R.id.mainactivity_drawerlist);
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

}
