package com.example.registrationlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById((R.id.password));
        register=(Button)findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail=email.getText().toString();
                String txtPass=password.getText().toString();
                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPass))
                {
                    Toast.makeText(RegistrationActivity.this,"Empty Credentials",Toast.LENGTH_LONG).show();
                }
                if(txtPass.length()<8)
                {
                    Toast.makeText(RegistrationActivity.this,"Password must be minimum 8 characters long",Toast.LENGTH_LONG).show();
                }
                else
                {
                    registerUser(txtEmail,txtPass);
                }
            }

            private void registerUser(String txtEmail, String txtPass) {
                auth.createUserWithEmailAndPassword(txtEmail,txtPass).addOnCompleteListener(RegistrationActivity.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            Toast.makeText(RegistrationActivity.this,"Registration Successful!",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(RegistrationActivity.this,"Registration Failed!",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}