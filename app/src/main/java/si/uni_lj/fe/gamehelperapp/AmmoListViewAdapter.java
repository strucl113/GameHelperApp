package si.uni_lj.fe.gamehelperapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AmmoListViewAdapter extends BaseAdapter {

    public Ammo ammo;
    Activity activity;

    public AmmoListViewAdapter(Activity activity, Ammo ammo) {
        super();
        this.activity = activity;
        this.ammo = ammo;
    }

    @Override
    public int getCount() {
        return this.ammo.types.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ammo.types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ammo_row, null);
        }

        TextView nameTV = convertView.findViewById(R.id.name);
        TextView fleshDamageTV = convertView.findViewById(R.id.FleshDamage);
        TextView penetrationPowerTV = convertView.findViewById(R.id.PenetrationPower);
        TextView armorDamageTV = convertView.findViewById(R.id.ArmorDamage);

        AmmoType item = ammo.types.get(position);
        nameTV.setText(item.name);
        fleshDamageTV.setText(item.fleshDamage);
        penetrationPowerTV.setText(Integer.toString(item.penetrationPower));
        armorDamageTV.setText(Integer.toString(item.armorDamage));

        return convertView;
    }
}