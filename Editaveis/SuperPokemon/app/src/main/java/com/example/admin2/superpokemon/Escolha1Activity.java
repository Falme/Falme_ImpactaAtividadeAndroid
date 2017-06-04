package com.example.admin2.superpokemon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Escolha1Activity extends AppCompatActivity {
    private Button btn_velocidade1;
    private Button btn_forca1;
    private Button btn_inteligencia1;
    private ImageView iv_char;
    private int valorJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha1);

        iv_char = (ImageView) findViewById(R.id.iv_char);

        Intent i = getIntent();
        Bundle valor = i.getExtras();

        valorJogador = Integer.valueOf((String)valor.get("playerNumber"));

        if(valorJogador==0){
            iv_char.setImageResource(R.drawable.j1);
        } else if(valorJogador==1){

            iv_char.setImageResource(R.drawable.j2);
        } else {

            iv_char.setImageResource(R.drawable.j3);
        }

        btn_velocidade1 = (Button) findViewById(R.id.btn_velocidade1);
        btn_velocidade1.setEnabled(Score.btnUsed[(valorJogador*3)]);
        if(!Score.btnUsed[(valorJogador*3)])
            btn_velocidade1.setBackgroundColor(Color.parseColor("#cec7c7"));

        btn_forca1 = (Button) findViewById(R.id.btn_forca1);
        btn_forca1.setEnabled(Score.btnUsed[(valorJogador*3)+1]);
        if(!Score.btnUsed[(valorJogador*3)+1])
            btn_forca1.setBackgroundColor(Color.parseColor("#cec7c7"));

        btn_inteligencia1 = (Button) findViewById(R.id.btn_inteligencia1);
        btn_inteligencia1.setEnabled(Score.btnUsed[(valorJogador*3)+2]);
        if(!Score.btnUsed[(valorJogador*3)+2])
            btn_inteligencia1.setBackgroundColor(Color.parseColor("#cec7c7"));

        btn_velocidade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent ir = new Intent(getBaseContext(), Velocidade1Activity.class);
                startActivity(ir);*/


                int aNumber = (int) (33 * Math.random()) + 67;
                initActivity(aNumber,(valorJogador*3), false);

            }
        });

        btn_forca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int aNumber = (int) (33 * Math.random()) + 34;
                initActivity(aNumber,(valorJogador*3)+1, false);

            }
        });

        btn_inteligencia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int aNumber = (int) (33 * Math.random()) + 0;
                initActivity(aNumber,(valorJogador*3)+2, true);

            }
        });
    }


    private void initActivity(int number, int idBtn, boolean inte){
        Intent i = new Intent(getBaseContext(), JogadaActivity.class);
        i.putExtra("valor", ""+number);
        i.putExtra("idBtn", ""+idBtn);
        i.putExtra("idPlr", ""+valorJogador);
        i.putExtra("Letter", (inte ? " QI":""));
        startActivity(i);
    }
}
