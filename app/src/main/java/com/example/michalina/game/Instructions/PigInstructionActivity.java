package com.example.michalina.game.Instructions;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;
import com.example.michalina.game.Game.PigMapActivity14;
import com.example.michalina.game.Game.PigMapActivity16;
import com.example.michalina.game.Game.PigMapActivity19;
import com.example.michalina.game.Game.PigMapActivity44;
import com.example.michalina.game.Game.PigMapActivity46;
import com.example.michalina.game.Game.PigMapActivity49;
import com.example.michalina.game.MainActivity;
import com.example.michalina.game.Model.Setting;
import com.example.michalina.game.R;
import com.example.michalina.game.Technical.PointsAudioInstruction;

import java.util.Random;

/**
 * Created by Michalina on 29.12.2017.
 */

public class PigInstructionActivity extends AppCompatActivity {

    boolean isPlay = true;
    ImageButton button;
    TextView textView;
    Setting setting;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        startService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
        dbh = new DatabaseHelper(getApplicationContext());
        setting = dbh.getSetting();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_pig);

        button = (ImageButton) findViewById(R.id.imageButton15);
        button.setBackgroundResource(R.drawable.ic_volume_up);
        button.setOnClickListener(mTogglePlayButton);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_volume_up );
        ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE);
        myIcon.setColorFilter(filter);
        textView = (TextView) findViewById(R.id.textView5);

        if(setting.getLevel_id()==1){
            textView.setText("1 punkt do kolekcji.");
        }
        else if(setting.getLevel_id()==2){
            textView.setText("2 punkty do kolekcji.");
        }
        else if(setting.getLevel_id()==3){
            textView.setText("3 punkty do kolekcji.");
        }
    }

    View.OnClickListener mTogglePlayButton = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            // change your button background

            if(isPlay){
                v.setBackgroundResource(R.drawable.ic_volume_off);
                Drawable myIcon = getResources().getDrawable( R.drawable.ic_volume_off );
                ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE);
                myIcon.setColorFilter(filter);
                stopService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
            }else{
                v.setBackgroundResource(R.drawable.ic_volume_up);
                Drawable myIcon = getResources().getDrawable( R.drawable.ic_volume_up );
                ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE);
                myIcon.setColorFilter(filter);
                startService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
            }

            isPlay = !isPlay; // reverse
        }

    };

    public void goBack(View v){
        stopService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
        Intent homePage = new Intent(this, MainActivity.class);
        startActivity(homePage);
    }

    public void repeatInstruction(View v){
        if(isPlay)
            startService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
    }

    public void showMap(View v){
        stopService(new Intent(PigInstructionActivity.this, PointsAudioInstruction.class));
        Intent mapPage;
        Random mRand = new Random();
        int x = mRand.nextInt(2);
        if(setting.getLevel_id()==1){
            if(x==0) {
                mapPage = new Intent(this, PigMapActivity44.class);
                startActivity(mapPage);
            }
            else if(x==1){
                mapPage = new Intent(this, PigMapActivity14.class);
                startActivity(mapPage);
            }
        }
        else if(setting.getLevel_id()==2){
            if(x==0) {
                mapPage = new Intent(this, PigMapActivity46.class);
                startActivity(mapPage);
            }
            else if(x==1){
                mapPage = new Intent(this, PigMapActivity16.class);
                startActivity(mapPage);
            }
        }
        else if(setting.getLevel_id()==3){
            if(x==0) {
                mapPage = new Intent(this, PigMapActivity49.class);
                startActivity(mapPage);
            }
            else if(x==1){
                mapPage = new Intent(this, PigMapActivity19.class);
                startActivity(mapPage);
            }
        }

    }

}
