package com.example.rhythym_guard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btn5,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       btn5= (Button) findViewById(R.id.button5);
        btn3= (Button) findViewById(R.id.button3);
        String name = getIntent().getStringExtra("phone");
        String name1 = getIntent().getStringExtra("phone");
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HomeActivity.this,AddActivity.class);
                intent.putExtra("phone",name);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HomeActivity.this,MainActivity2.class);
                intent.putExtra("phone",name1);
                startActivity(intent);
            }
        });

    }
}