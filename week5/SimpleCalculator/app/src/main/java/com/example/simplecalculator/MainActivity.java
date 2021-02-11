package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public void clearResults(View view) {
        asyncClearResults(view);
    }

    void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void asyncClearResults(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        // Create new ProgressBar
        ProgressDialog progressBar;
        progressBar = new ProgressDialog(view.getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("Clearing Results...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(5);
        progressBar.show();

        executor.execute(new Runnable() {

            @Override
            public void run() {

                ///////////////////////////////////////////////////////////////////////////////////
                //Simulate Background task
                ///////////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < 5; i++) {
                    // Simulate delay
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update Progress Bar
                    progressBar.setProgress(i);
                }
                // Dismiss the ProgressBar
                progressBar.dismiss();


                ///////////////////////////////////////////////////////////////////////////////////
                // Clear the TextView and EditText fields
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        editTextLENGTH.setText("");
                        editTextHEIGHT.setText("");
                        textViewRESULT.setText("");
                    }
                });
                ///////////////////////////////////////////////////////////////////////////////////
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //UI Thread work here
                        System.out.println("UI method");
                    }
                });
                ///////////////////////////////////////////////////////////////////////////////////
            }
        });
    }


}