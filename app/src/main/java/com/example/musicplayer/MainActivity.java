package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void play(View v){
        if (mediaPlayer == null){
            mediaPlayer=MediaPlayer.create(this,R.raw.music);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        mediaPlayer.start();
    }

    public void pause(View v){
        if (mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }

    public void stop (View v) {
        stopPlayer();
    }

    private void stopPlayer(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this,"Media Player released",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
