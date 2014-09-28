package br.maestro.activities.mainactivity;

import java.util.ArrayList;
import java.util.List;

import br.maestro.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter implements ListAdapter {

    private List<String> list;

    public DrawerAdapter() {
        list = createList();
    }

    private ArrayList<String> createList() {
        final ArrayList<String> list = new ArrayList<String>();
        
        list.add("Hacklab");
        list.add("Casa");
        list.add("Saúde");

        return list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View defaultItem = inflater.inflate(R.layout.mainactivity_drawerlistitem_default, parent, false);
        
        TextView label = (TextView) defaultItem.findViewById(R.id.mainactivity_drawerlistitem_label);
        
        label.setText(list.get(position));
        
        return defaultItem;
    }

}
