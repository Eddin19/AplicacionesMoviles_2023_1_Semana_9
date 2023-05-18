package com.example.examen09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private int clickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJugador = findViewById(R.id.btnJugador);
        TextView txtResultadoUno = findViewById(R.id.txtResultadoUno);
        TextView txtResultadoDos = findViewById(R.id.txtResultadoDos);
        TextView txtGanador = findViewById(R.id.txtGanador);
        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        btnJugador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String jugadorTexto = btnJugador.getText().toString();
                if(clickCount==0){
                    int numeroAleatorio = generarNumeroAleatorio(1, 10);
                    txtResultadoUno.setText(String.valueOf(numeroAleatorio));
                    clickCount++;
                }else if(clickCount==1){
                    int numeroAleatorio = generarNumeroAleatorio(1, 10);
                    txtResultadoDos.setText(String.valueOf(numeroAleatorio));

                    int resultado1 = Integer.parseInt(txtResultadoUno.getText().toString());
                    int resultado2 = Integer.parseInt(txtResultadoDos.getText().toString());

                    if (resultado1 > resultado2) {
                        txtGanador.setText("Gana Jugador 1");
                    } else if (resultado1 < resultado2) {
                        txtGanador.setText("Gana Jugador 2");
                    } else {
                        txtGanador.setText("Empate");
                    }

                    btnJugador.setText("Jugador 2");
                    clickCount++;
                }
                btnJugador.setText("Jugador 2");
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnJugador.setText("Jugador 1");
                txtResultadoUno.setText("Aleatorio 1");
                txtResultadoDos.setText("Aleatorio 2");
                txtGanador.setText("Ganador");
                clickCount = 0;
            }
        });
    }

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


}
