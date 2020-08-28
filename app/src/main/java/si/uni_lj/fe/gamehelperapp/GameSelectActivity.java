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

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameSelectActivity extends AppCompatActivity {
    HashMap<String, Game> allData = new HashMap<>();
    private ListView lv;
 //   private ArrayList<HashMap<String, String>> gameList = new ArrayList<>();
    private Object[] gameNames;

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

                        Game g = allData.get(gameNames[position]);

                        String itemID = String.valueOf(position);
                        Toast.makeText(getApplicationContext(), itemID, Toast.LENGTH_SHORT).show();
                        openNextPage(g);


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
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameselect_activity);
        allData = DataJsonParser.parseToArrayList("[  {    \"Game\": \"escap_from_tarkov\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"pubg\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"cod\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"csgo\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Gun\": [      {        \"name\": \"Gun 1\",        \"Damage\": \"100\",        \"Type\": \"Type 2\"      },      {        \"name\": \"Gun 2\",        \"Damage\": \"200\",        \"Type\": \"Type 2\"      },      {        \"name\": \"Gun 3\",        \"Damage\": \"50\",        \"Type\": \"Type 3\"      },      {        \"name\": \"Gun 4\",        \"Damage\": \"400\",        \"Type\": \"Type 4\"      },      {        \"name\": \"Gun 5\",        \"Damage\": \"100\",        \"Type\": \"Type 5\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"dayz\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  }]");
        lv = findViewById(R.id.gameList);

        gameNames = allData.keySet().toArray();
        final List<Object> ListElementsArrayList = new ArrayList<>(Arrays.asList(gameNames));
        ArrayList<ImageData> images = new ArrayList<>();
        for (int counter = 0; counter < gameNames.length; counter++) {
            String gName = gameNames[counter].toString();
            images.add(new ImageData(GetGameImage(gName)));

        }

        ImageAdapter customAdapter = new ImageAdapter(this, images);
        lv.setAdapter(customAdapter);

        /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String itemID = String.valueOf(id);
                Toast.makeText(getApplicationContext(), itemID, Toast.LENGTH_SHORT).show();
                //openNextPage();
            }
        }

        ); */

      /*





        ); */
    }


    public void openNextPage(Game g) {
        Intent intent = new Intent(this, MenuSelectActivity.class);
        intent.putExtra("Game",g);
        startActivity(intent);


    }


/*
    class IconicAdapter extends ArrayAdapter {
        Activity context;

        IconicAdapter(Activity context) {
            super(context, R.layout.gameselect_list_item, ListElementsArrayList);

            this.context = context;
        }
    }
*/


    //generateButtons();


    public void setData(Object result) {
        // ArrayList <String> contactList = new ArrayList<String>(Arrays.asList(game_listShort));
        //contactList = Arrays.(game_listShort);
        // ArrayList<HashMap<String, String>> contactList = new Arrays.asList(game_listShort);

        //vizualizacija podatkov
        //ListAdapter adapter = new SimpleAdapter(this,contactList,R.layout.gameselect_list_item,new String[] {"game","favourite"}, new int[]{R.id.game,R.id.favourite});
        // lv.setAdapter(adapter);
    }


    /*
        public void generateButtons() {
            LinearLayout list = (LinearLayout) findViewById(R.id.layoutGames);
            for (int game = 0; game < game_list.length; game++) {
                CheckBox favourite = new CheckBox(this);
                final Button button = new Button(this);
           *//* button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams()
        ));
            button.setId(game);
            favourite.setId(100 + game);

            list.addView(favourite);
            list.addView(button);
            favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CheckBox checkBox = (CheckBox) v;
                    if (checkBox.isChecked()) {
                        favouriteGame(button.getId());
                    } else {
                        unFavouriteGame(button.getId());

                    }
                }
            });


        }


    }

    private void favouriteGame(int game) {
        Toast.makeText(this, game_list[game] + " favourited", Toast.LENGTH_SHORT).show();
    }

    private void unFavouriteGame(int game) {

        Toast.makeText(this, game_list[game] + " unfavourited", Toast.LENGTH_SHORT).show();

    }*/
    public int GetGameImage(String name) {
        switch (name) {
            case "escap_from_tarkov":
                return R.drawable.escap_from_tarkov;
            case "cod":
                return R.drawable.cod;
            case "csgo":
                return R.drawable.csgo;
            case "dayz":
                return R.drawable.dayz;
            case "pubg":
                return R.drawable.pubg;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }


    }

}



