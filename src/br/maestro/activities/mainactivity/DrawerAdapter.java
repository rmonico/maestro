package br.maestro.activities.mainactivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import br.maestro.R;

class DrawerAdapter extends BaseAdapter implements ListAdapter {

    private List<String> list;
    private MainActivity mainActivity;

    public DrawerAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        list = createList();
    }

    private ArrayList<String> createList() {
        final ArrayList<String> list = new ArrayList<String>();

        list.add("#Hacklab");
        list.add("#Casa");
        list.add("#Saúde");

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View defaultItem = inflater.inflate(R.layout.userobjectlistitem_tag, parent, false);

        TextView label = (TextView) defaultItem.findViewById(R.id.userobjectlistitem_tag_label);

        label.setText(list.get(position));

        label.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = mainActivity;
                CharSequence text = "Label onClick";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        TextView bullet = (TextView) defaultItem.findViewById(R.id.userobjectlistitem_tag_bullet);

        bullet.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                mainActivity.onDrawerListItemBulletClick(position);
            }
        });

        return defaultItem;
    }

}
