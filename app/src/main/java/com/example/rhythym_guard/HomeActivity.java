package com.example.rhythym_guard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    Button btn5,btn3;
    TextView t1,t2;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("info");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn5= (Button) findViewById(R.id.button5);
        btn3= (Button) findViewById(R.id.button3);
        t1=(TextView)findViewById(R.id.txt2);
        t2=(TextView)findViewById(R.id.txt);
        String name = getIntent().getStringExtra("phone");
        String name1 = getIntent().getStringExtra("phone");
        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference().child("info").child(name);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HomeActivity.this, AddActivity.class);
                intent.putExtra("phone", name);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HomeActivity.this, MainActivity2.class);
                intent.putExtra("phone", name1);
                startActivity(intent);
            }
        });
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    String s1=String.valueOf(snapshot1.child("systolic_pressure").getValue());
                    String s2=String.valueOf(snapshot1.child("diastolic_pressure").getValue());
                    t1.setText(s1);
                    t2.setText(s2);

                    System.out.println("Heart Rate: " + s1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       /* databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot childSnapshot : snapshot.getChildren()){
                    String heartRate = childSnapshot.child("heart_rate").getValue(String.class);
                    if (heartRate != null) {
                        // Handle the heart rate value
                        // You can log it or perform any other operation here
                        // For example:
                        System.out.println("Heart Rate: " + heartRate);


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error
            }
        });*/
    }
}
