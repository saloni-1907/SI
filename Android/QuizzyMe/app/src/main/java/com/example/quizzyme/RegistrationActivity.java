package com.example.quizzyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizzyme.databinding.ActivityMainBinding;
import com.example.quizzyme.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore database;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();
        dialog=new ProgressDialog(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass,name,code;

                email=binding.emailBox.getText().toString();
                pass=binding.passBox.getText().toString();
                name=binding.nameBox.getText().toString();


                User user=new User(name,email,pass);
                dialog.show();
                dialog.setMessage("Creating account...");
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegistrationActivity.this,"Registration Successful!",Toast.LENGTH_LONG).show();
                            String uid=task.getResult().getUser().getUid();
                            database
                                    .collection("users")
                                    .document(uid)
                                    .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {
                                            dialog.dismiss();
                                            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                                            finish();
                                        }
                                        else
                                        {
                                            Toast.makeText(RegistrationActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                        }
                                }
                            });

                        }
                        else
                        {
                            dialog.dismiss();
                            Toast.makeText(RegistrationActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

        binding.loginCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });

    }
}