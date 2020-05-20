package si.uni_lj.fe.gamehelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class GameSelectActivity extends AppCompatActivity {
    String[] game_list = {"Escape from Tarkov", "COD Warzone", "Apex Legends", "Players unknown battlegrounds ", "DayZ"};
    String[] game_listShort = {"EFT", "CODWarzone", "apex", "PUBG ", "Dayz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameselect_activity);
        generateButtons();

    }

    public void generateButtons() {
        LinearLayout list = (LinearLayout) findViewById(R.id.layoutGames);
        for (int game = 0; game < game_list.length; game++) {
            CheckBox favourite = new CheckBox(this);
            final Button button = new Button(this);
       /* button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams()
        ));*/
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

    }

    public void selectedEFT() {


    }
}
