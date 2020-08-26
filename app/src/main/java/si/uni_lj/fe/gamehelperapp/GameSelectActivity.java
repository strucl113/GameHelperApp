package si.uni_lj.fe.gamehelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class GameSelectActivity extends AppCompatActivity {
    HashMap<String, Game> allData = new HashMap<>();
    private ListView lv;
    private ArrayList<HashMap<String, String>> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameselect_activity);
        allData = DataJsonParser.parseToArrayList("[  {    \"Game\": \"Escape from tarkov\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"PUBG\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"COD\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  },  {    \"Game\": \"DayZ\",    \"Ammo\": [      {        \"Name\": \"12/70 shot\",        \"types\": [          {            \"Name\": \"12/70 5.25mm Buckshot\",            \"FleshDamage\": \"8x37\",            \"PenetrationPower\": \"1\",            \"ArmorDamage\": \"15\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 8.5 mm 'Magnum' Buckshot\",            \"FleshDamage\": \"8x50\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"-15\",            \"Recoil\": \"+115\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 6.5 mm 'Express' Buckshot\",            \"FleshDamage\": \"9x35\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"+15\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12x70 7mm Buckshot\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          },          {            \"Name\": \"12/70 Flechette\",            \"FleshDamage\": \"8x39\",            \"PenetrationPower\": \"3\",            \"ArmorDamage\": \"26\",            \"Accuracy\": \"0\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"0\"          }        ]      },      {        \"Name\": \"12/70 slugs\",        \"types\": [          {            \"Name\": \"12x70 RIP\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"12/70 HP Slug 'SuperFormance'\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"+170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"12/70 Grizzly 40 Slug\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"+80\",            \"Recoil\": \"+20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"12/70 HP Slug Copper Sabot Premier\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"+150\",            \"Recoil\": \"+10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"12x70 Led slug\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      },      {        \"Name\": \"Type 3\",        \"types\": [          {            \"Name\": \"Ammo31\",            \"FleshDamage\": \"265\",            \"PenetrationPower\": \"0\",            \"ArmorDamage\": \"11\",            \"Accuracy\": \"80\",            \"Recoil\": \"35\",            \"FragmentationChance\": \"100\"          },          {            \"Name\": \"Ammo32\",            \"FleshDamage\": \"220\",            \"PenetrationPower\": \"2\",            \"ArmorDamage\": \"12\",            \"Accuracy\": \"170\",            \"Recoil\": \"-15\",            \"FragmentationChance\": \"39\"          },          {            \"Name\": \"Ammo33\",            \"FleshDamage\": \"190\",            \"PenetrationPower\": \"12\",            \"ArmorDamage\": \"48\",            \"Accuracy\": \"80\",            \"Recoil\": \"20\",            \"FragmentationChance\": \"12\"          },          {            \"Name\": \"Ammo34\",            \"FleshDamage\": \"206\",            \"PenetrationPower\": \"14\",            \"ArmorDamage\": \"46\",            \"Accuracy\": \"150\",            \"Recoil\": \"10\",            \"FragmentationChance\": \"38\"          },          {            \"Name\": \"Ammo35\",            \"FleshDamage\": \"167\",            \"PenetrationPower\": \"15\",            \"ArmorDamage\": \"55\",            \"Accuracy\": \"120\",            \"Recoil\": \"0\",            \"FragmentationChance\": \"20\"          }        ]      }    ],    \"Helmets\": [      {        \"name\": \"Helmet 1\",        \"Armor\": \"100\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 2\",        \"Armor\": \"200\",        \"Addons\": \"no\"      },      {        \"name\": \"Helmet 3\",        \"Armor\": \"50\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 4\",        \"Armor\": \"400\",        \"Addons\": \"yes\"      },      {        \"name\": \"Helmet 6\",        \"Armor\": \"100\",        \"Addons\": \"yes\"      }    ],    \"Armors\": [      {        \"name\": \"Armor 1\",        \"Armor\": \"100\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 2\",        \"Armor\": \"200\",        \"Material\": \"kevlar\"      },      {        \"name\": \"Armor 3\",        \"Armor\": \"50\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 4\",        \"Armor\": \"400\",        \"Material\": \"Ceramics\"      },      {        \"name\": \"Armor 6\",        \"Armor\": \"100\",        \"Material\": \"Ceramics\"      }    ]  }]");
        lv=findViewById(R.id.gameList);
        final Object[] gameNames = allData.keySet().toArray();
        final List<Object> ListElementsArrayList = new ArrayList<>(Arrays.asList(gameNames));
        final ArrayAdapter<Object> adapter = new ArrayAdapter<>
                (GameSelectActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //create buttons with images as background and text.
        for(int i=0;i<gameNames.length;i++) {


        }


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view,
                                                              int position, long id) {
                                          String itemID = String.valueOf(id) ;
                                         // Toast.makeText(getApplicationContext(),itemID , Toast.LENGTH_SHORT).show();
                                         // openNextPage();
                                      }
                                  });

      /*





        ); */
    }



    public void openNextPage() {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);


    }












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


}
