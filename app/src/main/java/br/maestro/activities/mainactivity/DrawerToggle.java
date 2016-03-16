package br.maestro.activities.mainactivity;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import br.maestro.R;

class DrawerToggle extends ActionBarDrawerToggle {

    private MainActivity mainActivity;

    DrawerToggle(MainActivity mainActivity) {
        super(mainActivity, mainActivity.mainActivityLayout, R.string.mainactivity_draweropened, R.string.mainactivity_drawerclosed);
        this.mainActivity = mainActivity;
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);

        mainActivity.getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);

        mainActivity.getSupportActionBar().setTitle("#Hacklab");
    }

}