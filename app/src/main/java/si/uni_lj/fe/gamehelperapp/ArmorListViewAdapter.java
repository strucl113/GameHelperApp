package si.uni_lj.fe.gamehelperapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArmorListViewAdapter extends BaseAdapter {

    public ArrayList<ArmorEntry> entries;
    Activity activity;

    public ArmorListViewAdapter(Activity activity, ArrayList<ArmorEntry> entries) {
        super();
        this.activity = activity;
        this.entries = entries;
    }

    @Override
    public int getCount() {
        return this.entries.size();
    }

    @Override
    public Object getItem(int position) {
        return this.entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.armor_row, null);
        }

        TextView nameTV = convertView.findViewById(R.id.name);
        TextView armorTV = convertView.findViewById(R.id.armor);
        TextView materialTV = convertView.findViewById(R.id.material);

        ArmorEntry item = entries.get(position);
        nameTV.setText(item.name);
        armorTV.setText(Integer.toString(item.armor));
        materialTV.setText(item.material);

        return convertView;
    }
}