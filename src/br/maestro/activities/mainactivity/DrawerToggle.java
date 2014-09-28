package br.maestro.activities.mainactivity;

import android.support.v4.app.ActionBarDrawerToggle;
import android.view.View;
import br.maestro.R;

class DrawerToggle extends ActionBarDrawerToggle {

    private MainActivity mainActivity;

    DrawerToggle(MainActivity mainActivity) {
        super(mainActivity, mainActivity.mainActivityLayout, R.drawable.ic_launcher, R.string.mainactivity_draweropened, R.string.mainactivity_drawerclosed);
        this.mainActivity = mainActivity;
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);

        mainActivity.getActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);

        mainActivity.getActionBar().setTitle("#Hacklab");
    }

}