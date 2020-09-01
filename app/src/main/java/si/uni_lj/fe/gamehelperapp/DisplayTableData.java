package si.uni_lj.fe.gamehelperapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    ArrayList<Ammo> ammo;

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
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return (sort) ? e1.name.compareTo(e2.name) : e2.name.compareTo(e1.name);
                        }
                    });

                    sort = !sort;
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            armorTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return (sort) ? e1.Armor - e2.Armor : e2.Armor - e1.Armor;
                        }
                    });
                    sort = !sort;
                    ((HelmetListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            addonsTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(helmets, new Comparator<Helmet>() {
                        @Override
                        public int compare(Helmet e1, Helmet e2) {
                            return (sort) ? e1.Addons.compareTo(e2.Addons) : e2.Addons.compareTo(e1.Addons);

                        }
                    });
                    sort = !sort;
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
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return (sort) ? e1.name.compareTo(e2.name) : e2.name.compareTo(e1.name);
                        }
                    });
                    sort = !sort;
                    ((ArmorListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            armorTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return (sort) ? e1.armor - e2.armor : e2.armor - e1.armor;

                        }
                    });
                    sort = !sort;
                    ((ArmorListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            materialTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(armors, new Comparator<ArmorEntry>() {
                        @Override
                        public int compare(ArmorEntry e1, ArmorEntry e2) {
                            return (sort) ? e1.material.compareTo(e2.material): e2.material.compareTo(e1.material);
                        }
                    });
                    sort = !sort;
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
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(guns, new Comparator<Gun>() {
                        @Override
                        public int compare(Gun e1, Gun e2) {
                            return (sort) ? e1.name.compareTo(e2.name) : e2.name.compareTo(e1.name);
                        }
                    });
                    sort = !sort;
                    ((GunListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            damageTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(guns, new Comparator<Gun>() {
                        @Override
                        public int compare(Gun e1, Gun e2) {
                            return (sort) ? e1.Damage - e2.Damage : e2.Damage - e1.Damage;
                        }
                    });
                    sort = !sort;
                    ((GunListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });

            typeTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    Collections.sort(guns, new Comparator<Gun>() {
                        @Override
                        public int compare(Gun e1, Gun e2) {
                            return (sort) ? e1.Type.compareTo(e2.Type) : e2.Type.compareTo(e1.Type);
                        }
                    });
                    sort = !sort;
                    ((GunListViewAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            });


        }

        else if (c.equals("Ammo")) {
            setContentView(R.layout.activity_display_data_ammo);
            Spinner dropdown = findViewById(R.id.select_a_ammo_text);

            ammo = new ArrayList<Ammo>(d.values());
            final ListView listView = findViewById(R.id.dataListView);

            dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    listView.setAdapter(new AmmoListViewAdapter(DisplayTableData.this, ammo.get(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            TextView nameTV = findViewById(R.id.firstColumn);
            TextView fleshDamageTV = findViewById(R.id.secondColumn);
            TextView penetrationPowerTV = findViewById(R.id.dreiColumn);
            TextView armorDamageTV = findViewById(R.id.cetrtiStolpec);

            nameTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    AmmoListViewAdapter adapter = (AmmoListViewAdapter) listView.getAdapter();

                    Collections.sort(adapter.ammo.types, new Comparator<AmmoType>() {
                        @Override
                        public int compare(AmmoType e1, AmmoType e2) {
                            return (sort) ? e1.name.compareTo(e2.name) : e2.name.compareTo(e1.name);
                        }
                    });

                    sort = !sort;
                    adapter.notifyDataSetChanged();
                }
            });

            fleshDamageTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    AmmoListViewAdapter adapter = (AmmoListViewAdapter) listView.getAdapter();

                    Collections.sort(adapter.ammo.types, new Comparator<AmmoType>() {
                        @Override
                        public int compare(AmmoType e1, AmmoType e2) {
                            return (sort) ? e1.fleshDamage.compareTo(e2.fleshDamage) : e2.fleshDamage.compareTo(e1.fleshDamage);

                        }
                    });
                    sort = !sort;
                    adapter.notifyDataSetChanged();
                }
            });

            penetrationPowerTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    AmmoListViewAdapter adapter = (AmmoListViewAdapter) listView.getAdapter();

                    Collections.sort(adapter.ammo.types, new Comparator<AmmoType>() {
                        @Override
                        public int compare(AmmoType e1, AmmoType e2) {
                            return (sort) ? e1.penetrationPower - e2.penetrationPower : e2.penetrationPower - e1.penetrationPower;
                        }
                    });
                    sort = !sort;
                    adapter.notifyDataSetChanged();
                }
            });

            armorDamageTV.setOnClickListener(new View.OnClickListener() {
                private boolean sort = false;
                @Override
                public void onClick(View v) {
                    AmmoListViewAdapter adapter = (AmmoListViewAdapter) listView.getAdapter();

                    Collections.sort(adapter.ammo.types, new Comparator<AmmoType>() {
                        @Override
                        public int compare(AmmoType e1, AmmoType e2) {
                            return (sort) ? e1.armorDamage - e2.armorDamage : e2.armorDamage - e1.armorDamage;
                        }
                    });
                    sort = !sort;
                    adapter.notifyDataSetChanged();
                }
            });

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
