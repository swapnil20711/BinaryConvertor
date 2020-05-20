package com.swapnil.binarytodecimal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Number;
    private int decimal = 0;
    private int bin = 0;
    private int remainder;
    private int i = 0;
    private int octal = 0;
    private int temp;
    private String hexadecimal;
    private TextView deci;
    private TextView octa;
    private TextView hexa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Number = (EditText) findViewById(R.id.binary_number);
        deci = (TextView) findViewById(R.id.decimal_number);
        octa = (TextView) findViewById(R.id.octal_number);
        hexa = (TextView) findViewById(R.id.hexadecimal_number);

    }

    public void binaryCovertor(View view) {
        decimal = 0;
        octal = 0;

        i = 0;
        if (Number.getText().toString().isEmpty()) {
            Number.setError("Enter a number");
        } else {
            bin = Integer.parseInt(Number.getText().toString());

            while (bin > 0) {
                remainder = bin % 10;
                if (remainder > 1) {
                    Number.setError("Cannot enter decimal number!!");
                    i = 0;
                    break;
                } else {
                    decimal += remainder * Math.pow(2, i);
//                    octal += remainder * Math.pow(8, i);
                    bin /= 10;
                    i++;
                    temp = decimal;
                    continue;
                }
            }
//            Log.v("main", "" + temp);
            if (i != 0) {
                deci.setText(decimal + "");
                hexadecimal = Integer.toHexString(decimal);

            }
        }
        i = 1;
        while (temp > 0) {
            remainder = temp % 8;
            octal += remainder * i;
            temp /= 8;
            i *= 10;
        }
        if (i != 0) {
            octa.setText("" + octal);
        }
        hexa.setText(hexadecimal);


    }
}
