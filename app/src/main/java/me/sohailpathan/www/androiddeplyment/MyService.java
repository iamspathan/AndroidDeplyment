package me.sohailpathan.www.androiddeplyment;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService  extends Service{
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Started" , Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this,R.raw.sun);
        mediaPlayer.setLooping(false);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Service Stopped " , Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped " , Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }
}
