package com.amritha.acadgild.android_session17_assignment1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Amritha on 4/2/18.
 */
public class MusicPlayerService extends Service {

    //Initializing Media player

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        //creating Media Player For the song
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();//starting Media player
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();//destroying Media Player
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
