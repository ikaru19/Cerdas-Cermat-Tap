package com.makeathon.hinglish.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.makeathon.hinglish.R;
import com.makeathon.hinglish.Utilities.SharedPreferenceMethods;

public class SinglePlayer_Username extends Activity{

    Button bt_savePlayerName, bt_enterName;
    EditText et_playerName;
    String s_playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        bt_savePlayerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s_playerName = et_playerName.getText().toString();

                if (s_playerName.equals("")) {
                    Toast.makeText(SinglePlayer_Username.this, "Maaf nama tidak bisa kosong!", Toast.LENGTH_SHORT).show();
                }
                else {
                    instructionDialog();
                }

            }
        });

    }

    void init() {
        setContentView(R.layout.activity_singleplayer_username);
        bt_savePlayerName = (Button)findViewById(R.id.bt_one_username_save);
        bt_enterName = (Button)findViewById(R.id.bt_one_username_entername);
        et_playerName =(EditText)findViewById(R.id.et_one_username_playerName);

        Typeface Mont = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-Bold.otf");
        bt_savePlayerName.setTypeface(Mont);
        bt_enterName.setTypeface(Mont);
        et_playerName.setTypeface(Mont);
    }

    void instructionDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SinglePlayer_Username.this);
        alertDialog.setTitle("Instructions");
        alertDialog.setMessage("Anda akan diberikan 5 pertanyaan tentang ilmu pengetahuan umum anda , hanya perlu menjawab ya atau tidak , Anda akan diberikan medal:\n\nBupati, \n\nGubernur atau \n\nPresiden.\n\nDan anda akan menerima level pertanyaan tergantung dari medal anda.");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferenceMethods.setString(getApplicationContext(), SharedPreferenceMethods.SINGLE_PLAYER_NAME, s_playerName);
                Intent i = new Intent(SinglePlayer_Username.this, SinglePlayer_Game.class);
                startActivity(i);
            }
        });
        alertDialog.show();
    }

}
