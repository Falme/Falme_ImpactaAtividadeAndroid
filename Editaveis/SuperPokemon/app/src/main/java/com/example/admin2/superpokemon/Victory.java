package com.example.admin2.superpokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Victory extends AppCompatActivity {

    private Button btn_playTic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trophy_winner);

        btn_playTic = (Button) findViewById(R.id.btn_playTic);
        btn_playTic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selecionar1 = new Intent(getBaseContext(), JogoVelhaActivity.class);
                selecionar1.putExtra("nome", "player");
                startActivity(selecionar1);
            }
        });
    }
}
