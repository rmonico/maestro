package br.maestro.activities.mainactivity;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ListItemBuilder {

    public abstract void build(LayoutInflater inflater, int position, List<UserObject> items, ViewGroup parent);

    public abstract View getView();

}
