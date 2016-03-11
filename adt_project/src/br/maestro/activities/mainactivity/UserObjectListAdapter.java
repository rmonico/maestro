package br.maestro.activities.mainactivity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class UserObjectListAdapter extends BaseAdapter {

    private List<UserObject> items;
    private TagListItemBuilder tagListItemBuilder;
    private TaskListItemBuilder taskListItemBuilder;

    public UserObjectListAdapter(MainActivity mainActivity, final List<UserObject> items) {
        this.items = items;

        tagListItemBuilder = new TagListItemBuilder(mainActivity);

        taskListItemBuilder = new TaskListItemBuilder();
    }

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
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ListItemBuilder builder = getBuilderFor(items.get(position));

        builder.build(inflater, position, items, parent);

        return builder.getView();
    }

    private ListItemBuilder getBuilderFor(UserObject userObject) {
        return userObject.isTag ? tagListItemBuilder : taskListItemBuilder;
    }

}
