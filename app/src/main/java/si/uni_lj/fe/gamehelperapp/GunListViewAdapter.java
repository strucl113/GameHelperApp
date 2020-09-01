package si.uni_lj.fe.gamehelperapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GunListViewAdapter extends BaseAdapter {

    public ArrayList<Gun> entries;
    Activity activity;

    public GunListViewAdapter(Activity activity, ArrayList<Gun> entries) {
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
            convertView = inflater.inflate(R.layout.gun_row, null);
        }

        TextView nameTV = convertView.findViewById(R.id.name);
        TextView damageTV = convertView.findViewById(R.id.damage);
        TextView typeTV = convertView.findViewById(R.id.type);

        Gun item = entries.get(position);
        nameTV.setText(item.name);
        damageTV.setText(Integer.toString(item.Damage));
        typeTV.setText(item.Type);

        return convertView;
    }
}