package com.ttt.tictactoegame;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class settings extends AppCompatActivity {
    public MediaPlayer buttonclick;
    String username,password;
    ProgressDialog maindialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonclick=MediaPlayer.create(this,R.raw.buttonclick);
        Button square= (Button) findViewById(R.id.square);
        Button circle= (Button) findViewById(R.id.circle);
       username=getIntent().getExtras().getString("username");
        password=getIntent().getExtras().getString("password");


        maindialog=new ProgressDialog(settings.this);
        maindialog.setMessage("Logging in to server");
        maindialog.setTitle("Tic Tac Toe");
        maindialog.setProgressStyle(R.style.progress);
        maindialog.show();
        check_login();


        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),tilecolor.class);
                i.putExtra("shape","square");
                finish();
                startActivity(i);

            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),tilecolor.class);
                i.putExtra("shape","circle");
                finish();
                startActivity(i);
            }
        });

    }

    public void check_login() {


       final Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(username.toString().equals("test") && password.toString().equals("1234")){
                    maindialog.cancel();
                    display_dialog("Login successful");



                }
                else {
                    maindialog.cancel();
                    display_dialog1("Login Failed");
                }
            }
        },2000);


    }

    public void display_dialog(String message){


        AlertDialog.Builder alert=new AlertDialog.Builder(this,android.R.style.Theme_Material_Light_Dialog);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                }
        );

        AlertDialog a=alert.create();
        a.show();
    }

    public void display_dialog1(String message){


        AlertDialog.Builder alert=new AlertDialog.Builder(this,android.R.style.Theme_Material_Light_Dialog);
        alert.setMessage(message);
        alert.setCancelable(false);

        alert.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                        finish();
                    }
                }
        );

        AlertDialog a=alert.create();
        a.show();
    }
@Override
    public void onBackPressed() {
        super.onBackPressed();
    finish();
    startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
