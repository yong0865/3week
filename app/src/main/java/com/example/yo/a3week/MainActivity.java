package com.example.yo.a3week;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent aaa = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(aaa);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent aaa = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(aaa);
            }
        });

    }


}
