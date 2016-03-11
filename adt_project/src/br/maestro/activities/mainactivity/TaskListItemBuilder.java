package br.maestro.activities.mainactivity;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.maestro.R;

public class TaskListItemBuilder extends ListItemBuilder {

    private View view;

    @Override
    public void build(LayoutInflater inflater, int position, List<UserObject> items, ViewGroup parent) {
        view = inflater.inflate(R.layout.userobjectlistitem_task, parent, false);

        TextView label = (TextView) view.findViewById(R.id.userobjectlistitem_task_label);

        UserObject uo = items.get(position);

        label.setText(uo.text);
    }

    @Override
    public View getView() {
        return view;
    }

}
