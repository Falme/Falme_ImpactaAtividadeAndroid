package com.example.admin2.superpokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Velocidade1Activity extends AppCompatActivity {
    private SeekBar sk_velocidade;
    private Button btn_jogar;
    int valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_velocidade1);
        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        sk_velocidade = (SeekBar) findViewById(R.id.sk_velocidade);

        sk_velocidade.setMax(100);
        sk_velocidade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valor = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTexto = Integer.toString(valor);
                Intent i = new Intent(getBaseContext(), JogadaActivity.class);
                i.putExtra("valor", valorTexto);
                startActivity(i);
            }
        });
    }
}
