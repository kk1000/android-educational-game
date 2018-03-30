package com.example.michalina.game.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.michalina.game.Model.Animal;
import com.example.michalina.game.Model.Point;
import com.example.michalina.game.Model.Setting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michalina on 01.01.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "game";

    // Table Names
    private static final String TABLE_ANIMALS = "Animals";
    private static final String TABLE_POINTS = "Points";
    private static final String TABLE_SETTINGS = "Settings";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// Table Create Statements
        // Animals table create statement
        String CREATE_TABLE_ANIMALS =
                "CREATE TABLE " + TABLE_ANIMALS + "(" +
                        "animal_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "animal_name TEXT NOT NULL" +
                        ")";

        // Points table create statements
        String CREATE_TABLE_POINTS =
                "CREATE TABLE " + TABLE_POINTS + "(" +
                        "points_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "animal_name TEXT NOT NULL, " +
                        "points_amount INTEGER, " +
                        "FOREIGN KEY(animal_name) REFERENCES " + TABLE_ANIMALS + "(animal_name)" +
                        ")";

        // Settings table create statements
        String CREATE_TABLE_SETTINGS =
                "CREATE TABLE " + TABLE_SETTINGS + "(" +
                        "settings_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "animal_id INTEGER, " +
                        "level_id INTEGER" +
                        ")";

        //Adding to animals table
        String INSERT_ANIMALS =
                "INSERT INTO " + TABLE_ANIMALS + " VALUES (null, 'Świnka');" +
                        "INSERT INTO " + TABLE_ANIMALS + " VALUES (null, 'Rybka');" +
                        "INSERT INTO " + TABLE_ANIMALS + " VALUES (null, 'Króliczek');";

        //Adding to points table
        String INSERT_POINTS =
                "INSERT INTO " + TABLE_POINTS + " VALUES (null, 1, 1);" +
                        "INSERT INTO " + TABLE_POINTS + " VALUES (null, 2, 2);" +
                        "INSERT INTO " + TABLE_POINTS + " VALUES (null, 3, 3);";

        //Set values in settings table
        String INSERT_SETTINGS =
                "INSERT INTO " + TABLE_SETTINGS + " VALUES (null, 1, 0);";

        db.execSQL(CREATE_TABLE_ANIMALS);
        db.execSQL(CREATE_TABLE_POINTS);
        db.execSQL(CREATE_TABLE_SETTINGS);

        executeBatchSql(INSERT_ANIMALS, db);
        executeBatchSql(INSERT_POINTS, db);
        executeBatchSql(INSERT_SETTINGS, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POINTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);

        // create new tables
        onCreate(db);
    }

    public void executeBatchSql(String str, SQLiteDatabase db){
        String[] queries = str.split(";");
        for(String query : queries) {
            db.execSQL(query);
        }
    }

    //animal methods
    public Animal getAnimal(int animal_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ANIMALS + " WHERE "
                + "animal_id = " + animal_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Animal td = new Animal();
        td.setAnimal_id(c.getInt(c.getColumnIndex("animal_id")));
        td.setAnimal_name(c.getString(c.getColumnIndex("animal_name")));

        return td;
    }

    public List<String> getAnimalsNames(List<Integer> animals_ids) {
        SQLiteDatabase db = this.getReadableDatabase();

        List<String> result = new ArrayList<>();

        String selectQueryBase = "SELECT * FROM " + TABLE_ANIMALS + " WHERE "//marker_name
                + "animal_id = ";
        String selectQuery = "";

        for ( int animal_id : animals_ids ){
            selectQuery = selectQueryBase + Integer.toString(animal_id);

            Log.e(LOG, selectQuery);

            Cursor c = db.rawQuery(selectQuery, null);

            if (c != null)
                c.moveToFirst();

            result.add(c.getString(c.getColumnIndex("animal_name")));
        }

        return result;
    }

    public List<Animal> getAllAnimals() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Animal> animals = new ArrayList<Animal>();
        String selectQuery = "SELECT  * FROM " + TABLE_ANIMALS;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Animal td = new Animal();
                td.setAnimal_id(c.getInt(c.getColumnIndex("marker_id")));
                td.setAnimal_name(c.getString(c.getColumnIndex("marker_name")));

                animals.add(td);
            } while (c.moveToNext());
        }

        return animals;
    }

    //points methods

    public Point getPoints(int points_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_POINTS + " WHERE "
                + "points_id = " + points_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        Point td;

        if (c.getCount()>0)
            c.moveToFirst();
        {
            td = new Point();
            td.setPoints_id(c.getInt(c.getColumnIndex("points_id")));
            td.setPoints_amount(c.getInt(c.getColumnIndex("points_amount")));
        }

        return td;
    }

    public int updatePoint(Point point) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("points_amount", point.getPoints_amount());

        int points_id = db.update(TABLE_POINTS, values, "points_id = ?",
                new String[]{String.valueOf(point.getPoints_id())});


        return points_id;
    }

    public Point getAnimalPoints(int animal_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_POINTS + " WHERE "
                + "animal_id = " + animal_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);


                Point point = getPoints(c.getInt(c.getColumnIndex("points_id")));


        return point;
    }

    //settings methods

    public Setting getSetting() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SETTINGS + " WHERE "
                + "settings_id = " + 1;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Setting td = new Setting();
        td.setSetting_id(c.getInt(c.getColumnIndex("settings_id")));
        td.setAnimal_id(c.getInt(c.getColumnIndex("animal_id")));
        td.setLevel_id(c.getInt(c.getColumnIndex("level_id")));

        return td;
    }

    public int updateSetting(Setting setting) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("animal_id", setting.getAnimal_id());
        values.put("level_id", setting.getLevel_id());

        int setting_id = db.update(TABLE_SETTINGS, values, "settings_id = ?",
                new String[]{String.valueOf(1)});


        return setting_id;
    }

}
