package br.maestro.activities.mainactivity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import br.maestro.R;

public class TagListItemBuilder extends ListItemBuilder {

    private MainActivity mainActivity;

    public TagListItemBuilder(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void build(LayoutInflater inflater, final int position, List<UserObject> items, ViewGroup parent) {
        View defaultItem = inflater.inflate(R.layout.userobjectlistitem_tag, parent, false);

        TextView label = (TextView) defaultItem.findViewById(R.id.userobjectlistitem_tag_label);

        UserObject uo = items.get(position);

        label.setText(uo.text);

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
    }

    @Override
    public View getView() {
        // TODO Auto-generated method stub
        return null;
    }

}
