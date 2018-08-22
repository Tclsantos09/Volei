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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayTimeA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_a_ponto);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTimeB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_b_ponto);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTimefA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_a_falta);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTimefB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.time_b_falta);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySet(int score) {
        TextView scoreView = (TextView) findViewById(R.id.num_set);
        scoreView.setText(String.valueOf("SET " + score));
    }

    public void TimeVencedor(String score) {
        TextView scoreView = (TextView) findViewById(R.id.msg_vencedor);
        scoreView.setText(String.valueOf(score));
    }

    public void A1Ponto(View v) {
        TimeA = TimeA + 1;
        if (Set < 5 && TimeA == 26){
            MudaSet(TimeA);
        }
        if (Set == 5 && TimeA == 15){
            MudaSet(TimeA);
        }
        if (Set == 5 && TimeA == 16){
            MudaSet(TimeB);
        }
        displayTimeA(TimeA);
    }

    public void AFalta(View v) {
        FaltA = FaltA + 1;
        displayTimefA(FaltA);
    }

    public void B1Ponto(View v) {
        TimeB = TimeB + 1;
        if (Set < 5 && TimeB == 26){
            MudaSet(TimeB);
        }
        if (Set == 5 && TimeB == 15){
            MudaSet(TimeB);
        }
        if (Set == 5 && TimeB == 16){
            MudaSet(TimeB);
        }
        displayTimeB(TimeB);
    }

    public void BFalta(View v) {
        FaltB = FaltB + 1;
        displayTimefB(FaltB);
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
            displayTimefA(FaltA);
            displayTimefB(FaltB);
            displaySet(Set);
        }

        if (Set == 5 && ponto == 15){
            TimeVencedor("Fim de Jogo");
        }

        if (Set == 5 && ponto == 16){
            Set = 1;
            TimeA = 0;
            TimeB = 0;
            FaltA = 0;
            FaltB = 0;
            displayTimeA(TimeA);
            displayTimeB(TimeB);
            displayTimefA(FaltA);
            displayTimefB(FaltB);
            displaySet(Set);
            TimeVencedor("");
        }
    }

    public void reiniciar(View v){
        TimeA = 0;
        TimeB = 0;
        FaltA = 0;
        FaltB = 0;
        Set = 1;
        displayTimeA(TimeA);
        displayTimeB(TimeB);
        displayTimefA(FaltA);
        displayTimefB(FaltB);
        displaySet(Set);
        TimeVencedor("");
    }
}
