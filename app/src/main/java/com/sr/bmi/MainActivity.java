package com.sr.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvres;
        EditText edtwt,edthtin,edthtft;
        Button btncal;
        LinearLayout main;

        edtwt=findViewById(R.id.edtwt);
        edthtft=findViewById(R.id.edthtft);
        edthtin=findViewById(R.id.edthtin);
        btncal=findViewById(R.id.btncal);
        tvres=findViewById(R.id.res);
        main=findViewById(R.id.main);

        btncal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int wt = Integer.parseInt(edtwt.getText().toString());
                        int ft = Integer.parseInt(edthtft.getText().toString());
                        int in = Integer.parseInt(edthtin.getText().toString());
                        int totin = ft * 12 + in;
                        double totcm = totin * 2.53;
                        double totm = totcm / 100;
                        double bmi = wt / (totm * totm);

                        if (bmi > 25) {
                            tvres.setText("You are OverWeight ");
                            main.setBackgroundColor(getResources().getColor(R.color.overwt));
                        } else if (bmi < 18) {
                            tvres.setText("You are UnderWeight");
                            main.setBackgroundColor(getResources().getColor(R.color.underwt));
                        } else {
                            tvres.setText("Your are Healthy!");
                            main.setBackgroundColor(getResources().getColor(R.color.healthy));

                        }
                    }
                }
        );


    }

}
