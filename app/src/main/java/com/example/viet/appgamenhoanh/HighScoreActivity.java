package com.example.viet.appgamenhoanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class HighScoreActivity extends AppCompatActivity {
    private TextView tvLastScore, tvNameBest1, tvNameBest2, tvNameBest3, tvScoreBest1, tvScoreBest2, tvScoreBest3;
    private ImageView imgBackScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_highscore );
        tvLastScore = (TextView) findViewById( R.id.last_score );
        tvNameBest1 = (TextView) findViewById( R.id.name_best1 );
        tvNameBest2 = (TextView) findViewById( R.id.name_best2 );
        tvNameBest3 = (TextView) findViewById( R.id.name_best3 );
        tvScoreBest1 = (TextView) findViewById( R.id.score_best1 );
        tvScoreBest2 = (TextView) findViewById( R.id.score_best2 );
        tvScoreBest3 = (TextView) findViewById( R.id.score_best3 );
        imgBackScore = (ImageView) findViewById( R.id.back_high_score );

        int b1 = Integer.parseInt( tvScoreBest1.getText().toString() );
        int b2 = Integer.parseInt( tvScoreBest2.getText().toString() );
        int b3 = Integer.parseInt( tvScoreBest3.getText().toString() );
        String n1 = tvNameBest1.getText().toString();
        String n2 = tvNameBest2.getText().toString();
        String n3 = tvNameBest3.getText().toString();

        Intent intent = getIntent();
        String name = intent.getStringExtra( WinView.NAME );
        String lastScore = intent.getStringExtra( WinView.LASTSCORE );
        tvLastScore.setText( "Last Score : " + lastScore );
        int b0 = Integer.parseInt( lastScore );


        if (b1 == 0) {
            tvNameBest1.setText( name );
            tvScoreBest1.setText( lastScore );
        }
        if (b1 != 0 && b2 == 0) {
            tvNameBest2.setText( name );
            tvScoreBest2.setText( lastScore );
        }
        if (b1 != 0 && b2 != 0 && b3 == 0) {
            tvNameBest3.setText( name );
            tvScoreBest3.setText( lastScore );
        }
        if (b1 != 0 && b2 != 0 && b3 != 0) {
            if (b0 > b3) {
                tvNameBest3.setText( name );
                tvScoreBest3.setText( b0 );
            }
            if (b0 > b2) {
                tvNameBest2.setText( name );
                tvScoreBest2.setText( b0 );
                tvNameBest3.setText( n2 );
                tvScoreBest3.setText( b2 );
            }
            if (b0 > b1) {
                tvNameBest1.setText( name );
                tvScoreBest1.setText( b0 );
                tvNameBest2.setText( n1 );
                tvScoreBest2.setText( b1 );
                tvNameBest3.setText( n2 );
                tvScoreBest3.setText( b2 );
            }

        }
        imgBackScore.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HighScoreActivity.this, MenuStart.class );
                startActivity( intent );
            }
        } );
    }

}
