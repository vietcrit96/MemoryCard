package com.example.viet.appgamenhoanh;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class GameActivity extends AppCompatActivity {
    private TextView tvTimeBarText,tvScoreText;
    private static final long START_TIME = 20000;
    private long timeLeft = START_TIME;

    private ImageView iv_11, iv_12, iv_13, iv_14, iv_15, iv_16,
            iv_21, iv_22, iv_23, iv_24, iv_25, iv_26,
            iv_31, iv_32, iv_33, iv_34, iv_35, iv_36,
            iv_41, iv_42, iv_43, iv_44, iv_45, iv_46,
            iv_51, iv_52, iv_53, iv_54, iv_55, iv_56,
            iv_61, iv_62, iv_63, iv_64, iv_65, iv_66,
            iv_71, iv_72, iv_73, iv_74, iv_75, iv_76;


    SoundPool musicCorrect = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );

    public static String SCORE = "g1";
    public static String TIME = "g2";

    //array image
    Integer[] cardArrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121


    };
    int emoji1, emoji2, emoji3, emoji4, emoji5, emoji6, emoji7, emoji8, emoji9, emoji10,
            emoji11, emoji12, emoji13, emoji14, emoji15, emoji16, emoji17, emoji18, emoji19, emoji20, emoji21,
            emoji101, emoji102, emoji103, emoji104, emoji105, emoji106, emoji107, emoji108, emoji109, emoji110,
            emoji111, emoji112, emoji113, emoji114, emoji115, emoji116, emoji117, emoji118, emoji119, emoji120, emoji121;

    public int firstCard; // luu lai la bai 1
    public int secondCard; // luu lai la bai 2
    public int firstClick, secondClick;
    public int cardNumber = 1;

    public int playerPoint = 0;
    public int idMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game );
        idMusic = musicCorrect.load( this, R.raw.correct_answer,1);
        initWidget();
        startTime();
        loadCards();
        Collections.shuffle( Arrays.asList( cardArrays ) );//dao the
        listenOnclickEvents();

    }

    public void initWidget() {
        tvTimeBarText = (TextView) findViewById( R.id.time_bar_text1 );
        tvScoreText = (TextView) findViewById( R.id.score_text1 );

        iv_11 = (ImageView) findViewById( R.id.iv_11 );
        iv_12 = (ImageView) findViewById( R.id.iv_12 );
        iv_13 = (ImageView) findViewById( R.id.iv_13 );
        iv_14 = (ImageView) findViewById( R.id.iv_14 );
        iv_15 = (ImageView) findViewById( R.id.iv_15 );
        iv_16 = (ImageView) findViewById( R.id.iv_16 );

        iv_21 = (ImageView) findViewById( R.id.iv_21 );
        iv_22 = (ImageView) findViewById( R.id.iv_22 );
        iv_23 = (ImageView) findViewById( R.id.iv_23 );
        iv_24 = (ImageView) findViewById( R.id.iv_24 );
        iv_25 = (ImageView) findViewById( R.id.iv_25 );
        iv_26 = (ImageView) findViewById( R.id.iv_26 );

        iv_31 = (ImageView) findViewById( R.id.iv_31 );
        iv_32 = (ImageView) findViewById( R.id.iv_32 );
        iv_33 = (ImageView) findViewById( R.id.iv_33 );
        iv_34 = (ImageView) findViewById( R.id.iv_34 );
        iv_35 = (ImageView) findViewById( R.id.iv_35 );
        iv_36 = (ImageView) findViewById( R.id.iv_36 );

        iv_41 = (ImageView) findViewById( R.id.iv_41 );
        iv_42 = (ImageView) findViewById( R.id.iv_42 );
        iv_43 = (ImageView) findViewById( R.id.iv_43 );
        iv_44 = (ImageView) findViewById( R.id.iv_44 );
        iv_45 = (ImageView) findViewById( R.id.iv_45 );
        iv_46 = (ImageView) findViewById( R.id.iv_46 );

        iv_51 = (ImageView) findViewById( R.id.iv_51 );
        iv_52 = (ImageView) findViewById( R.id.iv_52 );
        iv_53 = (ImageView) findViewById( R.id.iv_53 );
        iv_54 = (ImageView) findViewById( R.id.iv_54 );
        iv_55 = (ImageView) findViewById( R.id.iv_55 );
        iv_56 = (ImageView) findViewById( R.id.iv_56 );

        iv_61 = (ImageView) findViewById( R.id.iv_61 );
        iv_62 = (ImageView) findViewById( R.id.iv_62 );
        iv_63 = (ImageView) findViewById( R.id.iv_63 );
        iv_64 = (ImageView) findViewById( R.id.iv_64 );
        iv_65 = (ImageView) findViewById( R.id.iv_65 );
        iv_66 = (ImageView) findViewById( R.id.iv_66 );

        iv_71 = (ImageView) findViewById( R.id.iv_71 );
        iv_72 = (ImageView) findViewById( R.id.iv_72 );
        iv_73 = (ImageView) findViewById( R.id.iv_73 );
        iv_74 = (ImageView) findViewById( R.id.iv_74 );
        iv_75 = (ImageView) findViewById( R.id.iv_75 );
        iv_76 = (ImageView) findViewById( R.id.iv_76 );

        iv_11.setTag( "0" );
        iv_12.setTag( "1" );
        iv_13.setTag( "2" );
        iv_14.setTag( "3" );
        iv_15.setTag( "4" );
        iv_16.setTag( "5" );

        iv_21.setTag( "6" );
        iv_22.setTag( "7" );
        iv_23.setTag( "8" );
        iv_24.setTag( "9" );
        iv_25.setTag( "10" );
        iv_26.setTag( "11" );

        iv_31.setTag( "12" );
        iv_32.setTag( "13" );
        iv_33.setTag( "14" );
        iv_34.setTag( "15" );
        iv_35.setTag( "16" );
        iv_36.setTag( "17" );

        iv_41.setTag( "18" );
        iv_42.setTag( "19" );
        iv_43.setTag( "20" );
        iv_44.setTag( "21" );
        iv_45.setTag( "22" );
        iv_46.setTag( "23" );

        iv_51.setTag( "24" );
        iv_52.setTag( "25" );
        iv_53.setTag( "26" );
        iv_54.setTag( "27" );
        iv_55.setTag( "28" );
        iv_56.setTag( "29" );

        iv_61.setTag( "30" );
        iv_62.setTag( "31" );
        iv_63.setTag( "32" );
        iv_64.setTag( "33" );
        iv_65.setTag( "34" );
        iv_66.setTag( "35" );

        iv_71.setTag( "36" );
        iv_72.setTag( "37" );
        iv_73.setTag( "38" );
        iv_74.setTag( "39" );
        iv_75.setTag( "40" );
        iv_76.setTag( "41" );
    }

    public void startTime() {
        CountDownTimer countDownTimer = new CountDownTimer( timeLeft, 1020 ) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent( GameActivity.this, WinView.class );
                startActivity( intent );
                String time = tvTimeBarText.getText().toString();
                String score = tvScoreText.getText().toString();
                byExtras( time, score );
            }
        }.start();
    }

    public void updateCountDownText() {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;
        String timeFormat = String.format( Locale.getDefault(), "%02d:%02d", minutes, seconds );
        tvTimeBarText.setText( timeFormat );
    }

    public void loadCards() {
        emoji1 = R.drawable.emoji_1;
        emoji2 = R.drawable.emoji_2;
        emoji3 = R.drawable.emoji_3;
        emoji4 = R.drawable.emoji_4;
        emoji5 = R.drawable.emoji_5;
        emoji6 = R.drawable.emoji_6;
        emoji7 = R.drawable.emoji_7;
        emoji8 = R.drawable.emoji_8;
        emoji9 = R.drawable.emoji_9;
        emoji10 = R.drawable.emoji_10;

        emoji11 = R.drawable.emoji_11;
        emoji12 = R.drawable.emoji_12;
        emoji13 = R.drawable.emoji_13;
        emoji14 = R.drawable.emoji_14;
        emoji15 = R.drawable.emoji_15;
        emoji16 = R.drawable.emoji_16;
        emoji17 = R.drawable.emoji_17;
        emoji18 = R.drawable.emoji_18;
        emoji19 = R.drawable.emoji_19;
        emoji20 = R.drawable.emoji_20;
        emoji21 = R.drawable.emoji_21;

        emoji101 = R.drawable.emoji_101;
        emoji102 = R.drawable.emoji_102;
        emoji103 = R.drawable.emoji_103;
        emoji101 = R.drawable.emoji_104;
        emoji102 = R.drawable.emoji_105;
        emoji103 = R.drawable.emoji_106;
        emoji107 = R.drawable.emoji_107;
        emoji108 = R.drawable.emoji_108;
        emoji109 = R.drawable.emoji_109;
        emoji110 = R.drawable.emoji_110;

        emoji111 = R.drawable.emoji_111;
        emoji112 = R.drawable.emoji_112;
        emoji113 = R.drawable.emoji_113;
        emoji114 = R.drawable.emoji_114;
        emoji115 = R.drawable.emoji_115;
        emoji116 = R.drawable.emoji_116;
        emoji117 = R.drawable.emoji_117;
        emoji118 = R.drawable.emoji_118;
        emoji119 = R.drawable.emoji_119;
        emoji120 = R.drawable.emoji_120;
        emoji121 = R.drawable.emoji_121;

    }

    public void listenOnclickEvents() {
        iv_11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_11, theCard );
            }
        } );
        iv_12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_12, theCard );
            }
        } );
        iv_13.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_13, theCard );
            }
        } );
        iv_14.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_14, theCard );
            }
        } );
        iv_15.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_15, theCard );
            }
        } );
        iv_16.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_16, theCard );
            }
        } );
        iv_21.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_21, theCard );
            }
        } );
        iv_22.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_22, theCard );
            }
        } );
        iv_23.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_23, theCard );
            }
        } );
        iv_24.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_24, theCard );
            }
        } );
        iv_25.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_25, theCard );
            }
        } );
        iv_26.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_26, theCard );
            }
        } );
        iv_31.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_31, theCard );
            }
        } );
        iv_32.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_32, theCard );
            }
        } );
        iv_33.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_33, theCard );
            }
        } );
        iv_34.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_34, theCard );
            }
        } );
        iv_35.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_35, theCard );
            }
        } );
        iv_36.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_36, theCard );
            }
        } );
        iv_41.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_41, theCard );
            }
        } );
        iv_42.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_42, theCard );
            }
        } );
        iv_43.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_43, theCard );
            }
        } );
        iv_44.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_44, theCard );
            }
        } );
        iv_45.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_45, theCard );
            }
        } );
        iv_46.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_46, theCard );
            }
        } );
        iv_51.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_51, theCard );
            }
        } );
        iv_52.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_52, theCard );
            }
        } );
        iv_53.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_53, theCard );
            }
        } );
        iv_54.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_54, theCard );
            }
        } );
        iv_55.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_55, theCard );
            }
        } );
        iv_56.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_56, theCard );
            }
        } );
        iv_61.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_61, theCard );
            }
        } );
        iv_62.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_62, theCard );
            }
        } );
        iv_63.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_63, theCard );
            }
        } );
        iv_64.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_64, theCard );
            }
        } );
        iv_65.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_65, theCard );
            }
        } );
        iv_66.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_66, theCard );
            }
        } );
        iv_71.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_71, theCard );
            }
        } );
        iv_72.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_72, theCard );
            }
        } );
        iv_73.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_73, theCard );
            }
        } );
        iv_74.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_74, theCard );
            }
        } );
        iv_75.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_75, theCard );
            }
        } );
        iv_76.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt( (String) v.getTag() );
                doStuff( iv_76, theCard );
            }
        } );

    }

    public void doStuff(ImageView iv, int card) {
        if (cardArrays[card] == 1) {
            iv.setImageResource( emoji1 );
        } else if (cardArrays[card] == 2) {
            iv.setImageResource( emoji2 );
        } else if (cardArrays[card] == 3) {
            iv.setImageResource( emoji3 );
        } else if (cardArrays[card] == 4) {
            iv.setImageResource( emoji4 );
        } else if (cardArrays[card] == 5) {
            iv.setImageResource( emoji5 );
        } else if (cardArrays[card] == 6) {
            iv.setImageResource( emoji6 );
        } else if (cardArrays[card] == 7) {
            iv.setImageResource( emoji7 );
        } else if (cardArrays[card] == 8) {
            iv.setImageResource( emoji8 );
        } else if (cardArrays[card] == 9) {
            iv.setImageResource( emoji9 );
        } else if (cardArrays[card] == 10) {
            iv.setImageResource( emoji10 );
        }
        //1x
        else if (cardArrays[card] == 11) {
            iv.setImageResource( emoji11 );
        } else if (cardArrays[card] == 12) {
            iv.setImageResource( emoji12 );
        } else if (cardArrays[card] == 13) {
            iv.setImageResource( emoji13 );
        } else if (cardArrays[card] == 14) {
            iv.setImageResource( emoji14 );
        } else if (cardArrays[card] == 15) {
            iv.setImageResource( emoji15 );
        } else if (cardArrays[card] == 16) {
            iv.setImageResource( emoji16 );
        } else if (cardArrays[card] == 17) {
            iv.setImageResource( emoji17 );
        } else if (cardArrays[card] == 18) {
            iv.setImageResource( emoji18 );
        } else if (cardArrays[card] == 19) {
            iv.setImageResource( emoji19 );
        } else if (cardArrays[card] == 20) {
            iv.setImageResource( emoji20 );
        } else if (cardArrays[card] == 21) {
            iv.setImageResource( emoji21 );
        } else if (cardArrays[card] == 101) {
            iv.setImageResource( emoji1 );
        } else if (cardArrays[card] == 102) {
            iv.setImageResource( emoji2 );
        } else if (cardArrays[card] == 103) {
            iv.setImageResource( emoji3 );
        } else if (cardArrays[card] == 104) {
            iv.setImageResource( emoji4 );
        } else if (cardArrays[card] == 105) {
            iv.setImageResource( emoji5 );
        } else if (cardArrays[card] == 106) {
            iv.setImageResource( emoji6 );
        } else if (cardArrays[card] == 107) {
            iv.setImageResource( emoji7 );
        } else if (cardArrays[card] == 108) {
            iv.setImageResource( emoji8 );
        } else if (cardArrays[card] == 109) {
            iv.setImageResource( emoji9 );
        } else if (cardArrays[card] == 110) {
            iv.setImageResource( emoji10 );
        }
        //1x
        else if (cardArrays[card] == 111) {
            iv.setImageResource( emoji11 );
        } else if (cardArrays[card] == 112) {
            iv.setImageResource( emoji12 );
        } else if (cardArrays[card] == 113) {
            iv.setImageResource( emoji13 );
        } else if (cardArrays[card] == 114) {
            iv.setImageResource( emoji14 );
        } else if (cardArrays[card] == 115) {
            iv.setImageResource( emoji15 );
        } else if (cardArrays[card] == 116) {
            iv.setImageResource( emoji16 );
        } else if (cardArrays[card] == 117) {
            iv.setImageResource( emoji17 );
        } else if (cardArrays[card] == 118) {
            iv.setImageResource( emoji18 );
        } else if (cardArrays[card] == 119) {
            iv.setImageResource( emoji19 );
        } else if (cardArrays[card] == 120) {
            iv.setImageResource( emoji20 );
        } else if (cardArrays[card] == 121) {
            iv.setImageResource( emoji21 );
        }

//card luu anh
        if (cardNumber == 1) {
            firstCard = cardArrays[card];
            if (firstCard > 100) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            firstClick = card;

            iv.setEnabled( false );
        } else if (cardNumber == 2) {
            secondCard = cardArrays[card];
            if (secondCard > 100) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            secondClick = card;

            iv_11.setEnabled( false );
            iv_12.setEnabled( false );
            iv_13.setEnabled( false );
            iv_14.setEnabled( false );
            iv_15.setEnabled( false );
            iv_16.setEnabled( false );

            iv_21.setEnabled( false );
            iv_22.setEnabled( false );
            iv_23.setEnabled( false );
            iv_24.setEnabled( false );
            iv_25.setEnabled( false );
            iv_26.setEnabled( false );

            iv_31.setEnabled( false );
            iv_32.setEnabled( false );
            iv_33.setEnabled( false );
            iv_34.setEnabled( false );
            iv_35.setEnabled( false );
            iv_36.setEnabled( false );

            iv_41.setEnabled( false );
            iv_42.setEnabled( false );
            iv_43.setEnabled( false );
            iv_44.setEnabled( false );
            iv_45.setEnabled( false );
            iv_46.setEnabled( false );

            iv_51.setEnabled( false );
            iv_52.setEnabled( false );
            iv_53.setEnabled( false );
            iv_54.setEnabled( false );
            iv_55.setEnabled( false );
            iv_56.setEnabled( false );

            iv_61.setEnabled( false );
            iv_62.setEnabled( false );
            iv_63.setEnabled( false );
            iv_64.setEnabled( false );
            iv_65.setEnabled( false );
            iv_66.setEnabled( false );

            iv_71.setEnabled( false );
            iv_72.setEnabled( false );
            iv_73.setEnabled( false );
            iv_74.setEnabled( false );
            iv_75.setEnabled( false );
            iv_76.setEnabled( false );

            Handler handler = new Handler();
            handler.postDelayed( new Runnable() {
                @Override
                public void run() {
                    caculator();
                }
            }, 400 );
        }
    }
