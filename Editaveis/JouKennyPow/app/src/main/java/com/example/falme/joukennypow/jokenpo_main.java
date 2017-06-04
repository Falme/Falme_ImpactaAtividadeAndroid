package com.example.falme.joukennypow;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.falme.joukennypow.R;

public class jokenpo_main extends AppCompatActivity  {
    public EditText nome_usuario;
    public String usuario;

    private Button btn_rock;
    private Button btn_paper;
    private Button btn_scissors;

    private ImageView img_jogador;
    private ImageView img_computador;

    private TextView jogador1;
    private TextView jogador2;

    int placarJogador = 0;
    int placarComputador = 0;

    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.jokenpo);

        usuario = getIntent().getStringExtra("nome_usuario");


        btn_paper = (Button) findViewById(R.id.btn_papel);
        btn_rock = (Button) findViewById(R.id.btn_pedra);
        btn_scissors = (Button) findViewById(R.id.btn_tesoura);

        img_jogador = (ImageView) findViewById(R.id.humano);
        img_computador = (ImageView) findViewById(R.id.compudador);

        jogador1 = (TextView) findViewById(R.id.jogador1);
        jogador2 = (TextView) findViewById(R.id.jogador2);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    //escolhemos a imagem do jogador com Rock (pedra)
                    img_jogador.setImageResource(R.drawable.rock);
                    //escolha do compudador
                    img_computador.setImageResource(R.drawable.rock);
                    //mensagem jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();

                }else if (escolhaComputador == 2){
                    img_jogador.setImageResource(R.drawable.rock);
                    img_computador.setImageResource(R.drawable.paper);
                    Toast.makeText(getBaseContext(),"Computador ganhou",Toast.LENGTH_SHORT).show();
                    placarComputador ++;
                    jogador1.setText(String.valueOf(placarComputador));

                }else if (escolhaComputador == 3){
                    img_jogador.setImageResource(R.drawable.rock);
                    img_computador.setImageResource(R.drawable.scissors);
                    Toast.makeText(getBaseContext(), usuario +
                            " ganhou",Toast.LENGTH_SHORT).show();
                    placarJogador ++;
                    jogador2.setText(String.valueOf(placarJogador));
                }
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    //escolhemos a imagem do jogador com Rock (pedra)
                    img_jogador.setImageResource(R.drawable.paper);
                    //escolha do compudador
                    img_computador.setImageResource(R.drawable.paper);
                    //mensagem jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();

                }else if (escolhaComputador == 2){
                    img_jogador.setImageResource(R.drawable.paper);
                    img_computador.setImageResource(R.drawable.scissors);
                    Toast.makeText(getBaseContext(),"Computador ganhou",Toast.LENGTH_SHORT).show();
                    placarComputador ++;
                    jogador1.setText(String.valueOf(placarComputador));

                }else if (escolhaComputador == 3){
                    img_jogador.setImageResource(R.drawable.paper);
                    img_computador.setImageResource(R.drawable.rock);
                    Toast.makeText(getBaseContext(),usuario +
                            " ganhou",Toast.LENGTH_SHORT).show();
                    placarJogador ++;
                    jogador2.setText(String.valueOf(placarJogador));
                }
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int escolhaComputador = (int) (Math.random()*3) + 1;
                if (escolhaComputador == 1){
                    //escolhemos a imagem do jogador com Rock (pedra)
                    img_jogador.setImageResource(R.drawable.scissors);
                    //escolha do compudador
                    img_computador.setImageResource(R.drawable.scissors);
                    //mensagem jogador
                    Toast.makeText(getBaseContext(),"Empate",Toast.LENGTH_SHORT).show();

                }else if (escolhaComputador == 2){
                    img_jogador.setImageResource(R.drawable.scissors);
                    img_computador.setImageResource(R.drawable.rock);
                    Toast.makeText(getBaseContext(),"Computador ganhou",Toast.LENGTH_SHORT).show();
                    placarComputador ++;
                    jogador1.setText(String.valueOf(placarComputador));

                }else if (escolhaComputador == 3){
                    img_jogador.setImageResource(R.drawable.scissors);
                    img_computador.setImageResource(R.drawable.paper);
                    Toast.makeText(getBaseContext(),usuario +
                            " ganhou",Toast.LENGTH_SHORT).show();
                    placarJogador ++;
                    jogador2.setText(String.valueOf(placarJogador));
                }
            }
        });
    }
}
