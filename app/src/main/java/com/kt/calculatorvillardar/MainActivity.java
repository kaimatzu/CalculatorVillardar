package com.kt.calculatorvillardar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digitButtonListenerMethod();
        operationButtonListenerMethod();
    }

    public void digitButtonListenerMethod() {
        View.OnClickListener digitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etSpace = findViewById(R.id.etSpace);
                Button btn = (Button) view;
                etSpace.setText(etSpace.getText() + "" + btn.getText());
            }
        };

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        btn0.setOnClickListener(digitListener);
        btn1.setOnClickListener(digitListener);
        btn2.setOnClickListener(digitListener);
        btn3.setOnClickListener(digitListener);
        btn4.setOnClickListener(digitListener);
        btn5.setOnClickListener(digitListener);
        btn6.setOnClickListener(digitListener);
        btn7.setOnClickListener(digitListener);
        btn8.setOnClickListener(digitListener);
        btn9.setOnClickListener(digitListener);
    }

    public void operationButtonListenerMethod() {
        View.OnClickListener operationListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                Log.d("Ops", btn.getText().toString());
            }
        };

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);

        btnAdd.setOnClickListener(operationListener);
        btnSubtract.setOnClickListener(operationListener);
        btnMultiply.setOnClickListener(operationListener);
        btnDivide.setOnClickListener(operationListener);
    }
}