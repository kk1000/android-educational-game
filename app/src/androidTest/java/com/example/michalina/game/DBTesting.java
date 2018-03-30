package com.example.michalina.game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michalina on 05.01.2018.
 */

public class DBTesting extends AndroidTestCase {

    /*public void createDB(){
        DatabaseHelper helper = new DatabaseHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();
    }*/

    private Context context;
    private DatabaseHelper helper;
    SQLiteDatabase db;
    String animal_name;
    int amount;
    int animal_id;
    int level_id;
    private static long mAnimalDBAssignId;
    private static long mPointDBAssignId;
    private static long mSettingDBAssignId;
    private static String mAnimalName;

    @Before
    public void setup(){
        helper = new DatabaseHelper(mContext);
        db = helper.getReadableDatabase();
    }

    @After
    public void cleanup(){
        db.close();
    }


    @Test
    public void testDBCreated(){
        helper = new DatabaseHelper(mContext);
        db = helper.getWritableDatabase();
        // Verify is the DB is opening correctly
        assertTrue("DB didn't open", db.isOpen());
        db.close();
    }

    @Test
public void dropDatabase(){
        assertTrue(mContext.deleteDatabase(DatabaseHelper.DATABASE_NAME));
    }

    public void testInsertAnimalData(){
        DatabaseHelper helper = new DatabaseHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        animal_name = "cat";
        ContentValues values = new ContentValues();
        values.put(DBContract.Animal.COLUMN_NAME, animal_name);

        mAnimalDBAssignId = db.insert(DBContract.Animal.TABLE_NAME, null, values);
        assertTrue(mAnimalDBAssignId!=-1);
    }

    public void testInsertSettingData(){
        DatabaseHelper helper = new DatabaseHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        animal_id = 1;
        level_id = 2;
        ContentValues values = new ContentValues();
        values.put(DBContract.Setting.COLUMN_ANIMAL, animal_id);
        values.put(DBContract.Setting.COLUMN_LEVEL, level_id);

        mSettingDBAssignId = db.insert(DBContract.Setting.TABLE_NAME, null, values);
        assertTrue(mSettingDBAssignId!=-1);
    }

    public void testInsertPointData(){
        DatabaseHelper helper = new DatabaseHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        amount = 10;
        ContentValues values = new ContentValues();
        values.put(DBContract.Point.COLUMN_ANIMAL_FK, "pig");
        values.put(DBContract.Point.COLUMN_AMOUNT, amount);

        mPointDBAssignId = db.insert(DBContract.Point.TABLE_NAME, null, values);
        assertTrue(mPointDBAssignId!=-1);
    }

    public void testCorrectOfDataInAnimalTable(){
        DatabaseHelper helper = new DatabaseHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DBContract.Animal.TABLE_NAME, null, null, null, null, null, null);
        assertTrue(cursor!=null);

        cursor.moveToFirst();
        int idColumnIndex = cursor.getColumnIndex(DBContract.Animal._ID);
        int dbId = cursor.getInt(idColumnIndex);

        int nameCoulmnIndex = cursor.getColumnIndex(DBContract.Animal.COLUMN_NAME);
        String dbName = cursor.getString(nameCoulmnIndex);

        assertEquals(mAnimalDBAssignId, dbId);
        assertEquals(mAnimalName, dbName);
    }
}
