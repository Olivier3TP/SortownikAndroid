package com.example.sortownik;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random random = new Random();

        ArrayList<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Bąbelkowe");
        spinnerArray.add("Przez wybór");

        EditText odIluEdit = findViewById(R.id.odIluEdit);
        EditText doIluEdit = findViewById(R.id.doIluEdit);
        EditText ileEdit = findViewById(R.id.ileEdit);
        Button losujButton = findViewById(R.id.losujButton);
        Button sortujButton = findViewById(R.id.sortujButton);
        TextView liczbyLosoweText = findViewById(R.id.liczbyLosoweText);
        TextView posortowaneText = findViewById(R.id.posortowaneText);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        losujButton.setOnClickListener(v -> {
            int dolnyZakres =  Integer.parseInt(odIluEdit.getText().toString());
            int gornyZakres = Integer.parseInt(doIluEdit.getText().toString());
            int calyZakres = Integer.parseInt(ileEdit.getText().toString());
            ArrayList<Integer> liczby = new ArrayList<>();
            String liczbyString = "";

            for(int i = 0; i < calyZakres; i++){
                int liczba = random.nextInt(gornyZakres - dolnyZakres - 1) + dolnyZakres;
                liczby.add(liczba);
            }
            for(int i = 0; i < liczby.size(); i++){
                liczbyString += liczby.get(i) + " ";
            }

            liczbyLosoweText.setText(liczbyString);
        });
        spinner.getOnItemSelectedListener()
    }
}