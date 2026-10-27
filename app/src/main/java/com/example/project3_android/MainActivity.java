package com.example.project3_android;

import android.os.Bundle;
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

//       btnRosnaco.setOnClickListener(v -> losuj());

        btnMalejaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()) {
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_SHORT).show();
            } else {
//                sortujRosnaco();
//                odswiezWidok();
            }
        });

        btnRosnaco.setOnClickListener(v -> {
            if (wyniki.isEmpty()){
                Toast.makeText(this, "Najpierw wylosuj kostki!", Toast.LENGTH_SHORT).show();
            } else {
//                sortujMalejaco();
//                odswiezWidok();
            }
        });
    }


}