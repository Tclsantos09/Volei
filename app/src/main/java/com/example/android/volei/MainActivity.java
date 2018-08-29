package com.example.android.volei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TimeA = 0;
    int TimeB = 0;
    int FaltA = 0;
    int FaltB = 0;
    int Set = 1;
    int Apontoset = 0;
    int Bpontoset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Display dos pontos do time A
    public void displayTimeA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_a_ponto);
        scoreView.setText(String.valueOf(score));
    }

    //Display dos pontos do time B
    public void displayTimeB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_b_ponto);
        scoreView.setText(String.valueOf(score));
    }

    //Display das faltas do time A
    public void displayTimefaltaA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_a_falta);
        scoreView.setText(String.valueOf(score));
    }

    //Display das faltas do time B
    public void displayTimefaltaB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_b_falta);
        scoreView.setText(String.valueOf(score));
    }

    //Display para mostrar em qual set do jogo está
    public void displaySet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.num_set);
        scoreView.setText(String.valueOf("SET " + score));
    }

    //Display para mostrar a quantidade de sets que o time A ganhou
    public void displayPlacarSetA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.A_ponto_set);
        scoreView.setText(String.valueOf( + score));
    }

    //Display para mostrar a quantidade de sets que o time B ganhou
    public void displayPlacarSetB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.B_ponto_set);
        scoreView.setText(String.valueOf( + score));
    }

    //Display para mostrar a mensagem de fim de jogo
    public void FimJogo(String score) {
        TextView scoreView = (TextView) findViewById(R.id.msg_vencedor);
        scoreView.setText(String.valueOf(score));
    }

    public void A1Ponto(View v) {
        TimeA = TimeA + 1;
        if (Set < 5 && TimeA == 26){
            Apontoset = Apontoset + 1;
            MudaSet(TimeA);
        }
        if (Set == 5 && TimeA == 15){
            Apontoset = Apontoset + 1;
            MudaSet(TimeA);
        }
        if (Set == 5 && TimeA == 16){
            MudaSet(TimeA);
        }
        displayTimeA(TimeA);
    }

    public void AFalta(View v) {
        FaltA = FaltA + 1;
        displayTimefaltaA(FaltA);
    }

    public void B1Ponto(View v) {
        TimeB = TimeB + 1;
        if (Set < 5 && TimeB == 26){
            Bpontoset = Bpontoset + 1;
            MudaSet(TimeB);
        }
        if (Set == 5 && TimeB == 15){
            Bpontoset = Bpontoset + 1;
            MudaSet(TimeB);
        }
        if (Set == 5 && TimeB == 16){
            MudaSet(TimeB);
        }
        displayTimeB(TimeB);
    }

    public void BFalta(View v) {
        FaltB = FaltB + 1;
        displayTimefaltaB(FaltB);
    }

    public void MudaSet(int ponto) {
        if (Set < 5 && ponto == 26) {
            Set = Set + 1;
            TimeA = 0;
            TimeB = 0;
            FaltA = 0;
            FaltB = 0;
            displayTimeA(TimeA);
            displayTimeB(TimeB);
            displayTimefaltaA(FaltA);
            displayTimefaltaB(FaltB);
            displaySet(Set);
            displayPlacarSetA(Apontoset);
            displayPlacarSetB(Bpontoset);
        }

        if (Set == 5 && ponto == 15){
            FimJogo("Fim de Jogo");
        }

        if (Set == 5 && ponto == 16){
            Bpontoset = 0;
            Apontoset = 0;
            Set = 1;
            TimeA = 0;
            TimeB = 0;
            FaltA = 0;
            FaltB = 0;
            displayTimeA(TimeA);
            displayTimeB(TimeB);
            displayTimefaltaA(FaltA);
            displayTimefaltaB(FaltB);
            displaySet(Set);
            displayPlacarSetA(Apontoset);
            displayPlacarSetB(Bpontoset);
            FimJogo("");
        }
    }

    public void reiniciar(View v){
        Bpontoset = 0;
        Apontoset = 0;
        TimeA = 0;
        TimeB = 0;
        FaltA = 0;
        FaltB = 0;
        Set = 1;
        displayTimeA(TimeA);
        displayTimeB(TimeB);
        displayTimefaltaA(FaltA);
        displayTimefaltaB(FaltB);
        displaySet(Set);
        displayPlacarSetA(Apontoset);
        displayPlacarSetB(Bpontoset);
        FimJogo("");
    }
}
