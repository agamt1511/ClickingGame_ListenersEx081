package com.example.clickinggame_listenersex081;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{
    Button btn1,btn2,btn3;
    int cPlayer1, cPlayer2;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        si = new Intent(this,SecondActivity.class);


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cPlayer1 = cPlayer1+1;
            }
        });

        btn2.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        cPlayer2 = cPlayer2+2;
        return true;
    }

    protected void onActivityResult (int source, int good, @Nullable Intent data_back) {
        if (source == 1) {
            if (good == RESULT_OK) {
                if (data_back != null) {
                    cPlayer1 = data_back.getIntExtra("cPlayer1", 0);
                    cPlayer2 = data_back.getIntExtra("cPlayer1", 0);
                }
            }
        }
    }


    public void goToSecond(View view) {
        si.putExtra("cPlayer1", cPlayer1);
        si.putExtra("cPlayer2", cPlayer2);
        startActivityForResult(si,1);
    }
}
