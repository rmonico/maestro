package br.maestro.activities.mainactivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.maestro.R;

class UserObjectListAdapter extends BaseAdapter {
    
    private static class UserObject {
        boolean isTag;
        String text;
    }

//    private MainActivity mainActivity;
    private List<UserObject> list;

    public UserObjectListAdapter(MainActivity mainActivity) {
//        this.mainActivity = mainActivity;
        list = createList();
    }

    private List<UserObject> createList() {
        final ArrayList<UserObject> list = new ArrayList<UserObject>();
        
        list.add(createTag("#Totomote"));
        list.add(createTag("#Baixar"));
        list.add(createTask("Entrar no site do Itau"));
        list.add(createTask("Passar no mercado"));

        return list;
    }

    private UserObject createTag(String text) {
        return createUO(true, text);
    }

    private UserObject createTask(String text) {
        return createUO(false, text);
    }
    
    private UserObject createUO(boolean isTag, String text) {
        final UserObject uo = new UserObject();
        
        uo.isTag = isTag;
        uo.text = text;

        return uo;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position).text;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserObject uo = list.get(position);

        int layoutId = uo.isTag ? R.layout.userobjectlistitem_tag : R.layout.userobjectlistitem_task;
        int labelId = uo.isTag ? R.id.userobjectlistitem_tag_label : R.id.userobjectlistitem_task_label;
        
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View defaultItem = inflater.inflate(layoutId, parent, false);

        TextView label = (TextView) defaultItem.findViewById(labelId);
        
        label.setText(list.get(position).text);
        
        return defaultItem;
    }

}
