package com.example.quizzyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizzyme.databinding.ActivityResultBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResultActivity extends AppCompatActivity {
ActivityResultBinding binding;
int POINTS =10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        binding=ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int correctAnswers=getIntent().getIntExtra("correct",0);
        int totalQuestions=getIntent().getIntExtra("total",0);

        long points=correctAnswers * POINTS;

        binding.score.setText(String.format("%d/%d",correctAnswers,totalQuestions));
        binding.earnedCoins.setText(String.valueOf(points));

        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection("users")
                .document(FirebaseAuth.getInstance().getUid())
                .update("coins", FieldValue.increment(points));
        binding.leaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.content,new LeaderboardFragment());
//                transaction.commit();
                //Toast.makeText(ResultActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
//                transaction.replace(R.id.content,new LeaderboardFragment());
//                transaction.commit();
                Intent i=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}