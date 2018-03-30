package com.example.michalina.game.Model;

/**
 * Created by Michalina on 01.01.2018.
 */

public class Animal {

    private int animal_id;
    private String animal_name;

    public Animal(){

    }

    public Animal(String animal_name){
        this.animal_name = animal_name;
    }

    public int getAnimal_id() {return animal_id;}

    public void setAnimal_id(int animal_id) {this.animal_id = animal_id;}

    public String getAnimal_name() {return animal_name;}

    public void setAnimal_name(String animal_name) {this.animal_name = animal_name;}

}
