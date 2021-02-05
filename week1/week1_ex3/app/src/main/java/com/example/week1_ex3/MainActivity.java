package com.example.week1_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button exitButton;
    private EditText nameEntry;
    private TextView toChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = findViewById(R.id.exitButton);
        nameEntry = findViewById(R.id.nameEntry);
        toChange = findViewById(R.id.toChange);

    }


    public void changeColor(View exitButton) {
        String name = nameEntry.getText().toString();
        toChange.setText(name);
        toChange.setTextColor(Color.RED);


    }
}