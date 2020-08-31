package si.uni_lj.fe.gamehelperapp;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {

    public ArrayList<Game> productList;
    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<Game> productList) {
        super();
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView firstRow;
        TextView secondRow;
        TextView ThirdRow;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.firstRow = (TextView) convertView.findViewById(R.id.firstRow);
            holder.secondRow = (TextView) convertView.findViewById(R.id.secondRow);
            holder.ThirdRow = (TextView) convertView.findViewById(R.id.thirdRow);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Game item = productList.get(position);
        holder.firstRow.setText(item.name.toString());
        holder.secondRow.setText(item.ammo.toString());
        holder.ThirdRow.setText(item.gun.toString());

        return convertView;
    }
}