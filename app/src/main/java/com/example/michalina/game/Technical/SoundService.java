package com.example.michalina.game.Technical;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.michalina.game.R;

import java.util.Random;

/**
 * Created by Michalina on 29.12.2017.
 */

public class SoundService extends Service {
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Random mRand = new Random();
        int x = mRand.nextInt(5);
        switch (x) {
            case 0: {
                player = MediaPlayer.create(this, R.raw.m1); //select music file
                player.setLooping(true); //set looping
                break;
            }
            case 1: {
                player = MediaPlayer.create(this, R.raw.m2); //select music file
                player.setLooping(true); //set looping
                break;
            }
            case 2: {
                player = MediaPlayer.create(this, R.raw.m3); //select music file
                player.setLooping(true); //set looping
                break;
            }
            case 3: {
                player = MediaPlayer.create(this, R.raw.m4); //select music file
                player.setLooping(true); //set looping
                break;
            }
            case 4: {
                player = MediaPlayer.create(this, R.raw.m5); //select music file
                player.setLooping(true); //set looping
                break;
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
