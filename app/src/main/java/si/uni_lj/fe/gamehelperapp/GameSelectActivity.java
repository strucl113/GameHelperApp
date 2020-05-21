package si.uni_lj.fe.gamehelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
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

public class GameSelectActivity extends AppCompatActivity {
    String[] game_list = {"Escape from Tarkov", "COD Warzone", "Apex Legends", "Players unknown battlegrounds ", "DayZ"};
    String[] game_listShort = {"EFT", "CODWarzone", "apex", "PUBG ", "Dayz"};
    private ListView lv;
    private ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setData(game_listShort);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameselect_activity);
        lv=findViewById(R.id.gameList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
        //generateButtons();



    public void setData(Object result) {
       // ArrayList <String> contactList = new ArrayList<String>(Arrays.asList(game_listShort));
        //contactList = Arrays.(game_listShort);
        // ArrayList<HashMap<String, String>> contactList = new Arrays.asList(game_listShort);

                //vizualizacija podatkov
        ListAdapter adapter = new SimpleAdapter(this,contactList,R.layout.gameselect_list_item,new String[] {"game","favourite"}, new int[]{R.id.game,R.id.favourite});
        lv.setAdapter(adapter);
    }


/*
    public void generateButtons() {
        LinearLayout list = (LinearLayout) findViewById(R.id.layoutGames);
        for (int game = 0; game < game_list.length; game++) {
            CheckBox favourite = new CheckBox(this);
            final Button button = new Button(this);
       *//* button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams()
        ));*//*
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
