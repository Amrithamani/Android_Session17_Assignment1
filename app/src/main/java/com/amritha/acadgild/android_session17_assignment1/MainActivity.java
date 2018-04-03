package com.amritha.acadgild.android_session17_assignment1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Initializing Buttons

    Button btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding views for buttons

        btnStartService = findViewById(R.id.buttonStartMusic);

        btnStopService = findViewById(R.id.buttonStopMusic);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starting the service by calling Music Player class

                startService(new Intent(MainActivity.this, MusicPlayerService.class));

                //Building Notification while playing the music

                Notification.Builder mBuilder = new Notification.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.song1)
                        .setContentTitle("1234 get on the dance floor")
                        .setContentText("Music is playing")

                        //pending Intent go to the App
                        .setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, getIntent(), 0));

                //show the notification to the user using Notification Manager

                NotificationManager mNotificationManager = (NotificationManager)

                        getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(

                        (int) System.currentTimeMillis(), // unique ID
                        mBuilder.getNotification());
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Stop the Music Player
                stopService(new Intent(MainActivity.this, MusicPlayerService.class));
            }
        });
    }
}
