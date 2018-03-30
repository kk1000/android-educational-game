package com.example.michalina.game;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;
import com.example.michalina.game.Instructions.FishInstructionActivity;
import com.example.michalina.game.Instructions.PigInstructionActivity;
import com.example.michalina.game.Instructions.RabbitInstructionActivity;
import com.example.michalina.game.Model.Setting;
import com.example.michalina.game.Points.PointsRatingActivity;
import com.example.michalina.game.Technical.SoundService;

public class MainActivity extends AppCompatActivity {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    Button button7;
    ImageButton button8;
    View underline1;
    View underline2;
    View underline3;
    View underline4;
    View underline5;
    View underline6;
    DatabaseHelper dbh;
    Setting setting;

    boolean isPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //start service and play music
        startService(new Intent(MainActivity.this, SoundService.class));

        dbh = new DatabaseHelper(getApplicationContext());
        setting = new Setting();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (ImageButton) findViewById(R.id.imageButton9);
        button1.setEnabled(false);

        button2 = (ImageButton) findViewById(R.id.imageButton12);
        button2.setEnabled(false);

        button3 = (ImageButton) findViewById(R.id.imageButton10);
        button3.setEnabled(false);

        button4 = (ImageButton) findViewById(R.id.imageButton13);
        button4.setEnabled(false);

        button5 = (ImageButton) findViewById(R.id.imageButton11);
        button5.setEnabled(false);

        button6 = (ImageButton) findViewById(R.id.imageButton14);
        button6.setEnabled(false);

        button7 = (Button) findViewById(R.id.button2);
        button7.setEnabled(false);

        button8 = (ImageButton) findViewById(R.id.imageButton);
        button8.setBackgroundResource(R.drawable.ic_volume_up);
        button8.setOnClickListener(mTogglePlayButton);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_volume_up );
        ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE);
        myIcon.setColorFilter(filter);

        setDisabled(button1);
        setDisabled(button2);
        setDisabled(button3);
        setDisabled(button4);
        setDisabled(button5);
        setDisabled(button6);

        underline1 = findViewById(R.id.view8);
        underline1.setVisibility(View.INVISIBLE);

        underline2 = findViewById(R.id.view9);
        underline2.setVisibility(View.INVISIBLE);

        underline3 = findViewById(R.id.view10);
        underline3.setVisibility(View.INVISIBLE);

        underline4 = findViewById(R.id.view11);
        underline4.setVisibility(View.INVISIBLE);

        underline5 = findViewById(R.id.view12);
        underline5.setVisibility(View.INVISIBLE);

        underline6 = findViewById(R.id.view13);
        underline6.setVisibility(View.INVISIBLE);
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
                stopService(new Intent(MainActivity.this, SoundService.class));
            }else{
                v.setBackgroundResource(R.drawable.ic_volume_up);
                Drawable myIcon = getResources().getDrawable( R.drawable.ic_volume_up );
                ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE);
                myIcon.setColorFilter(filter);
                startService(new Intent(MainActivity.this, SoundService.class));
            }

            isPlay = !isPlay; // reverse
        }

    };

    public void selectPig(View v){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button1.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button2.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button3.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button4.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button5.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button6.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);

        underline3.setVisibility(View.VISIBLE);

        if(underline2.isShown()){
            underline2.setVisibility(View.INVISIBLE);
        }
        else if (underline1.isShown()){
            underline1.setVisibility(View.INVISIBLE);
        }

        setting.setAnimal_id(1);
        dbh.updateSetting(setting);
    }

    public void selectFish(View v){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button1.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button2.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button3.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button4.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button5.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button6.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);

        underline1.setVisibility(View.VISIBLE);

        if(underline2.isShown()){
            underline2.setVisibility(View.INVISIBLE);
        }
        else if (underline3.isShown()){
            underline3.setVisibility(View.INVISIBLE);
        }

        setting.setAnimal_id(2);
        dbh.updateSetting(setting);
    }

    public void selectRabbit(View v){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button1.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button2.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button3.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button4.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button5.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);
        button6.setColorFilter(Color.parseColor("#ffc107"), PorterDuff.Mode.SRC_ATOP);

        underline2.setVisibility(View.VISIBLE);

        if(underline3.isShown()){
            underline3.setVisibility(View.INVISIBLE);
        }
        else if (underline1.isShown()){
            underline1.setVisibility(View.INVISIBLE);
        }

        setting.setAnimal_id(3);
        dbh.updateSetting(setting);
    }

    public void selectFirstLevel(View v){

        button7.setEnabled(true);

        underline4.setVisibility(View.VISIBLE);

        if(underline5.isShown()){
            underline5.setVisibility(View.INVISIBLE);
        }
        else if (underline6.isShown()){
            underline6.setVisibility(View.INVISIBLE);
        }

        setting.setLevel_id(1);
        dbh.updateSetting(setting);
    }

    public void selectSecondLevel(View v){

        button7.setEnabled(true);

        underline5.setVisibility(View.VISIBLE);

        if(underline4.isShown()){
            underline4.setVisibility(View.INVISIBLE);
        }
        else if (underline6.isShown()){
            underline6.setVisibility(View.INVISIBLE);
        }

        setting.setLevel_id(2);
        dbh.updateSetting(setting);
    }

    public void selectThirdLevel(View v){

        button7.setEnabled(true);

        underline6.setVisibility(View.VISIBLE);

        if(underline4.isShown()){
            underline4.setVisibility(View.INVISIBLE);
        }
        else if (underline5.isShown()){
            underline5.setVisibility(View.INVISIBLE);
        }

        setting.setLevel_id(3);
        dbh.updateSetting(setting);
    }

    public void setDisabled(ImageButton imageButton) {
        final ColorMatrix grayscaleMatrix = new ColorMatrix();
        grayscaleMatrix.setSaturation(0);

        final ColorMatrixColorFilter filter = new ColorMatrixColorFilter(grayscaleMatrix);
        imageButton.setColorFilter(filter);
    }

    public void displayInstruction(View v){
        stopService(new Intent(MainActivity.this, SoundService.class));

        int animal = setting.getAnimal_id();

        if(animal==1) {
            Intent instructionPage = new Intent(this, PigInstructionActivity.class);
            startActivity(instructionPage);
        }
        else if(animal==2){
            Intent instructionPage = new Intent(this, FishInstructionActivity.class);
            startActivity(instructionPage);
        }
        else if(animal==3){
            Intent instructionPage = new Intent(this, RabbitInstructionActivity.class);
            startActivity(instructionPage);
        }
    }

    public void showPoints(View v){
        Intent pointsPage = new Intent(this, PointsRatingActivity.class);
        startActivity(pointsPage);
    }

    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onDestroy();
    }
}
