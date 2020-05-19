package si.uni_lj.fe.gamehelperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button gumb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gumb=(Button) findViewById(R.id.button);
        gumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openNextPage();
            }
        });
    }



    public void openNextPage(){
    Intent intent = new Intent(this, GameSelectActivity.class);
    startActivity(intent);


    }
}
