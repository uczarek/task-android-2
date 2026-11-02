package com.example.project3_android;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private EditText editTextLiczbaKostek;
    private Button btnLosuj;
    private Button btnRosnaco;
    private Button btnMalejaco;
    private GridLayout gridKostki;
    private TextView textViewWyniki;

    private final List<Integer> wyniki = new ArrayList<>();
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLiczbaKostek = findViewById(R.id.editTextLiczbaKostek);
        btnLosuj = findViewById(R.id.btnLosuj);
        btnRosnaco = findViewById(R.id.btnRosnaco);
        btnMalejaco = findViewById(R.id.btnMalejaco);
        gridKostki = findViewById(R.id.gridKostki);
        textViewWyniki =  findViewById(R.id.textViewWyniki);

       btnLosuj.setOnClickListener(v -> {
           losuj();
           odswiezWidok();
       });

        btnMalejaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_SHORT).show();
            } else {
                sortujRosnaco();
                odswiezWidok();
            }
        });

        btnRosnaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()){
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_SHORT).show();
            } else {
                sortujMalejaco();
                odswiezWidok();
            }
        });
    }

    private void losuj() {
        int liczbaKostek = Integer.parseInt(editTextLiczbaKostek.getText().toString().trim());

        if (liczbaKostek > 0 && liczbaKostek < 101) {
            wyniki.clear();
            gridKostki.removeAllViews();

            for (int i = 0; i < liczbaKostek; i++) {
                int wynik = random.nextInt(6) + 1;
                wyniki.add(wynik);
            }

        } else {
            Toast.makeText(this, "Proszę wpisać liczbę kostek od 1 do 100!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sortujRosnaco() {
        for(int i = 0; i < wyniki.size() - 1; i++) {
            for(int j = 0; j < wyniki.size() - i - 1; j++) {
                if(wyniki.get(j) > wyniki.get(j + 1)) {
                    int temp = wyniki.get(j);
                    wyniki.set(j, wyniki.get(j + 1));
                    wyniki.set(j + 1, temp);
                }
            }
        }
    }

    private void sortujMalejaco() {
        for(int i = 0; i < wyniki.size() - 1; i++) {
            for(int j = 0; j < wyniki.size() - i - 1; j++) {
                if(wyniki.get(j) < wyniki.get(j + 1)) {
                    int temp = wyniki.get(j);
                    wyniki.set(j, wyniki.get(j + 1));
                    wyniki.set(j + 1, temp);
                }
            }
        }
    }

    private void odswiezWidok() {
        gridKostki.removeAllViews();
        StringBuilder wynikiString = new StringBuilder();

        for (int wynik : wyniki) {
            TextView textViewKostka = new TextView(this);
            textViewKostka.setText(String.valueOf(wynik));
            textViewKostka.setTextSize(24f);
            textViewKostka.setGravity(Gravity.CENTER);
            textViewKostka.setBackgroundColor(0xFFE0E0E0);
            textViewKostka.setTextColor(0xFF000000);
            textViewKostka.setPadding(24, 24, 24, 24);
            gridKostki.addView(textViewKostka);

            wynikiString.append(wynik).append(" ");
        }

        textViewWyniki.setText(wynikiString.toString().trim());
    }


}