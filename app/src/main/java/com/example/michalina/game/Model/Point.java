package com.example.michalina.game.Model;

/**
 * Created by Michalina on 01.01.2018.
 */

public class Point {

    private int points_id;
    private int points_amount;

    public Point(){

    }

    public Point(int points_amount){
        this.points_amount = points_amount;
    }

    public int getPoints_id() {return points_id;}

    public void setPoints_id(int points_id) {this.points_id = points_id;}

    public int getPoints_amount() {return points_amount;}

    public void setPoints_amount(int points_amount) {this.points_amount = points_amount;}

}
