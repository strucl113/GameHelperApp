package si.uni_lj.fe.gamehelperapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DisplayTableData extends AppCompatActivity {
    HashMap d;
    String c;
    String[] items;

    ArrayList<ArmorEntry> armors;
    ArrayList<Helmet> helmets;
    ArrayList<Gun> guns;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        d = (HashMap) getIntent().getExtras().getSerializable("Data");
        c = (String) getIntent().getExtras().getSerializable("Category");

        if (c.equals("Helmets")) {
            helmets = new ArrayList<Helmet>(d.values());
            setContentView(R.layout.activity_display_data);
            Button text = findViewById(R.id.display_text);
            text.setText("Helmets");
            TextView nameTV = findViewById(R.id.firstColumn);
            nameTV.setText("Name");
            TextView armorTV = findViewById(R.id.secondColumn);
            armorTV.setText("Armor");
            TextView addonsTV = findViewById(R.id.thirdColumn);
            addonsTV.setText("Addons");

            final ListView listView = findViewById(R.id.dataListView);
            listView.setAdapter(new HelmetListViewAdapter(this, helmets));

            nameTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return e1.name.compareTo(e2.name);
                        }
                    });
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            armorTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return e1.Armor - e2.Armor;
                        }
                    });
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            addonsTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return e1.Addons.compareTo(e2.Addons);
                        }
                    });
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });


        }


        else if (c.equals("Armor")) {
            armors = new ArrayList<ArmorEntry>(d.values());

            setContentView(R.layout.activity_display_data);
            Button text = findViewById(R.id.display_text);
            text.setText("Armors");
            TextView nameTV = findViewById(R.id.firstColumn);
            nameTV.setText("Name");
            final TextView armorTV = findViewById(R.id.secondColumn);
            armorTV.setText("Armor");
            TextView materialTV = findViewById(R.id.thirdColumn);
            materialTV.setText("Material");

            final ListView listView = findViewById(R.id.dataListView);
            listView.setAdapter(new ArmorListViewAdapter(this, armors));

            nameTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return e1.name.compareTo(e2.name);
                        }
                    });
                    ((ArmorListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            armorTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return e1.armor - e2.armor;
                        }
                    });
                    ((ArmorListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            materialTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return e1.material.compareTo(e2.material);
                        }
                    });
                    ((ArmorListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });


        }

        else if (c.equals("Guns")) {
            guns = new ArrayList<Gun>(d.values());


            setContentView(R.layout.activity_display_data);
            Button text = findViewById(R.id.display_text);
            text.setText("Guns");
            TextView nameTV = findViewById(R.id.firstColumn);
            nameTV.setText("Name");
            TextView damageTV = findViewById(R.id.secondColumn);
            damageTV.setText("Damage");
            TextView typeTV = findViewById(R.id.thirdColumn);
            typeTV.setText("Type");

            final ListView listView = findViewById(R.id.dataListView);
            listView.setAdapter(new GunListViewAdapter(this, guns));

            nameTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return e1.name.compareTo(e2.name);
                        }
                    });
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            damageTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(guns, new Comparator<Gun>() {
                        @Override
                        public int compare(Gun e1, Gun e2) {
                            return e1.Damage - e2.Damage;
                        }
                    });
                    ((GunListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            typeTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(guns, new Comparator<Gun>() {
                        @Override
                        public int compare(Gun e1, Gun e2) {
                            return e1.Type.compareTo(e2.Type);
                        }
                    });
                    ((GunListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });


        } else if (c.equals("Ammo")) {
            setContentView(R.layout.activity_display_data_ammo);
            Spinner dropdown = findViewById(R.id.select_a_ammo_text);

            Object[] imena = d.keySet().toArray();
            items = new String[imena.length];
            //for zanka za sprehod čez HashMap
            for (int i = 0; i < imena.length; i++) {
                items[i] = imena[i].toString();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
            dropdown.setAdapter(adapter);


        } else {
            throw new IllegalStateException("Unexpected value: " + c.toString());
        }


    }


}
