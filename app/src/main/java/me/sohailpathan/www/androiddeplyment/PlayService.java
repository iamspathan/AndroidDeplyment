package me.sohailpathan.www.androiddeplyment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlayService extends AppCompatActivity {

    Button start, stop;
    Button getStart, getStop;
    TextView timestamp;
    LocalPrivate mbound;
    Boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_service);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        getStart = (Button) findViewById(R.id.timestart);
        getStop = (Button) findViewById(R.id.timestop);
        timestamp = (TextView) findViewById(R.id.timestamp);
        final Intent lt = new Intent(this, MyService.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(lt);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(lt);
            }
        });
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServiceBound) {
                    timestamp.setText(mbound.getTimeStamp());
                }
            }
        });

        getStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServiceBound) {
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                Intent intent = new Intent(PlayService.this, LocalPrivate.class);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(PlayService.this, LocalPrivate.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }

    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            LocalPrivate.MyBinder myBinder = (LocalPrivate.MyBinder) service;
            mbound = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;

        }
    };

}
