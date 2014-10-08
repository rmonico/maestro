package br.maestro.activities.mainactivity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.maestro.R;

class UserObjectListAdapter extends BaseAdapter {

    // private MainActivity mainActivity;
    private List<UserObject> items;

    public UserObjectListAdapter(MainActivity mainActivity, final List<UserObject> items) {
        // this.mainActivity = mainActivity;
        this.items = items;
    }

    // private List<UserObject> createList() {
    // final ArrayList<UserObject> list = new ArrayList<UserObject>();
    //
    // list.add(createTag("#Totomote"));
    // list.add(createTag("#Baixar"));
    // list.add(createTask("Entrar no site do Itau"));
    // list.add(createTask("Passar no mercado"));
    //
    // return list;
    // }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position).text;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserObject uo = items.get(position);

        int layoutId = uo.isTag ? R.layout.userobjectlistitem_tag : R.layout.userobjectlistitem_task;
        int labelId = uo.isTag ? R.id.userobjectlistitem_tag_label : R.id.userobjectlistitem_task_label;

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View defaultItem = inflater.inflate(layoutId, parent, false);

        TextView label = (TextView) defaultItem.findViewById(labelId);

        label.setText(items.get(position).text);

        return defaultItem;
    }

}
