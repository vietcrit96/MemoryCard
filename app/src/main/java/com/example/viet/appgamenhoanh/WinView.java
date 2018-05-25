package com.example.viet.appgamenhoanh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class WinView extends AppCompatActivity {
    private TextView tvTime, tvScore, tvStatus;
    private ImageView ivStar1, ivStar2, ivStar3;
    private EditText edtName;
    private Button btnSave;
    private ImageView ivAgain, ivBack;
    public static String NAME = "g3";
    public static String LASTSCORE = "g4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.win_view );
        initWidgets();
        doStuff();

    }

    public void initWidgets() {
        tvTime = (TextView) findViewById( R.id.time_text );
        tvScore = (TextView) findViewById( R.id.score_text );
        tvStatus = (TextView) findViewById( R.id.tv_status );

        ivStar1 = (ImageView) findViewById( R.id.star_1 );
        ivStar2 = (ImageView) findViewById( R.id.star_2 );
        ivStar3 = (ImageView) findViewById( R.id.star_3 );

        edtName = (EditText) findViewById( R.id.edt_name );
        btnSave = (Button) findViewById( R.id.btn_save );

        ivAgain = (ImageView) findViewById( R.id.button_again );
        ivBack = (ImageView) findViewById( R.id.button_back );
        ivBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( WinView.this, MenuStart.class );
                startActivity( intent );
            }
        } );
        ivAgain.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( WinView.this, GameActivity.class );
                startActivity( intent );
            }
        } );


        Intent intent = getIntent();
        String time = intent.getStringExtra( GameActivity.TIME );
        final String score = intent.getStringExtra( GameActivity.SCORE );
        tvTime.setText( time );
        tvScore.setText( score );


        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String lastScore = tvScore.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText( WinView.this, "Please input name before click this", Toast.LENGTH_SHORT ).show();
                } else {

                    Intent intent = new Intent( WinView.this, HighScoreActivity.class );
                    startActivity( intent );
                    byExtras( name, lastScore );
                }
            }
        } );
    }

    public void doStuff() {
        int t = Integer.parseInt( tvScore.getText().toString() );
        if (t == 0) {
            tvTime.setText( "00:00" );
        } else if (t > 0 && t <= 1000) {
            ivStar1.setVisibility( View.VISIBLE );
            tvTime.setText( "00:00" );
        } else if (t > 1000 && t <= 2000) {
            ivStar1.setVisibility( View.VISIBLE );
            ivStar2.setVisibility( View.VISIBLE );
            tvTime.setText( "00:00" );
        } else if (t == 2100) {
            ivStar1.setVisibility( View.VISIBLE );
            ivStar2.setVisibility( View.VISIBLE );
            ivStar3.setVisibility( View.VISIBLE );
            tvStatus.setText( "YOU WIN!" );
        }

    }

    public void byExtras(String name, String lastScore) {
        Intent intent = new Intent( WinView.this, HighScoreActivity.class );
        intent.putExtra( NAME, name );
        intent.putExtra( LASTSCORE, lastScore );
        startActivity( intent );
    }

}