package com.example.michalina.game.Technical;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.michalina.game.DatabaseHelper.DatabaseHelper;
import com.example.michalina.game.Model.Setting;
import com.example.michalina.game.R;

/**
 * Created by Michalina on 29.12.2017.
 */

public class PointsAudioInstruction extends Service {
    MediaPlayer player;
    DatabaseHelper dbh;
    Setting setting;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        dbh = new DatabaseHelper(getApplicationContext());

        setting = dbh.getSetting();

        if(setting.getAnimal_id()==1) {
            if (setting.getLevel_id() == 1) {
                player = MediaPlayer.create(this, R.raw.pig_1); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 2) {
                player = MediaPlayer.create(this, R.raw.pig_2); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 3) {
                player = MediaPlayer.create(this, R.raw.pig_3); //select music file
                player.setLooping(false); //set looping
            }
        }
        else if(setting.getAnimal_id()==2) {
            if (setting.getLevel_id() == 1) {
                player = MediaPlayer.create(this, R.raw.fish_1); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 2) {
                player = MediaPlayer.create(this, R.raw.fish_2); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 3) {
                player = MediaPlayer.create(this, R.raw.fish_3); //select music file
                player.setLooping(false); //set looping
            }
        }
        else if(setting.getAnimal_id()==3) {
            if (setting.getLevel_id() == 1) {
                player = MediaPlayer.create(this, R.raw.rabbit_1); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 2) {
                player = MediaPlayer.create(this, R.raw.rabbit_2); //select music file
                player.setLooping(false); //set looping
            } else if (setting.getLevel_id() == 3) {
                player = MediaPlayer.create(this, R.raw.rabbit_3); //select music file
                player.setLooping(false); //set looping
            }
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_NOT_STICKY;
    }

    public void onDestroy() {
        player.stop();
        player.release();
        stopSelf();
        super.onDestroy();
    }
}
