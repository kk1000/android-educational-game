package com.example.michalina.game.Model;

/**
 * Created by Michalina on 01.01.2018.
 */

public class Setting {

    private int setting_id;
    private int animal_id;
    private int level_id;

    public Setting(){

    }

    public Setting(int animal_id, int level_id){
        this.animal_id = animal_id;
        this.level_id = level_id;
    }

    public int getSetting_id() {return setting_id;}

    public void setSetting_id(int setting_id) {this.setting_id = setting_id;}

    public int getAnimal_id() {return animal_id;}

    public void setAnimal_id(int animal_id) {this.animal_id = animal_id;}

    public int getLevel_id() {return level_id;}

    public void setLevel_id(int level_id) {this.level_id = level_id;}

}
