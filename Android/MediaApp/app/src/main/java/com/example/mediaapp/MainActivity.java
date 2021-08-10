package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button play,pause;
    SeekBar seekbar;
    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        seekbar=(SeekBar)findViewById(R.id.seek);
        //local source
       // mediaplayer=MediaPlayer.create(this,R.raw.t1);

        //remote source
        mediaplayer=new MediaPlayer();
        try {
            mediaplayer.setDataSource("https://pagalfree.com/download/192-Khulke%20Jeene%20Ka%20-%20Dil%20Bechara%20192%20Kbps.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this,"Ready to play",Toast.LENGTH_LONG).show();
                mediaPlayer.start();
                seekbar.setMax(mediaPlayer.getDuration());
                seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        //if(b)       //b=from user
                            mediaPlayer.seekTo(i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
        mediaplayer.prepareAsync();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer.pause();
            }
        });

    }
}