//so sanh
    public void caculator() {
        if (firstCard == secondCard) {
            if (firstClick == 0) {
                iv_11.setVisibility( View.INVISIBLE );
            } else if (firstClick == 1) {
                iv_12.setVisibility( View.INVISIBLE );
            } else if (firstClick == 2) {
                iv_13.setVisibility( View.INVISIBLE );
            } else if (firstClick == 3) {
                iv_14.setVisibility( View.INVISIBLE );
            } else if (firstClick == 4) {
                iv_15.setVisibility( View.INVISIBLE );
            } else if (firstClick == 5) {
                iv_16.setVisibility( View.INVISIBLE );
            } else if (firstClick == 6) {
                iv_21.setVisibility( View.INVISIBLE );
            } else if (firstClick == 7) {
                iv_22.setVisibility( View.INVISIBLE );
            } else if (firstClick == 8) {
                iv_23.setVisibility( View.INVISIBLE );
            } else if (firstClick == 9) {
                iv_24.setVisibility( View.INVISIBLE );
            } else if (firstClick == 10) {
                iv_25.setVisibility( View.INVISIBLE );
            } else if (firstClick == 11) {
                iv_26.setVisibility( View.INVISIBLE );
            }else if (firstClick == 12) {
                iv_31.setVisibility( View.INVISIBLE );
            } else if (firstClick == 13) {
                iv_32.setVisibility( View.INVISIBLE );
            } else if (firstClick == 14) {
                iv_33.setVisibility( View.INVISIBLE );
            } else if (firstClick == 15) {
                iv_34.setVisibility( View.INVISIBLE );
            } else if (firstClick == 16) {
                iv_35.setVisibility( View.INVISIBLE );
            } else if (firstClick == 17) {
                iv_36.setVisibility( View.INVISIBLE );
            }else if (firstClick == 18) {
                iv_41.setVisibility( View.INVISIBLE );
            } else if (firstClick == 19) {
                iv_42.setVisibility( View.INVISIBLE );
            } else if (firstClick == 20) {
                iv_43.setVisibility( View.INVISIBLE );
            } else if (firstClick == 21) {
                iv_44.setVisibility( View.INVISIBLE );
            } else if (firstClick == 22) {
                iv_45.setVisibility( View.INVISIBLE );
            } else if (firstClick == 23) {
                iv_46.setVisibility( View.INVISIBLE );
            }else if (firstClick == 24) {
                iv_51.setVisibility( View.INVISIBLE );
            } else if (firstClick == 25) {
                iv_52.setVisibility( View.INVISIBLE );
            } else if (firstClick == 26) {
                iv_53.setVisibility( View.INVISIBLE );
            } else if (firstClick == 27) {
                iv_54.setVisibility( View.INVISIBLE );
            } else if (firstClick == 28) {
                iv_55.setVisibility( View.INVISIBLE );
            } else if (firstClick == 29) {
                iv_56.setVisibility( View.INVISIBLE );
            }else if (firstClick == 30) {
                iv_61.setVisibility( View.INVISIBLE );
            } else if (firstClick == 31) {
                iv_62.setVisibility( View.INVISIBLE );
            } else if (firstClick == 32) {
                iv_63.setVisibility( View.INVISIBLE );
            } else if (firstClick == 33) {
                iv_64.setVisibility( View.INVISIBLE );
            } else if (firstClick == 34) {
                iv_65.setVisibility( View.INVISIBLE );
            } else if (firstClick == 35) {
                iv_66.setVisibility( View.INVISIBLE );
            }else if (firstClick == 36) {
                iv_71.setVisibility( View.INVISIBLE );
            } else if (firstClick == 37) {
                iv_72.setVisibility( View.INVISIBLE );
            } else if (firstClick == 38) {
                iv_73.setVisibility( View.INVISIBLE );
            } else if (firstClick == 39) {
                iv_74.setVisibility( View.INVISIBLE );
            } else if (firstClick == 40) {
                iv_75.setVisibility( View.INVISIBLE );
            } else if (firstClick == 41) {
                iv_76.setVisibility( View.INVISIBLE );
            }

            if (secondClick == 0) {
                iv_11.setVisibility( View.INVISIBLE );
            } else if (secondClick == 1) {
                iv_12.setVisibility( View.INVISIBLE );
            } else if (secondClick == 2) {
                iv_13.setVisibility( View.INVISIBLE );
            } else if (secondClick == 3) {
                iv_14.setVisibility( View.INVISIBLE );
            } else if (secondClick == 4) {
                iv_15.setVisibility( View.INVISIBLE );
            } else if (secondClick == 5) {
                iv_16.setVisibility( View.INVISIBLE );
            } else if (secondClick == 6) {
                iv_21.setVisibility( View.INVISIBLE );
            } else if (secondClick == 7) {
                iv_22.setVisibility( View.INVISIBLE );
            } else if (secondClick == 8) {
                iv_23.setVisibility( View.INVISIBLE );
            } else if (secondClick == 9) {
                iv_24.setVisibility( View.INVISIBLE );
            } else if (secondClick == 10) {
                iv_25.setVisibility( View.INVISIBLE );
            } else if (secondClick == 11) {
                iv_26.setVisibility( View.INVISIBLE );
            }else if (secondClick == 12) {
                iv_31.setVisibility( View.INVISIBLE );
            } else if (secondClick == 13) {
                iv_32.setVisibility( View.INVISIBLE );
            } else if (secondClick == 14) {
                iv_33.setVisibility( View.INVISIBLE );
            } else if (secondClick == 15) {
                iv_34.setVisibility( View.INVISIBLE );
            } else if (secondClick == 16) {
                iv_35.setVisibility( View.INVISIBLE );
            } else if (secondClick == 17) {
                iv_36.setVisibility( View.INVISIBLE );
            }else if (secondClick == 18) {
                iv_41.setVisibility( View.INVISIBLE );
            } else if (secondClick == 19) {
                iv_42.setVisibility( View.INVISIBLE );
            } else if (secondClick == 20) {
                iv_43.setVisibility( View.INVISIBLE );
            } else if (secondClick == 21) {
                iv_44.setVisibility( View.INVISIBLE );
            } else if (secondClick == 22) {
                iv_45.setVisibility( View.INVISIBLE );
            } else if (secondClick == 23) {
                iv_46.setVisibility( View.INVISIBLE );
            }else if (secondClick == 24) {
                iv_51.setVisibility( View.INVISIBLE );
            } else if (secondClick == 25) {
                iv_52.setVisibility( View.INVISIBLE );
            } else if (secondClick == 26) {
                iv_53.setVisibility( View.INVISIBLE );
            } else if (secondClick == 27) {
                iv_54.setVisibility( View.INVISIBLE );
            } else if (secondClick == 28) {
                iv_55.setVisibility( View.INVISIBLE );
            } else if (secondClick == 29) {
                iv_56.setVisibility( View.INVISIBLE );
            }else if (secondClick == 30) {
                iv_61.setVisibility( View.INVISIBLE );
            } else if (secondClick == 31) {
                iv_62.setVisibility( View.INVISIBLE );
            } else if (secondClick == 32) {
                iv_63.setVisibility( View.INVISIBLE );
            } else if (secondClick == 33) {
                iv_64.setVisibility( View.INVISIBLE );
            } else if (secondClick == 34) {
                iv_65.setVisibility( View.INVISIBLE );
            } else if (secondClick == 35) {
                iv_66.setVisibility( View.INVISIBLE );
            }else if (secondClick == 36) {
                iv_71.setVisibility( View.INVISIBLE );
            } else if (secondClick == 37) {
                iv_72.setVisibility( View.INVISIBLE );
            } else if (secondClick == 38) {
                iv_73.setVisibility( View.INVISIBLE );
            } else if (secondClick == 39) {
                iv_74.setVisibility( View.INVISIBLE );
            } else if (secondClick == 40) {
                iv_75.setVisibility( View.INVISIBLE );
            } else if (secondClick == 41) {
                iv_76.setVisibility( View.INVISIBLE );
            }


            playerPoint = playerPoint + 100;
            tvScoreText.setText( "" + playerPoint );
            musicCorrect.play( idMusic, 1.0f, 1.0f, 1, 0, 1.0f );

        } else {

            iv_11.setImageResource( R.drawable.backcard );
            iv_12.setImageResource( R.drawable.backcard );
            iv_13.setImageResource( R.drawable.backcard );
            iv_14.setImageResource( R.drawable.backcard );
            iv_15.setImageResource( R.drawable.backcard );
            iv_16.setImageResource( R.drawable.backcard );

            iv_21.setImageResource( R.drawable.backcard );
            iv_22.setImageResource( R.drawable.backcard );
            iv_23.setImageResource( R.drawable.backcard );
            iv_24.setImageResource( R.drawable.backcard );
            iv_25.setImageResource( R.drawable.backcard );
            iv_26.setImageResource( R.drawable.backcard );

            iv_31.setImageResource( R.drawable.backcard );
            iv_32.setImageResource( R.drawable.backcard );
            iv_33.setImageResource( R.drawable.backcard );
            iv_34.setImageResource( R.drawable.backcard );
            iv_35.setImageResource( R.drawable.backcard );
            iv_36.setImageResource( R.drawable.backcard );

            iv_41.setImageResource( R.drawable.backcard );
            iv_42.setImageResource( R.drawable.backcard );
            iv_43.setImageResource( R.drawable.backcard );
            iv_44.setImageResource( R.drawable.backcard );
            iv_45.setImageResource( R.drawable.backcard );
            iv_46.setImageResource( R.drawable.backcard );

            iv_51.setImageResource( R.drawable.backcard );
            iv_52.setImageResource( R.drawable.backcard );
            iv_53.setImageResource( R.drawable.backcard );
            iv_54.setImageResource( R.drawable.backcard );
            iv_55.setImageResource( R.drawable.backcard );
            iv_56.setImageResource( R.drawable.backcard );

            iv_61.setImageResource( R.drawable.backcard );
            iv_62.setImageResource( R.drawable.backcard );
            iv_63.setImageResource( R.drawable.backcard );
            iv_64.setImageResource( R.drawable.backcard );
            iv_65.setImageResource( R.drawable.backcard );
            iv_66.setImageResource( R.drawable.backcard );

            iv_71.setImageResource( R.drawable.backcard );
            iv_72.setImageResource( R.drawable.backcard );
            iv_73.setImageResource( R.drawable.backcard );
            iv_74.setImageResource( R.drawable.backcard );
            iv_75.setImageResource( R.drawable.backcard );
            iv_76.setImageResource( R.drawable.backcard );
        }
        iv_11.setEnabled( true );
        iv_12.setEnabled( true );
        iv_13.setEnabled( true );
        iv_14.setEnabled( true );
        iv_15.setEnabled( true );
        iv_16.setEnabled( true );

        iv_21.setEnabled( true );
        iv_22.setEnabled( true );
        iv_23.setEnabled( true );
        iv_24.setEnabled( true );
        iv_25.setEnabled( true );
        iv_26.setEnabled( true );

        iv_31.setEnabled( true );
        iv_32.setEnabled( true );
        iv_33.setEnabled( true );
        iv_34.setEnabled( true );
        iv_35.setEnabled( true );
        iv_36.setEnabled( true );

        iv_41.setEnabled( true );
        iv_42.setEnabled( true );
        iv_43.setEnabled( true );
        iv_44.setEnabled( true );
        iv_45.setEnabled( true );
        iv_46.setEnabled( true );

        iv_51.setEnabled( true );
        iv_52.setEnabled( true );
        iv_53.setEnabled( true );
        iv_54.setEnabled( true );
        iv_55.setEnabled( true );
        iv_56.setEnabled( true );

        iv_61.setEnabled( true );
        iv_62.setEnabled( true );
        iv_63.setEnabled( true );
        iv_64.setEnabled( true );
        iv_65.setEnabled( true );
        iv_66.setEnabled( true );

        iv_71.setEnabled( true );
        iv_72.setEnabled( true );
        iv_73.setEnabled( true );
        iv_74.setEnabled( true );
        iv_75.setEnabled( true );
        iv_76.setEnabled( true );

        checkEnd();
    }

    public void checkEnd() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_15.getVisibility() == View.INVISIBLE &&
                iv_16.getVisibility() == View.INVISIBLE &&

                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_25.getVisibility() == View.INVISIBLE &&
                iv_26.getVisibility() == View.INVISIBLE &&

                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_35.getVisibility() == View.INVISIBLE &&
                iv_36.getVisibility() == View.INVISIBLE &&

                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE &&
                iv_45.getVisibility() == View.INVISIBLE &&
                iv_46.getVisibility() == View.INVISIBLE &&

                iv_51.getVisibility() == View.INVISIBLE &&
                iv_52.getVisibility() == View.INVISIBLE &&
                iv_53.getVisibility() == View.INVISIBLE &&
                iv_54.getVisibility() == View.INVISIBLE &&
                iv_55.getVisibility() == View.INVISIBLE &&
                iv_56.getVisibility() == View.INVISIBLE &&

                iv_61.getVisibility() == View.INVISIBLE &&
                iv_62.getVisibility() == View.INVISIBLE &&
                iv_63.getVisibility() == View.INVISIBLE &&
                iv_64.getVisibility() == View.INVISIBLE &&
                iv_65.getVisibility() == View.INVISIBLE &&
                iv_66.getVisibility() == View.INVISIBLE &&

                iv_71.getVisibility() == View.INVISIBLE &&
                iv_72.getVisibility() == View.INVISIBLE &&
                iv_73.getVisibility() == View.INVISIBLE &&
                iv_74.getVisibility() == View.INVISIBLE &&
                iv_75.getVisibility() == View.INVISIBLE &&
                iv_76.getVisibility() == View.INVISIBLE) {
            Intent intent = new Intent( GameActivity.this, WinView.class );
            startActivity( intent );

            String time = tvTimeBarText.getText().toString();
            String score = tvScoreText.getText().toString();
            byExtras( time, score );
        }
    }

    public void byExtras(String time, String score) {
        Intent intent = new Intent( GameActivity.this, WinView.class );
        intent.putExtra( TIME, time );
        intent.putExtra( SCORE, score );
        startActivity( intent );
    }

}
