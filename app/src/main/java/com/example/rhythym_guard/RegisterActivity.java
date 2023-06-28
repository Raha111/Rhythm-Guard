package com.example.rhythym_guard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText username,email,phone,password,cpassword;
    private Button btn;
    private TextView textview2;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.inputUsername);
        email=findViewById(R.id.inputEmail);
        phone=findViewById(R.id.inputPhone2);
        password=findViewById(R.id.inputPassword2);
        cpassword=findViewById(R.id.inputConfirmPassword);
        btn=findViewById(R.id.btnRegister);
        textview2=findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st_phone=phone.getText().toString();
                databaseReference.child("users").child(st_phone).child("Phone").setValue(st_phone);

                String st_username=username.getText().toString();
                databaseReference.child("users").child(st_phone).child("UserName").setValue(st_username);
                //String st_email=email.getText().toString();
                //databaseReference.child("users").child(st_phone).child("Email").setValue(st_email);
                String st_password=password.getText().toString();
                databaseReference.child("users").child(st_phone).child("Password").setValue(st_password);
               Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}