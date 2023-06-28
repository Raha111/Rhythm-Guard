package com.example.rhythym_guard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText phone,password;
    Button btn;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=(EditText) findViewById(R.id.inputPhone2);
        password=(EditText) findViewById(R.id.inputPassword2);
        btn=(Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sphone=phone.getText().toString();
                String spassword=password.getText().toString();
                if(sphone.isEmpty()||spassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "PLEASE ENTER YOUR MOBILE OR PASSWORD", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(sphone))
                            {
                                String getpass=snapshot.child(sphone).child("Password").getValue(String.class);
                                if(getpass.equals(spassword))
                                {
                                    Intent intent;
                                    intent = new Intent(LoginActivity.this,HomeActivity.class);
                                    intent.putExtra("phone",sphone);
                                    startActivity(intent);

                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this,"WRONG PASSWORD",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

    }
}