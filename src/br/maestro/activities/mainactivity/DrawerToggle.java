package br.maestro.activities.mainactivity;

import android.support.v4.app.ActionBarDrawerToggle;
import br.maestro.R;

class DrawerToggle extends ActionBarDrawerToggle {

    DrawerToggle(MainActivity mainActivity) {
        super(mainActivity, mainActivity.mainActivityLayout, R.drawable.ic_launcher, R.string.mainactivity_draweropened, R.string.mainactivity_drawerclosed);
    }

}