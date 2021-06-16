package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name,age,phone;
        Button button;
        DatabaseReference ref;
        Member member;
        Toast.makeText(this,"Firebase connection successful",Toast.LENGTH_LONG).show();
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.ages);
        phone=(EditText)findViewById(R.id.phone);
        button=(Button)findViewById(R.id.button);
        member=new Member();
        ref= FirebaseDatabase.getInstance().getReference().child("Member");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memName=name.getText().toString().trim();
                int memAge=Integer.parseInt(age.getText().toString().trim());
                long memPhone=Long.parseLong(phone.getText().toString().trim());
                member.setName(memName);
                member.setAge(memAge);
                member.setPhone(memPhone);
                ref.push().setValue(member);
                Toast.makeText(MainActivity.this,"Member successfully registered!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,DisplayActivity.class));
            }
        });
    }
}