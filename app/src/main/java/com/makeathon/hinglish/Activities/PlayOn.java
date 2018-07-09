package com.makeathon.hinglish.Activities;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.makeathon.hinglish.R;
import com.makeathon.hinglish.Utilities.SharedPreferenceMethods;

public class PlayOn extends AppCompatActivity {

    Button bt_test_yes, bt_test_no, bt_test_nextQuestion;
    TextView tv_test_question;
    String temp, currentAnswer;

    String globalBadge;

    int questionCount, correctAnswers =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        bt_test_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("yes");
            }
        });

        bt_test_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("no");
            }
        });



        bt_test_nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setQuestion(globalBadge);
            }
        });





    }


    void checkAnswer(String userAnswer) {

        if (userAnswer.equals(currentAnswer)){
            bt_test_nextQuestion.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            Toast.makeText(PlayOn.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            correctAnswers++;
        }
        else {
            Toast.makeText(PlayOn.this, "Oops! Wrong Answer", Toast.LENGTH_SHORT).show();
            bt_test_nextQuestion.setBackgroundColor(getResources().getColor(R.color.colorRed));
        }

        bt_test_nextQuestion.setVisibility(View.VISIBLE);
    }




    void init() {
        setContentView(R.layout.playon);
        bt_test_yes = (Button)findViewById(R.id.bt_playon_yes);
        bt_test_no = (Button)findViewById(R.id.bt_playon_no);
        bt_test_nextQuestion = (Button)findViewById(R.id.bt_playon_nextQuestion);
        tv_test_question = (TextView)findViewById(R.id.tv_playon_question);
        questionCount = 0;
        correctAnswers = 0;

        globalBadge = SharedPreferenceMethods.getString(getApplicationContext(), SharedPreferenceMethods.SINGLE_PLAYER_BADGE);
        setQuestion(globalBadge);


    }

    void setQuestion(String badge) {

        bt_test_nextQuestion.setVisibility(View.INVISIBLE);
        questionCount++;

        if (badge.equals("Bupati")) {


            if (questionCount == 1) {
                temp = "Apakah Soekarno presiden pertama Indonesia?";
                currentAnswer = "yes";
            }
            else if (questionCount == 2) {
                temp = "Apakah Ki Hajar Dewantoro bapak kesehatan indonesia ?";
                currentAnswer = "no";
            }
            else if (questionCount == 3) {
                temp = "Apakah Jakarta ibukota Indonesia ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 4) {
                temp = "Apakah kulit adalah indra untuk mengecap";
                currentAnswer = "no";
            }
            else if (questionCount == 5) {
                temp = "Apakah Belanda pernah menjajah Indonesia?";
                currentAnswer = "yes";
            }
            else if (questionCount == 6) {
                displayResult();
            }
            tv_test_question.setText(temp);



        }
        else if (badge.equals("Gubernur")) {



            if (questionCount == 1) {
                temp = "Apakah yuan mata uang Jepang ?";
                currentAnswer = "no";
            }
            else if (questionCount == 2) {
                temp = "Apakah elang jawa adalah burung tercepat di dunia ?";
                currentAnswer = "no";
            }
            else if (questionCount == 3) {
                temp = "Apakah Kurkumin terdapat dalam kunyit ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 4) {
                temp = "Apakah tulip berasal dari negara Turki ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 5) {
                temp = "Apakah Danau Toba adalah danau terluas di dunia ?";
                currentAnswer = "no";
            }
            else if (questionCount == 6) {
                displayResult();
            }
            tv_test_question.setText(temp);




        }
        else if (badge.equals("Presiden")) {



            if (questionCount == 1) {
                temp = "Apakah Gurindam disebut sajak dua simetri ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 2) {
                temp = "Apakah Tel Aviv Ibu Kota negara Israel ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 3) {
                temp = "Apakah Indonesia berbentuk Republik ?";
                currentAnswer = "yes";
            }
            else if (questionCount == 4) {
                temp = "Apakah angkor wat terletak di negara Thailand ?";
                currentAnswer = "no";
            }
            else if (questionCount == 5) {
                temp = "Apakah Patung Liberty dibuat di negara Amerika Serikat?";
                currentAnswer = "no";
            }
            else if (questionCount == 6) {
                displayResult();
            }
            tv_test_question.setText(temp);




        }
        else {
            Toast.makeText(PlayOn.this, "BC bug hai!!!", Toast.LENGTH_SHORT).show();
        }



    }

    void displayResult() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PlayOn.this);
        alertDialog.setTitle("Skor anda");
        alertDialog.setMessage("Selamat ! Skor anda " + correctAnswers);
        alertDialog.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(PlayOn.this, Welcome.class);
                startActivity(i);
            }
        });
        alertDialog.show();
    }





}
