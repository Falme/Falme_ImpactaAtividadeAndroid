package com.example.admin2.superpokemon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Death extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_caveira);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i;
                i = new Intent(getBaseContext(), MenuActivity.class);
                Score.score = 100;

                for(int a = 0; a<Score.btnUsed.length;a++){
                    Score.btnUsed[a]=true;
                }

                startActivity(i);
                finish();
            }
        },4000);
    }
}
