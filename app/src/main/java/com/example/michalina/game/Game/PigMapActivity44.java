package com.example.michalina.game.Game;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;
import com.example.michalina.game.MainActivity;
import com.example.michalina.game.Model.Point;
import com.example.michalina.game.R;
import com.example.michalina.game.Technical.SoundService;

/**
 * Created by Michalina on 04.01.2018.
 */

public class PigMapActivity44 extends AppCompatActivity {

    private DatabaseHelper dbh;
    ImageButton imageButton1;
    View view1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    View view2;
    View view3;
    ImageButton imageButton5;
    boolean isPlay = true;
    ImageView child;
    ImageView mother;
    Drawable drawable;
    int smileNum = 0;
    ImageView cloud, fishresult, star;
    Button home, repeat;
    TextView plus,point1,point2,point3,point4,point5;
    RatingBar points;
    ImageView d1,d2,d3,d4,f1,f2,f3,f4, smile, sad;
    Point databasePoints;
    double pointsAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(PigMapActivity44.this, SoundService.class));
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map_pig44);

        dbh = new DatabaseHelper(getApplicationContext());

        imageButton1 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton18);
        view1 = findViewById(R.id.myRectangleView2);
        imageButton2.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.INVISIBLE);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton21);
        child = (ImageView) findViewById(R.id.imageView13);
        mother = (ImageView) findViewById(R.id.imageView14);
        points = (RatingBar) findViewById(R.id.ratingBar4);
        cloud = (ImageView) findViewById(R.id.imageView16);
        fishresult = (ImageView) findViewById(R.id.imageView31);
        home = (Button) findViewById(R.id.button);
        repeat = (Button) findViewById(R.id.button4);
        star = (ImageView) findViewById(R.id.imageView32);
        plus = (TextView) findViewById(R.id.textView19);
        point1 = (TextView) findViewById(R.id.textView11);
        point2 = (TextView) findViewById(R.id.textView12);
        point3 = (TextView) findViewById(R.id.textView13);
        point4 = (TextView) findViewById(R.id.textView14);
        point5 = (TextView) findViewById(R.id.textView6);

        view2 = findViewById(R.id.myRectangleView3);
        view3 = findViewById(R.id.view15);
        imageButton3.setVisibility(View.INVISIBLE);
        imageButton4.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        imageButton5.setVisibility(View.INVISIBLE);
        points.setVisibility(View.INVISIBLE);
        cloud.setVisibility(View.INVISIBLE);
        fishresult.setVisibility(View.INVISIBLE);
        home.setVisibility(View.INVISIBLE);
        repeat.setVisibility(View.INVISIBLE);
        star.setVisibility(View.INVISIBLE);
        plus.setVisibility(View.INVISIBLE);


        d1=(ImageView) findViewById(R.id.imageView34);
        d2=(ImageView) findViewById(R.id.imageView59);
        d3=(ImageView) findViewById(R.id.imageView60);
        d4=(ImageView) findViewById(R.id.imageView61);
        d1.setColorFilter(Color.GRAY);
        d2.setColorFilter(Color.GRAY);
        d3.setColorFilter(Color.GRAY);
        d4.setColorFilter(Color.GRAY);
        f1=(ImageView) findViewById(R.id.imageView62);
        f1.setOnTouchListener(new ChoiceTouchListener());
        f2=(ImageView) findViewById(R.id.imageView63);
        f2.setOnTouchListener(new ChoiceTouchListener());
        f3=(ImageView) findViewById(R.id.imageView64);
        f3.setOnTouchListener(new ChoiceTouchListener());
        f4=(ImageView) findViewById(R.id.imageView65);
        f4.setOnTouchListener(new ChoiceTouchListener());
        d1.setOnDragListener(new ChoiceDragListener());
        d2.setOnDragListener(new ChoiceDragListener2());
        d3.setOnDragListener(new ChoiceDragListener3());
        d4.setOnDragListener(new ChoiceDragListener4());

        smile = (ImageView) findViewById(R.id.imageView28);
        smile.setColorFilter(Color.parseColor("#212121"));
        smile.setVisibility(View.INVISIBLE);

        sad = (ImageView) findViewById(R.id.imageView29);
        sad.setColorFilter(Color.parseColor("#212121"));
        sad.setVisibility(View.INVISIBLE);
        databasePoints = dbh.getPoints(1);
        pointsAmount = (databasePoints.getPoints_amount() * 0.1);
    }

    public void showAdditionalMenu(View v){
        imageButton1.setVisibility(View.INVISIBLE);
        imageButton2.setVisibility(View.VISIBLE);
        view1.setVisibility(View.VISIBLE);
        imageButton3.setVisibility(View.VISIBLE);
        if(isPlay) {
            imageButton4.setVisibility(View.VISIBLE);
        }
        else
        {
            imageButton5.setVisibility(View.VISIBLE);
        }
        view2.setVisibility(View.VISIBLE);
        view3.setVisibility(View.VISIBLE);
    }

    public void hideAdditionalMenu(View v){
        imageButton2.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.INVISIBLE);
        imageButton3.setVisibility(View.INVISIBLE);
        imageButton4.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        imageButton1.setVisibility(View.VISIBLE);
        imageButton5.setVisibility(View.INVISIBLE);
    }

    private final class ChoiceTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if(event.getAction()==MotionEvent.ACTION_DOWN && ((ImageView)v).getDrawable()!=null){
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
                v.startDrag(data, shadow, v, 0);
                drawable = ((ImageView)v).getDrawable();
                return true;
            }
            else {
                return false;
            }
        }
    }

    private class ChoiceDragListener implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    ImageView view  = (ImageView) event.getLocalState();
                    if(view==f1) {
                        smileNum+=1;
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                smile.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                smile.setVisibility(View.GONE);
                                if(smileNum==4){
                                    cloud.setVisibility(View.VISIBLE);
                                    fishresult.setVisibility(View.VISIBLE);
                                    points.setVisibility(View.VISIBLE);
                                    home.setVisibility(View.VISIBLE);
                                    repeat.setVisibility(View.VISIBLE);
                                    star.setVisibility(View.VISIBLE);
                                    plus.setVisibility(View.VISIBLE);
                                    databasePoints.setPoints_amount((int)(pointsAmount*10)+1);
                                    dbh.updatePoint(databasePoints);
                                    pointsAmount=pointsAmount+0.1;
                                    points.setRating((float) pointsAmount);
                                    if(databasePoints.getPoints_amount()>0 && databasePoints.getPoints_amount()<=10){
                                        point1.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>10 && databasePoints.getPoints_amount()<=20){
                                        point2.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>20 && databasePoints.getPoints_amount()<=30){
                                        point3.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>30 && databasePoints.getPoints_amount()<=40){
                                        point4.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>40){
                                        point5.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                }
                            }
                        }.start();
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.pig44a));
                        d1.setColorFilter(Color.parseColor("#d2b48c"));
                        view.setImageDrawable(null);

                    }
                    else{
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                sad.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                sad.setVisibility(View.GONE);
                            }
                        }.start();
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }

    private class ChoiceDragListener2 implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    ImageView view  = (ImageView) event.getLocalState();
                    if(view==f2) {
                        smileNum+=1;
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                smile.setVisibility(View.VISIBLE);

                            }

                            public void onFinish() {
                                smile.setVisibility(View.GONE);
                                if(smileNum==4){
                                    cloud.setVisibility(View.VISIBLE);
                                    fishresult.setVisibility(View.VISIBLE);
                                    points.setVisibility(View.VISIBLE);
                                    home.setVisibility(View.VISIBLE);
                                    repeat.setVisibility(View.VISIBLE);
                                    star.setVisibility(View.VISIBLE);
                                    plus.setVisibility(View.VISIBLE);
                                    databasePoints.setPoints_amount((int)(pointsAmount*10)+1);
                                    dbh.updatePoint(databasePoints);
                                    pointsAmount=pointsAmount+0.1;
                                    points.setRating((float) pointsAmount);
                                    if(databasePoints.getPoints_amount()>0 && databasePoints.getPoints_amount()<=10){
                                        point1.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>10 && databasePoints.getPoints_amount()<=20){
                                        point2.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>20 && databasePoints.getPoints_amount()<=30){
                                        point3.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>30 && databasePoints.getPoints_amount()<=40){
                                        point4.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>40){
                                        point5.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                }
                            }
                        }.start();
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.pig44b));
                        d2.setColorFilter(Color.parseColor("#d2b48c"));
                        view.setImageDrawable(null);
                    }
                    else{
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                sad.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                sad.setVisibility(View.GONE);
                            }
                        }.start();
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }

    private class ChoiceDragListener3 implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    ImageView view  = (ImageView) event.getLocalState();
                    if(view==f3) {
                        smileNum+=1;
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                smile.setVisibility(View.VISIBLE);

                            }

                            public void onFinish() {
                                smile.setVisibility(View.GONE);
                                if(smileNum==4){
                                    cloud.setVisibility(View.VISIBLE);
                                    fishresult.setVisibility(View.VISIBLE);
                                    points.setVisibility(View.VISIBLE);
                                    home.setVisibility(View.VISIBLE);
                                    repeat.setVisibility(View.VISIBLE);
                                    star.setVisibility(View.VISIBLE);
                                    plus.setVisibility(View.VISIBLE);
                                    databasePoints.setPoints_amount((int)(pointsAmount*10)+1);
                                    dbh.updatePoint(databasePoints);
                                    pointsAmount=pointsAmount+0.1;
                                    points.setRating((float) pointsAmount);
                                    if(databasePoints.getPoints_amount()>0 && databasePoints.getPoints_amount()<=10){
                                        point1.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>10 && databasePoints.getPoints_amount()<=20){
                                        point2.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>20 && databasePoints.getPoints_amount()<=30){
                                        point3.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>30 && databasePoints.getPoints_amount()<=40){
                                        point4.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>40){
                                        point5.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                }
                            }
                        }.start();
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.pig44c));
                        d3.setColorFilter(Color.parseColor("#d2b48c"));
                        view.setImageDrawable(null);
                    }
                    else{
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                sad.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                sad.setVisibility(View.GONE);
                            }
                        }.start();
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }

    private class ChoiceDragListener4 implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    ImageView view  = (ImageView) event.getLocalState();
                    if(view==f4) {
                        smileNum+=1;
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                smile.setVisibility(View.VISIBLE);

                            }

                            public void onFinish() {
                                smile.setVisibility(View.GONE);
                                if(smileNum==4){
                                    cloud.setVisibility(View.VISIBLE);
                                    fishresult.setVisibility(View.VISIBLE);
                                    points.setVisibility(View.VISIBLE);
                                    home.setVisibility(View.VISIBLE);
                                    repeat.setVisibility(View.VISIBLE);
                                    star.setVisibility(View.VISIBLE);
                                    plus.setVisibility(View.VISIBLE);
                                    databasePoints.setPoints_amount((int)(pointsAmount*10)+1);
                                    dbh.updatePoint(databasePoints);
                                    pointsAmount=pointsAmount+0.1;
                                    points.setRating((float) pointsAmount);
                                    if(databasePoints.getPoints_amount()>0 && databasePoints.getPoints_amount()<=10){
                                        point1.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>10 && databasePoints.getPoints_amount()<=20){
                                        point2.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>20 && databasePoints.getPoints_amount()<=30){
                                        point3.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>30 && databasePoints.getPoints_amount()<=40){
                                        point4.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                    else if(databasePoints.getPoints_amount()>40){
                                        point5.setText(String.valueOf(databasePoints.getPoints_amount()));
                                    }
                                }
                            }
                        }.start();
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.pig44d));
                        d4.setColorFilter(Color.parseColor("#d2b48c"));
                        view.setImageDrawable(null);
                    }
                    else{
                        new CountDownTimer(1000, 100) {

                            public void onTick(long millisUntilFinished) {
                                sad.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                sad.setVisibility(View.GONE);
                            }
                        }.start();
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }
            return true;
        }
    }

    public void turnOffMusic(View v){
        isPlay = false;
        imageButton4.setVisibility(View.INVISIBLE);
        imageButton5.setVisibility(View.VISIBLE);
        stopService(new Intent(PigMapActivity44.this, SoundService.class));
    }

    public void turnOnMusic(View v){
        isPlay = true;
        imageButton5.setVisibility(View.INVISIBLE);
        imageButton4.setVisibility(View.VISIBLE);
        startService(new Intent(PigMapActivity44.this, SoundService.class));
    }

    public void goToStartPage(View v){
        stopService(new Intent(PigMapActivity44.this, SoundService.class));
        Intent startPage = new Intent(this, MainActivity.class);
        startActivity(startPage);
    }

    public void backToMenu(View v){
        stopService(new Intent(PigMapActivity44.this, SoundService.class));
        Intent startPage = new Intent(this, MainActivity.class);
        startActivity(startPage);
    }

    public void repeatGame(View v){
        stopService(new Intent(PigMapActivity44.this, SoundService.class));
        Intent gamePage = new Intent(this, PigMapActivity14.class);
        startActivity(gamePage);
    }
}
