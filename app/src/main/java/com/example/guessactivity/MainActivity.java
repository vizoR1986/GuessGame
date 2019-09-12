package com.example.guessactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int generated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNumberToGuess();
        final EditText etGuess = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(etGuess.getText().toString())) {
                    int guess = Integer.parseInt(etGuess.getText().toString());
                    if (guess < generated) {
                        showMessage(R.string.number_larger);
                    } else if (guess > generated) {
                        showMessage(R.string.number_smaller);
                    } else {
                        showMessage(R.string.number_guessed);
                    }
                } else {
                    etGuess.setError(getString(R.string.empty_guess));
                }
            }
        });
    }

    private void showMessage(int StringID) {
        Toast.makeText(getApplicationContext(), getString(StringID), Toast.LENGTH_LONG).show();
    }

    private void generateNumberToGuess() {
        int generated = new Random(System.currentTimeMillis()).nextInt(100);
    }
}
