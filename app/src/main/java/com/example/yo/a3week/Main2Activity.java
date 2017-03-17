package com.example.yo.a3week;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView atext, sumtext;
    ImageView aletter, bletter,cletter,dletter,fletter;


    public void onMyClick(View v){
        if(v.getId() == R.id.b1){
            aletter.setVisibility(View.GONE);
            bletter.setVisibility(View.GONE);
            cletter.setVisibility(View.GONE);
            dletter.setVisibility(View.GONE);
            fletter.setVisibility(View.GONE);

            String num1 = e1.getText().toString();
            String num2 = e1.getText().toString();
            String num3 = e1.getText().toString();

            if(num1.getBytes().length == 0) e1.setText("0");{
                num1 = e1.getText().toString();
            }
            if(num2.getBytes().length == 0) e2.setText("0");{
                num2 = e2.getText().toString();
            }
            if(num3.getBytes().length == 0) e3.setText("0");{
                num3 = e3.getText().toString();
            }

            int sum = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
            int average = (Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3)) / 3;

            sumtext.setText(sum + "점");
            atext.setText(average + "점");

            if (average >= 90){
                aletter.setVisibility(View.VISIBLE);
            }
            if (average < 90 && average >=80){
                bletter.setVisibility(View.VISIBLE);
            }
            if (average < 80 && average >=70){
                cletter.setVisibility(View.VISIBLE);
            }
            if (average < 70 && average >=60){
                dletter.setVisibility(View.VISIBLE);
            }
            if (average < 60){
                fletter.setVisibility(View.VISIBLE);
            }

        }
        else if(v.getId() == R.id.b2){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            sumtext.setText("0점");
            atext.setText("0점");
            aletter.setVisibility(View.GONE);
            bletter.setVisibility(View.GONE);
            cletter.setVisibility(View.GONE);
            dletter.setVisibility(View.GONE);
            fletter.setVisibility(View.GONE);

            Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT) .show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        atext = (TextView)findViewById(R.id.atext);
        sumtext = (TextView)findViewById(R.id.sumtext);
        aletter = (ImageView)findViewById(R.id.aletter);
        bletter = (ImageView)findViewById(R.id.bletter);
        cletter = (ImageView)findViewById(R.id.cletter);
        dletter = (ImageView)findViewById(R.id.dletter);
        fletter = (ImageView)findViewById(R.id.fletter);


    }
}
