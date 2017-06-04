package com.example.falme.joukennypow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button btn_jogar;
    public EditText nome_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome_usuario = (EditText) findViewById(R.id.nome_usuario);

        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("nome_usuario", ""+nome_usuario.getText());
                intent.setClass(MainActivity.this, jokenpo_main.class);
                startActivity(intent);
            }
        });

    }
}
