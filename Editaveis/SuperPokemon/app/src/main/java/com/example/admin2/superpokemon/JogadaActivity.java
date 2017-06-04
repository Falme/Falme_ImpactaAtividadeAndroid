package com.example.admin2.superpokemon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JogadaActivity extends AppCompatActivity {
    private TextView tv_valor;
    private ImageView iv_computador;
    private ImageView iv_plr;

    private TextView tv_velocidade_computador;
    private static int TEMPO = 9000;
    private int idAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_jogada);
        tv_valor = (TextView) findViewById(R.id.tv_valor);
        iv_computador = (ImageView) findViewById(R.id.iv_computador);
        iv_plr = (ImageView) findViewById(R.id.iv_plr);

        tv_velocidade_computador = (TextView) findViewById(R.id.tv_velocidade_computador);
        //
        Intent i = getIntent();
        Bundle valor = i.getExtras();

        String getValor = (String) valor.get("valor");
        int valorJogador = Integer.valueOf(getValor);
        tv_valor.setText(getValor + valor.get("Letter"));
        idAction =  Integer.valueOf((String) valor.get("idBtn"));
        int idPlr =  Integer.valueOf((String) valor.get("idPlr"));

        if(idPlr==0){
            iv_plr.setImageResource(R.drawable.j1);
        } else if(idPlr==1){

            iv_plr.setImageResource(R.drawable.j2);
        } else {

            iv_plr.setImageResource(R.drawable.j3);
        }



        int escolhaComputador = (int) (Math.random()*100)+1;
        int personagemComputador = (int) (Math.random()*3)+1;

        if(personagemComputador == 1){
            iv_computador.setImageResource(R.drawable.c1);
        }else if(personagemComputador == 2){
            iv_computador.setImageResource(R.drawable.c2);
        }else if(personagemComputador == 3) {
            iv_computador.setImageResource(R.drawable.c3);
        }

        tv_velocidade_computador.setText(Integer.toString(escolhaComputador) + valor.get("Letter"));

        if(escolhaComputador == valorJogador){
            Toast.makeText(getBaseContext(),
                    "EMPATE",Toast.LENGTH_LONG).show();
        }else if(escolhaComputador < valorJogador){
            Toast.makeText(getBaseContext(),
                    "JOGADOR GANHOU",Toast.LENGTH_LONG).show();
                    Score.score += valorJogador-escolhaComputador;
        }else{
            Toast.makeText(getBaseContext(),
                    "JOGADOR PERDEU",Toast.LENGTH_LONG).show();
                    Score.score -= escolhaComputador-valorJogador;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i;
                if(Score.score < 0 || !verifyCanPlay())
                    i = new Intent(getBaseContext(), Death.class);
                else if (Score.score > 200)
                    i = new Intent(getBaseContext(), Victory.class);
                else
                    i = new Intent(getBaseContext(), MenuActivity.class);
                Score.btnUsed[idAction] = false;
                startActivity(i);
                finish();
            }
        },TEMPO);

    }

    private boolean verifyCanPlay(){
        boolean found = false;

        for(int a = 0; a<Score.btnUsed.length;a++){
            if(Score.btnUsed[a])
                found=true;
        }

        return found;
    }
}
