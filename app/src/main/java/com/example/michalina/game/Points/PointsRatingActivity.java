package com.example.michalina.game.Points;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;
import com.example.michalina.game.MainActivity;
import com.example.michalina.game.Model.Point;
import com.example.michalina.game.R;

/**
 * Created by Michalina on 29.12.2017.
 */

public class PointsRatingActivity extends AppCompatActivity{

    private DatabaseHelper dbh;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_rating);
        dbh = new DatabaseHelper(getApplicationContext());
        textView1 = (TextView) findViewById(R.id.textView7);
        textView2 = (TextView) findViewById(R.id.textView3);
        textView3 = (TextView) findViewById(R.id.textView8);
        textView4 = (TextView) findViewById(R.id.textView9);
        textView5 = (TextView) findViewById(R.id.textView10);

        textView6 = (TextView) findViewById(R.id.textView11);
        textView7 = (TextView) findViewById(R.id.textView12);
        textView8 = (TextView) findViewById(R.id.textView13);
        textView9 = (TextView) findViewById(R.id.textView14);
        textView10 = (TextView) findViewById(R.id.textView6);

        textView11 = (TextView) findViewById(R.id.textView15);
        textView12 = (TextView) findViewById(R.id.textView16);
        textView13 = (TextView) findViewById(R.id.textView17);
        textView14 = (TextView) findViewById(R.id.textView18);
        textView15 = (TextView) findViewById(R.id.textView);

        ratingBar1 = (RatingBar) findViewById(R.id.ratingBar6);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar5);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar4);

        Point point1 = dbh.getPoints(1);
        Point point2 = dbh.getPoints(2);
        Point point3 = dbh.getPoints(3);

        double point1Amount = (point1.getPoints_amount() * 0.1);
        double point2Amount = (point2.getPoints_amount() * 0.1);
        double point3Amount = (point3.getPoints_amount() * 0.1);

        ratingBar1.setRating((float) point1Amount);
        ratingBar2.setRating((float) point2Amount);
        ratingBar3.setRating((float) point3Amount);

        if(point1.getPoints_amount()>0 && point1.getPoints_amount()<=10){
            textView1.setText(String.valueOf(point1.getPoints_amount()));
        }
        else if(point1.getPoints_amount()>10 && point1.getPoints_amount()<=20){
            textView2.setText(String.valueOf(point1.getPoints_amount()));
        }
        else if(point1.getPoints_amount()>20 && point1.getPoints_amount()<=30){
            textView3.setText(String.valueOf(point1.getPoints_amount()));
        }
        else if(point1.getPoints_amount()>30 && point1.getPoints_amount()<=40){
            textView4.setText(String.valueOf(point1.getPoints_amount()));
        }
        else if(point1.getPoints_amount()>40){
            textView5.setText(String.valueOf(point1.getPoints_amount()));
        }

        if(point2.getPoints_amount()>0 && point2.getPoints_amount()<=10){
            textView6.setText(String.valueOf(point2.getPoints_amount()));
        }
        else if(point2.getPoints_amount()>10 && point2.getPoints_amount()<=20){
            textView7.setText(String.valueOf(point2.getPoints_amount()));
        }
        else if(point2.getPoints_amount()>20 && point2.getPoints_amount()<=30){
            textView8.setText(String.valueOf(point2.getPoints_amount()));
        }
        else if(point2.getPoints_amount()>30 && point2.getPoints_amount()<=40){
            textView9.setText(String.valueOf(point2.getPoints_amount()));
        }
        else if(point2.getPoints_amount()>40){
            textView10.setText(String.valueOf(point2.getPoints_amount()));
        }

        if(point3.getPoints_amount()>0 && point3.getPoints_amount()<=10){
            textView11.setText(String.valueOf(point3.getPoints_amount()));
        }
        else if(point3.getPoints_amount()>10 && point3.getPoints_amount()<=20){
            textView12.setText(String.valueOf(point3.getPoints_amount()));
        }
        else if(point3.getPoints_amount()>20 && point3.getPoints_amount()<=30){
            textView13.setText(String.valueOf(point3.getPoints_amount()));
        }
        else if(point3.getPoints_amount()>30 && point3.getPoints_amount()<=40){
            textView14.setText(String.valueOf(point3.getPoints_amount()));
        }
        else if(point3.getPoints_amount()>40){
            textView15.setText(String.valueOf(point3.getPoints_amount()));
        }
    }

    //w zaleznosci czy dzwiek byl wlaczony czy wylaczony do jednego z dwoch stanow
    public void goBack(View v){
        Intent homePage = new Intent(this, MainActivity.class);
        startActivity(homePage);
    }

}
