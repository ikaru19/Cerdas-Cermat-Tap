package com.makeathon.hinglish.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.makeathon.hinglish.R;
import com.makeathon.hinglish.Utilities.SharedPreferenceMethods;

public class Welcome extends Activity {

    Button bt_learnGaming, bt_soundSwitch, bt_instructions, bt_setting, bt_1playerChallenge;
    MediaPlayer buttonPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        bt_learnGaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPop.start();
                Intent i = new Intent(Welcome.this, Username.class);
                startActivity(i);
            }
        });

        bt_1playerChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Welcome.this, SinglePlayer_Username.class);
            startActivity(i);
            }
        });

        bt_soundSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPop.start();
                String temp = SharedPreferenceMethods.getString(getApplicationContext(),SharedPreferenceMethods.SOUND);

                if (temp.equals("true")) {
                    bt_soundSwitch.setText("SOUND : OFF");
                    SharedPreferenceMethods.setString(getApplicationContext(), SharedPreferenceMethods.SOUND, "false");
                }
                else if (temp.equals("false")) {
                    bt_soundSwitch.setText("SOUND: ON");
                    SharedPreferenceMethods.setString(getApplicationContext(), SharedPreferenceMethods.SOUND, "true");
                }
            }
        });

        bt_instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPop.start();
                instructionsDialog();
            }
        });

        bt_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPop.start();
                aboutUsDialog();
            }
        });
    }

    void init() {
        setContentView(R.layout.activity_welcome);
        bt_learnGaming = (Button)findViewById(R.id.bt_welcome_learnGaming);
        bt_soundSwitch = (Button)findViewById(R.id.bt_welcome_soundSwitch);
        bt_instructions = (Button)findViewById(R.id.bt_welcome_Instructions);
        bt_setting = (Button)findViewById(R.id.bt_welcome_settings);
        bt_1playerChallenge = (Button)findViewById(R.id.bt_welcome_onePlayer_challenge);

        Typeface Mont = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-Bold.otf");
        bt_learnGaming.setTypeface(Mont);
        bt_soundSwitch.setTypeface(Mont);
        bt_instructions.setTypeface(Mont);
        bt_setting.setTypeface(Mont);
        bt_1playerChallenge.setTypeface(Mont);

        buttonPop = MediaPlayer.create(Welcome.this, R.raw.button_pop_sound);
        SharedPreferenceMethods.setString(getApplicationContext(), SharedPreferenceMethods.SOUND, "true");
    }

    void aboutUsDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Welcome.this);
        alertDialog.setTitle("Tentang");
        alertDialog.setMessage("Cerdas Cermat Tap ! adalah jalan interaktif dan menyenangkan untuk belajar ilmu pengetahuan umum. \n\nMusik yang menantang, Pertanyaan yang Menyenangkan.");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    void instructionsDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Welcome.this);
        alertDialog.setTitle("Instruksi");
        alertDialog.setMessage("Cerdas Cermat Tap ! adalah game seru dimana dua orang beradu seberapa cepat anda menjawab pertanyaan ilmu pengetahuan umum yang ada jawaban Ya atau Tidak\n\nYang menjawab terlebih dahulu yang mendapatkan point. Tiap Ronde nya ada 10 pertanyaan.");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

}
