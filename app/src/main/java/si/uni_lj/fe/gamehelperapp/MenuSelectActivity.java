package si.uni_lj.fe.gamehelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class MenuSelectActivity extends AppCompatActivity {

    Game g;
    private ListView lv;
    private Object[] categoryNames;

    private class ImageData {
        public int imageId;

        public ImageData(int imageId) {
            this.imageId = imageId;
        }
    }

    private class ImageAdapter implements ListAdapter {
        ArrayList<ImageData> arrayList;
        Context context;

        public ImageAdapter(Context context, ArrayList<ImageData> arrayList) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageData img = arrayList.get(position);

            if (convertView == null) {

                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.gameselect_list_item, null);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MenuSelectActivity.this,DisplayTableData.class);
                        intent.putExtra("Category",categoryNames[position].toString());

                        String itemID = String.valueOf(position);
                        Toast.makeText(getApplicationContext(), categoryNames[position].toString(), Toast.LENGTH_SHORT).show();
                        if (categoryNames[position].equals("Armor")){
                            intent.putExtra("Data",g.armor);
                            startActivity(intent);


                        }else if (categoryNames[position].equals("Guns")){

                            intent.putExtra("Data",g.gun);
                            startActivity(intent);
                        }else if (categoryNames[position].equals("Helmets")){
                        intent.putExtra("Data",g.helmets);
                        startActivity(intent);
                        }else if (categoryNames[position].equals("Ammo")){
                            intent.putExtra("Data",g.ammo);
                            startActivity(intent);
                        }else
                            throw new IllegalStateException("Unexpected value: " + categoryNames[position]);




                    }
                });

                ImageView imgView = convertView.findViewById(R.id.game_image);
                imgView.setImageResource(img.imageId);

            }
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return arrayList.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        g = (Game) getIntent().getExtras().getSerializable("Game");
        //String CatergoryText= String.valueOf(g.category);
        //System.out.println(CatergoryText);

        setContentView(R.layout.activity_catergory_menu);
        lv = findViewById(R.id.categoryMenu);
        categoryNames = g.category.toArray();
        final List<Object> ListElementsArrayList = new ArrayList<>(Arrays.asList(categoryNames));
        ArrayList<ImageData> images = new ArrayList<>();
        for (int counter = 0; counter < categoryNames.length; counter++) {
            String cName = categoryNames[counter].toString();
            images.add(new ImageData(GetCategoryImage(cName)));

        }

        ImageAdapter customAdapter = new ImageAdapter(this, images);
        lv.setAdapter(customAdapter);



    }

    public int GetCategoryImage(String name) {
        switch (name) {
            case "Ammo":
                return R.drawable.ammo;
            case "Armor":
                return R.drawable.armor;
            case "Guns":
                return R.drawable.guns;
            case "Helmets":
                return R.drawable.helmets;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }


    }

}
