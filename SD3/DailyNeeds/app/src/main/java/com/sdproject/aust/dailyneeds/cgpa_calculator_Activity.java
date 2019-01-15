package com.sdproject.aust.dailyneeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class cgpa_calculator_Activity extends AppCompatActivity {

    private EditText credit_hour_et, gpa_et;
    private TextView cgpa_tv, sum_tv, showcgpa_tv;

    private String str_credithour = "crthr";
    private String str_gpa = "gpa";
    private String str_cgpa = "tolgpa";
    private String str_sum = "sum";

    private double sum_credithour = 0;
    private double sum_cgpa = 0;
    private double sum_gpa = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpa);

    }

    public void refresh_calculator(View view) {
        boolean empty_gapes = false;

        for (int i = 1; i <= 10 ; i++){

            credit_hour_et = (EditText) findViewById(getResources().getIdentifier(str_credithour + i, "id", this.getPackageName()));
            gpa_et = (EditText) findViewById(getResources().getIdentifier(str_gpa + i, "id", this.getPackageName()));
            cgpa_tv = (TextView) findViewById(getResources().getIdentifier(str_cgpa + i, "id", this.getPackageName()));

            if (!Objects.equals(credit_hour_et.getText().toString(), "") && !Objects.equals(gpa_et.getText().toString(), "")) {
                cgpa_tv.setText(String.valueOf(Double.parseDouble(credit_hour_et.getText().toString()) * Double.parseDouble(gpa_et.getText().toString())));
            }else {
                empty_gapes = true;
                break;
            }

            sum_credithour += Double.parseDouble(credit_hour_et.getText().toString());
            sum_gpa += Double.parseDouble(gpa_et.getText().toString());
            sum_cgpa += Double.parseDouble(cgpa_tv.getText().toString());
        }
        if (!empty_gapes){
            sum_tv = (TextView) findViewById(getResources().getIdentifier(str_sum + str_credithour, "id", this.getPackageName()));
            sum_tv.setText(String.valueOf(sum_credithour));

            sum_tv = (TextView) findViewById(getResources().getIdentifier(str_sum + str_gpa, "id", this.getPackageName()));
            sum_tv.setText(String.valueOf(sum_gpa));

            sum_tv = (TextView) findViewById(getResources().getIdentifier(str_sum + str_cgpa, "id", this.getPackageName()));
            sum_tv.setText(String.valueOf(sum_cgpa));

            showcgpa_tv = (TextView) findViewById(getResources().getIdentifier("showcgpa", "id", this.getPackageName()));
            showcgpa_tv.setText(String.valueOf(sum_cgpa / sum_credithour));

            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Fill all the gapes", Toast.LENGTH_SHORT).show();
        }

    }
}
