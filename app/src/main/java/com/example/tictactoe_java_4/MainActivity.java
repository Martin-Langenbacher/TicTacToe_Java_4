package com.example.tictactoe_java_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView f11, f12, f13, f21, f22, f23, f31, f32, f33;
    String currentPlayer = "X";
    int[][] gameStorage;
    private TextView statusText;
    String gameState = "playing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // idHeadline ist der Head-Line-String !
        statusText = findViewById(R.id.idHeadline);

        f11 = findViewById(R.id.f0);
        f12 = findViewById(R.id.f1);
        f13 = findViewById(R.id.f2);
        f21 = findViewById(R.id.f3);
        f22 = findViewById(R.id.f4);
        f23 = findViewById(R.id.f5);
        f31 = findViewById(R.id.f6);
        f32 = findViewById(R.id.f7);
        f33 = findViewById(R.id.f8);

        f11.setOnClickListener(this);
        f12.setOnClickListener(this);
        f13.setOnClickListener(this);
        f21.setOnClickListener(this);
        f22.setOnClickListener(this);
        f23.setOnClickListener(this);
        f31.setOnClickListener(this);
        f32.setOnClickListener(this);
        f33.setOnClickListener(this);

        gameStorage = new int[3][3];

    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        // Start bei Click...
        if (gameState == "won"){
            finishGame();
        }






        //Wie kann ich herausfinden, ob ein Feld leer ist - oder was darin steht?
        //statusText.setText(currentPlayer + " und f33.getText... " + f33.getText());
        //statusText.setText("Spieler " +currentPlayer + " ist an der Reihe");

        // wir tun nur etwas, wenn 1) das Feld leer ist UND das Spiel auf "playing" steht!
        if (gameState == "playing"){
            switch (v.getId()){
                case R.id.f0:
                   //statusText.setText("Feld 1 ausgeben: ==>" +f11.getText() + v.textv.getChildtable.getChildAt(i);..toString() + "<== Ende Feld 1");
                    if(f11.getText() == ""){
                        f11.setText(currentPlayer);
                        handleInput(1, 1);
                    }
                    break;
                    
                case R.id.f1:
                    if(f12.getText() == ""){
                        f12.setText(currentPlayer);
                        handleInput(1, 2);
                    }
                    break;

                case R.id.f2:
                    if(f13.getText() == ""){
                        f13.setText(currentPlayer);
                        handleInput(1, 3);
                    }
                    break;

                case R.id.f3:
                    if(f21.getText() == ""){
                        f21.setText(currentPlayer);
                        handleInput(2, 1);
                    }
                    break;

                case R.id.f4:
                    if(f22.getText() == ""){
                        f22.setText(currentPlayer);
                        handleInput(2, 2);
                    }
                    break;

                case R.id.f5:
                    if(f23.getText() == ""){
                        f23.setText(currentPlayer);
                        handleInput(2, 3);
                    }
                    break;

                case R.id.f6:
                    if(f31.getText() == ""){
                        f31.setText(currentPlayer);
                        handleInput(3, 1);
                    }
                    break;

                case R.id.f7:
                    if(f32.getText() == ""){
                        f32.setText(currentPlayer);
                        handleInput(3, 2);
                    }
                    break;

                case R.id.f8:
                    if(f33.getText() == ""){
                        f33.setText(currentPlayer);
                        handleInput(3, 3);
                    }
                    break;
            }
        }
    }


    private void handleInput(int x, int y) {
        if (gameStorage[x-1][y-1] == 0){
            if (currentPlayer.equals("X")){
                gameStorage[x-1][y-1] = 1;
                //currentPlayer = "O";
            } else {
                gameStorage[x-1][y-1] = -1;
                //currentPlayer = "X";
            }
        }
        if (checkGameEnd()){
            statusText.setText("Spieler " +currentPlayer + " hat gewonnen");
            gameState = "won";
        } else {
            if(currentPlayer == "X"){
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
            //statusText.setText("Spieler " +currentPlayer + " ist am Zug.");
        }
    }



    private boolean checkGameEnd() {
        return    (Math.abs(gameStorage[0][0] + gameStorage[0][1] +gameStorage[0][2]) == 3
                || Math.abs(gameStorage[1][0] + gameStorage[1][1] +gameStorage[1][2]) == 3
                || Math.abs(gameStorage[2][0] + gameStorage[2][1] +gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][0] + gameStorage[1][0] +gameStorage[2][0]) == 3
                || Math.abs(gameStorage[0][1] + gameStorage[1][1] +gameStorage[2][1]) == 3
                || Math.abs(gameStorage[0][2] + gameStorage[1][2] +gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][0] + gameStorage[1][1] +gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][2] + gameStorage[1][1] +gameStorage[2][0]) == 3);
    }


    private void finishGame() {
        if (currentPlayer.equals("O")){
            Toast.makeText(getApplicationContext(), "O hat gewonnen!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "X hat gewonnen!", Toast.LENGTH_LONG).show();
        }
        // Neuer Start... (man könnte aber auch die Variablen zurücksetzen...)
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }


}



// Slow down: 5s! ========================================================!!!!!



/*
--> Wie baue ich das ein ????

import android.os.Handler;
...
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        // Do something after 5s = 5000ms
        buttons[inew][jnew].setBackgroundColor(Color.BLACK);
    }
}, 5000);

 */