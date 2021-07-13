package com.example.quizzyme;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizzyme.databinding.FragmentProfileBinding;
import com.example.quizzyme.databinding.FragmentWalletBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    FragmentProfileBinding binding;
    FirebaseFirestore database;
    FirebaseAuth auth;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        database=FirebaseFirestore.getInstance();
        database.collection("users")
                .document(FirebaseAuth.getInstance().getUid())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user=documentSnapshot.toObject(User.class);
                binding.emailEdit.setText(String.valueOf(user.getEmail()));
                binding.editPassword.setText(String.valueOf(user.getPass()));
                binding.editName.setText(String.valueOf(user.getName()));
            }
        });


        binding.updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editName.getText().toString();
                String email = binding.emailEdit.getText().toString();
                String pass = binding.editPassword.getText().toString();
                User us = new User(name,email,pass);
                //FirebaseUser u1 = auth.getCurrentUser();
                database.collection("users")
                        .document(FirebaseAuth.getInstance().getUid())
                        .set(us);
                Toast.makeText(getContext(),"User information updated",Toast.LENGTH_LONG).show();
            }
        });
        return binding.getRoot();
    }
}