package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextLENGTH;
    EditText editTextHEIGHT;
    Button calculateArea;
    TextView textViewRESULT;
    Button clearResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLENGTH = findViewById(R.id.editTextLENGTH);
        editTextHEIGHT = findViewById(R.id.editTextHEIGHT);
        calculateArea = findViewById(R.id.calculateArea);
        textViewRESULT = findViewById(R.id.textViewRESULT);
        clearResults = findViewById(R.id.clearResults);

    }

    public void calculateArea(View v) {
        double LENGTH = 0.0;
        double HEIGHT = 0.0;

        LENGTH = Double.parseDouble(editTextLENGTH.getText().toString());
        HEIGHT = Double.parseDouble(editTextHEIGHT.getText().toString());

        double AREA = LENGTH * HEIGHT;

        textViewRESULT.setText(String.valueOf(AREA));

        closeKeyBoard();

    }

    public void clearResults(View v) {
        editTextLENGTH.setText("");
        editTextHEIGHT.setText("");
        textViewRESULT.setText("");
    }


    void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}