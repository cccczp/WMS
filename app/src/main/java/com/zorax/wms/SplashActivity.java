package com.zorax.wms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.zorax.wms.timer.CustomerCountDownTimer;
import com.zorax.wms.view.FullScreeView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {
    private FullScreeView mVideoView;
    private TextView mTextView;
    private CustomerCountDownTimer customerCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = findViewById(R.id.vv_play);
        mTextView = findViewById(R.id.text_time);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

          customerCountDownTimer = new CustomerCountDownTimer(5, new CustomerCountDownTimer.ICountDownTimer() {

            @Override
            public void onTicker(int time) {
                mTextView.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTextView.setText("跳过");
            }
        });
        customerCountDownTimer.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customerCountDownTimer.cancel();
    }
}
