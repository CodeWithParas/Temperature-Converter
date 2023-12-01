package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText tempET;
    Button convertBtn, resetBtn;
    TextView errorTV;
    RadioButton c2f, f2c;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempET = findViewById(R.id.temperatureValue);
        convertBtn = findViewById(R.id.convertBtn);
        errorTV = findViewById(R.id.errorTextView);
        radioGroup = findViewById(R.id.radioGroup);
        c2f = findViewById(R.id.cTofRadio);
        f2c = findViewById(R.id.fTocRadio);
        resetBtn = findViewById(R.id.resetBtn);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    errorTV.setText("Please select atleast one conversion method.");
                }
                else
                {
                    if (tempET.getText().toString().equals("") || tempET.getText().toString().equals(null)) {
                        errorTV.setText("Please enter a value in the text box.");
                    }else {
//                        celsius to fahrenheit radio button is clicked
                        if (c2f.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double celsiusValue = Double.parseDouble(value);

                            Double convertedValue = (celsiusValue * 9/5) + 32;

                            tempET.setText(convertedValue.toString());
                        }
//                        fahrenheit to celsius radio button is clicked
                        else if (f2c.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double fahrenheitValue = Double.parseDouble(value);
                            Double convertedValue = (fahrenheitValue - 32) * 5/9 ;

                            tempET.setText(convertedValue.toString());
                        }
                    }
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorTV.setText(null);
                tempET.setText(null);
            }
        });
    }
}