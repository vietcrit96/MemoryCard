package com.example.viet.appgamenhoanh;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class MenuStart extends AppCompatActivity {

    private ImageView ivStartGameButton;
    private ImageView ivOutGameButton;
    private ImageView ivBxh;
    private CheckBox cbMusicButton;


    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.menu_start );
        initWidget();
        mediaPlayer = MediaPlayer.create( this, R.raw.background_music );
        mediaPlayer.start();

    }


    public void initWidget() {

        ivStartGameButton = (ImageView) findViewById( R.id.start_game_button );
        ivOutGameButton = (ImageView) findViewById( R.id.out_game_button );
        ivBxh= (ImageView) findViewById( R.id.img_bxh );
        cbMusicButton = (CheckBox) findViewById( R.id.music_button );

        ivStartGameButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MenuStart.this, GameActivity.class );
                startActivity( intent );
            }
        } );
        ivBxh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MenuStart.this, HighScoreActivity.class );
                startActivity( intent );
            }
        } );
        ivOutGameButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        } );
        cbMusicButton.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mediaPlayer.stop();
                } else {
                    try {
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } );
    }

}




