package com.example.viet.appgamenhoanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class HighScoreActivity extends AppCompatActivity {
    private TextView tvLastScore, tvNameTop1, tvNameTop2, tvNameTop3, tvScoreTop1, tvScoreTop2, tvScoreTop3;
    private ImageView imgBackScore;
    private String lastScore= String.valueOf( 0 );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_highscore );
        tvLastScore = (TextView) findViewById( R.id.last_score );
        tvNameTop1 = (TextView) findViewById( R.id.name_best1 );
        tvNameTop2 = (TextView) findViewById( R.id.name_best2 );
        tvNameTop3 = (TextView) findViewById( R.id.name_best3 );
        tvScoreTop1 = (TextView) findViewById( R.id.score_best1 );
        tvScoreTop2 = (TextView) findViewById( R.id.score_best2 );
        tvScoreTop3 = (TextView) findViewById( R.id.score_best3 );
        imgBackScore = (ImageView) findViewById( R.id.back_high_score );

        int b1 = Integer.parseInt( tvScoreTop1.getText().toString() );
        int b2 = Integer.parseInt( tvScoreTop2.getText().toString() );
        int b3 = Integer.parseInt( tvScoreTop3.getText().toString() );
        String n1 = tvNameTop1.getText().toString();
        String n2 = tvNameTop2.getText().toString();

        Intent intent = getIntent();
        String name = intent.getStringExtra( WinView.NAME );
        lastScore = intent.getStringExtra( WinView.LASTSCORE );
        tvLastScore.setText( "Last Score : " + lastScore );


        if (b1 == 0) {
            tvNameTop1.setText( name );
            tvScoreTop1.setText( lastScore );
        }
        if (b1 != 0 && b2 == 0) {
            tvNameTop2.setText( name );
            tvScoreTop2.setText( lastScore );
        }
        if (b1 != 0 && b2 != 0 && b3 == 0) {
            tvNameTop3.setText( name );
            tvScoreTop3.setText( lastScore );
        }
        if (b1 != 0 && b2 != 0 && b3 != 0) {
            if (Integer.parseInt( lastScore ) > b3) {
                tvNameTop3.setText( name );
                tvScoreTop3.setText( Integer.parseInt( lastScore ) );
            }
            if (Integer.parseInt( lastScore ) > b2) {
                tvNameTop2.setText( name );
                tvScoreTop2.setText(Integer.parseInt( lastScore ));
                tvNameTop3.setText( n2 );
                tvScoreTop3.setText( b2 );
            }
            if (Integer.parseInt( lastScore ) > b1) {
                tvNameTop1.setText( name );
                tvScoreTop1.setText( Integer.parseInt( lastScore ) );
                tvNameTop2.setText( n1 );
                tvScoreTop2.setText( b1 );
                tvNameTop3.setText( n2 );
                tvScoreTop3.setText( b2 );
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
