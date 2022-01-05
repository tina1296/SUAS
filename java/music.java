package com.example.plz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class music extends Service {
    //서비스(음악 재생)구현.
    private static final String TAG = "MusicService";
    MediaPlayer music;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //음악 재생기를 생성(서비스가 처음 시작)
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        music = MediaPlayer.create(this, R.raw.whatever);
        music.setLooping(false);
    }

    //서비스가 시작되면 음악 재생 시작.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "음악연동이 되었습니다.(Imagine Dragons-Whatever it takes)", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart()");
        music.start();
        return super.onStartCommand(intent, flags, startId);
    }

    //서비스가 중지되면 음악 중단.
    @Override
    public void onDestroy() {
        Toast.makeText(this, "음악연동이 취소되었습니다.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy()");
        music.stop();
    }


}
