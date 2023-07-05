package com.example.rhythym_guard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {
    EditText editTextHeartRate;
    EditText editTextSystolicPressure;
    EditText editTextDiastolicPressure;
    EditText editTextDate;
    EditText editTextTime;
    EditText editTextTextMultiLine;
    Button button2;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("info");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editTextHeartRate = findViewById(R.id.editTextTextPersonName);
        editTextSystolicPressure = findViewById(R.id.editTextTextPersonName2);
        editTextDiastolicPressure = findViewById(R.id.editTextTextPersonName3);

        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        button2 = findViewById(R.id.button);
        String name1 = getIntent().getStringExtra("phone");
        if(name1==null){
            name1 = "01738047196";
        }
        String name = name1;
        System.out.println(name);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String childKey = databaseReference.child("users").child(name).child("date").push().getKey();
                System.out.println(childKey);
                String hr = editTextHeartRate.getText().toString();
                databaseReference.child(name).child(childKey).child("heart_rate").setValue(hr);
                String sp = editTextSystolicPressure.getText().toString();
                databaseReference.child(name).child(childKey).child("systolic_pressure").setValue(sp);
                String dp = editTextDiastolicPressure.getText().toString();
                databaseReference.child(name).child(childKey).child("diastolic_pressure").setValue(dp);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String d = dateFormat.format(new Date());
                databaseReference.child(name).child(childKey).child("date").setValue(d);
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String t = timeFormat.format(new Date());
                databaseReference.child(name).child(childKey).child("time").setValue(t);
                String cmnt = editTextTextMultiLine.getText().toString();
                databaseReference.child(name).child(childKey).child("comment").setValue(cmnt);
                Intent intent;
                intent = new Intent(AddActivity.this,HomeActivity.class);
                intent.putExtra("phone",name);
                startActivity(intent);
            }
        });
    }
}