package com.kt.calculatorvillardar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public int prev_num = 0, res = 0, prev_op = 0;
    public boolean clear_field = false, cleared = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digitButtonListenerMethod();
        operationButtonListenerMethod();
        deleteButtonListenerMethod();
    }

    public void digitButtonListenerMethod() {
        View.OnClickListener digitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etSpace = findViewById(R.id.etSpace);
                Button btn = (Button) view;
                if(prev_op == R.id.btnEquals){
                    prev_num = 0;
                    cleared = true;
                }

                if(clear_field){
                    clear_field = false;
                    etSpace.setText("0");
                }
                if(prev_op == R.id.btnEquals){
                    prev_op = 0;
                    prev_num = 0;
                }
                etSpace.setText(etSpace.getText() + "" + btn.getText());
                String text = etSpace.getText().toString();
                if(text.substring(0,1).equals("0") && text.length() > 1){
                    etSpace.setText(text.substring(1));
                }
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
                EditText etSpace = findViewById(R.id.etSpace);
                Button btn = (Button) v;
                String text = etSpace.getText().toString();
                int num = Integer.parseInt(text);
                if(prev_op == R.id.btnEquals){
                    prev_num = 0;
                    cleared = true;
                }
                switch (btn.getId()){
                    case R.id.btnAdd:
                        if(cleared){
                            res = num;
                            cleared = false;
                        }
                        else
                            res = prev_num + num;
                        prev_num = res;
                        prev_op = R.id.btnAdd;
                        clear_field = true;
                        break;
                    case R.id.btnSubtract:
                        if(cleared){
                            res = num;
                            cleared = false;
                        }
                        else
                            res = prev_num - num;
                        prev_num = res;
                        prev_op = R.id.btnSubtract;
                        clear_field = true;
                        break;
                    case R.id.btnMultiply:
                        if(cleared){
                            res = num;
                            cleared = false;
                        }
                        else
                            res = prev_num * num;
                        prev_num = res;
                        prev_op = R.id.btnMultiply;
                        clear_field = true;
                        break;
                    case R.id.btnDivide:
                        if(cleared){
                            res = num;
                            cleared = false;
                        }
                        else
                            res = prev_num / num;
                        prev_num = res;
                        prev_op = R.id.btnDivide;
                        clear_field = true;
                        break;
                    case R.id.btnEquals:
                        switch (prev_op){
                            case R.id.btnAdd:
                                res = prev_num + num;
                                break;
                            case R.id.btnSubtract:
                                res = prev_num - num;
                                break;
                            case R.id.btnMultiply:
                                res = prev_num * num;
                                break;
                            case R.id.btnDivide:
                                res = prev_num / num;
                                break;
                        }
//                        if(prev_op == R.id.btnAdd)
//                            res = prev_num + num;
                        etSpace.setText(res + "");
                        prev_op = R.id.btnEquals;
                        clear_field = true;
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + btn.getText().toString());
                }
                etSpace.setText(res + "");
//                if(prev_num == 0)
//                    etSpace.setText(res + "");
                //etSpace.setText("0");
                Button prev = (Button) findViewById(prev_op);
                Log.d("prev_op", prev.getText().toString());
                Log.d("prev_num", String.valueOf(prev_num));
            }
        };

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEquals = findViewById(R.id.btnEquals);

        btnAdd.setOnClickListener(operationListener);
        btnSubtract.setOnClickListener(operationListener);
        btnMultiply.setOnClickListener(operationListener);
        btnDivide.setOnClickListener(operationListener);
        btnEquals.setOnClickListener(operationListener);
    }

    public void deleteButtonListenerMethod() {
        View.OnClickListener deleteListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etSpace = findViewById(R.id.etSpace);
                Button btn = (Button) v;
                switch(btn.getId()){
                    case R.id.btnBack:
                        String text = etSpace.getText().toString();
                        if(text.length() == 1)
                            etSpace.setText("0");
                        else
                            etSpace.setText(text.substring(0, text.length() - 1));
                        break;
                    case R.id.btnClear:
                        prev_op = 0;
                        prev_num = 0;
                        cleared = true;
                        etSpace.setText("0");
                }
            }
        };

        Button btnBack = findViewById(R.id.btnBack);
        Button btnClear = findViewById(R.id.btnClear);

        btnBack.setOnClickListener(deleteListener);
        btnClear.setOnClickListener(deleteListener);
    }
}