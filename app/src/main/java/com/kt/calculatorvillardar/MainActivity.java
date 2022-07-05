package com.kt.calculatorvillardar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digitButtonListenerMethod();
    }

    public void digitButtonListenerMethod() {
        View.OnClickListener digitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etSpace = (EditText) findViewById(R.id.etSpace);
                Button btn = (Button) view;
                etSpace.setText(etSpace.getText() + "" + btn.getText());
            }
        };

        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        btn7.setOnClickListener(digitListener);
        btn8.setOnClickListener(digitListener);
        btn9.setOnClickListener(digitListener);
    }
}