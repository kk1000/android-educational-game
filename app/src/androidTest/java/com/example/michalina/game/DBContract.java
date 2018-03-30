package com.example.michalina.game;

import android.provider.BaseColumns;

/**
 * Created by Michalina on 06.01.2018.
 */

public class DBContract {

    public static final class Animal implements BaseColumns {

        public static final String TABLE_NAME= "Animals";

        public static final String COLUMN_NAME = "animal_name";


    }

    public static final class Point implements BaseColumns {

        public static final String TABLE_NAME= "Points";

        public static final String COLUMN_ANIMAL_FK = "animal_name";
        public static final String COLUMN_AMOUNT = "points_amount";


    }

    public static final class Setting implements BaseColumns {

        public static final String TABLE_NAME= "Settings";

        public static final String COLUMN_ANIMAL = "animal_id";
        public static final String COLUMN_LEVEL = "level_id";


    }
}