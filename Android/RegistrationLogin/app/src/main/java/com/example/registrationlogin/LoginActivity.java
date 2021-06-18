package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button btn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText)findViewById(R.id.loginEmail);
        password=(EditText)findViewById(R.id.loginPassword);
        btn=(Button)findViewById(R.id.loginBtn);
        auth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lemail=email.getText().toString();
                String lpass=password.getText().toString();
                loginUser(lemail,lpass);
            }
        });

    }

    private void loginUser(String loginEmail, String loginPassword) {
        auth.signInWithEmailAndPassword(loginEmail,loginPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this,StartActivity.class));
                finish();
            }
        });
    }
}