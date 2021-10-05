package com.example.clickinggame_listenersex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int cPlayer1, cPlayer2;
    TextView tv1,tv2,tv3;
    Button btn;
    Intent ri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        btn = (Button) findViewById(R.id.btn);
        ri = new Intent(this,MainActivity.class);

        start();
    }

    private void start() {
        ri = getIntent();
        cPlayer1 = ri.getIntExtra("cPlayer1", 0);
        cPlayer2 = ri.getIntExtra("cPlayer2", 0);

        tv2.setText("Player 1: " + cPlayer1);
        tv3.setText("Player 2: " + cPlayer2);

        if(cPlayer1>cPlayer2){
            tv1.setText("The winner is PLAYER1 - BLUE");
        }
        else if (cPlayer2>cPlayer1){
            tv1.setText("The winner is PLAYER2 - RED");
        }
        else{
            tv1.setText("No Winner - Equal Results.");
        }
    }

    public void goBack(View view) {
        ri.putExtra("cPlayer1", 0);
        ri.putExtra("cPlayer2",0);
        setResult(RESULT_OK, ri);
        finish();
    }
}