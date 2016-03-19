package br.maestro.activities.mainactivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import br.maestro.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout drawerFrame;
    ListView drawerList;
    DrawerLayout mainActivityLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView userObjectList;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainactivity_toolbar);
        setSupportActionBar(toolbar);

        drawerFrame = (RelativeLayout) findViewById(R.id.mainactivity_drawerframe);
        drawerList = (ListView) findViewById(R.id.mainactivity_drawerlist);
        mainActivityLayout = (DrawerLayout) findViewById(R.id.mainactivity);
        userObjectList = (ListView) findViewById(R.id.mainactivity_userobjectlist);

        drawerList.setItemsCanFocus(true);
    }

    private void assignEventHandlers() {
        drawerToggle = new DrawerToggle(this);

        mainActivityLayout.setDrawerListener(drawerToggle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                mainActivityLayout.closeDrawer(drawerFrame);
            }
        });
    }

    private void setDrawerListAdapter() {
        List<UserObject> items = UserObject.createItemList(UserObject.createTag("#Hacklab"), UserObject.createTag("#Casa"), UserObject.createTag("#Saúde"));

        UserObjectListAdapter adapter = new UserObjectListAdapter(this, items);
        drawerList.setAdapter(adapter);
    }

    private void setUserObjectListAdapter() {
        List<UserObject> items = UserObject.createItemList(UserObject.createTag("#Totomote"), UserObject.createTag("#Baixar"), UserObject.createTask("Entrar no site do Itau"), UserObject.createTask("Passar no mercado"));

        ListAdapter adapter = new UserObjectListAdapter(this, items);
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

    public void onDrawerListItemBulletClick(final int itemPosition) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        String[] items = new String[] { "Renomear", "Configurar", "Excluir" };

        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(DialogInterface origin, int option) {
                String text = String.format(Locale.getDefault(), "Opção %d do item %d clicado.", option, itemPosition);

                Toast t = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);

                t.show();
            }

        };

        b.setTitle("#Hacklab");

        // b.setIcon(icon);

        b.setItems(items, listener);

        b.show();
    }

}
