package com.example.quizzyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizzyme.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    ActivityQuizBinding binding;
    ArrayList<Question> questions;
    int index;
    Question question;
    CountDownTimer timer;
    FirebaseFirestore database;
    int correctAnswers=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        questions=new ArrayList<>();
        database=FirebaseFirestore.getInstance();

        String catId=getIntent().getStringExtra("catId");

//        Random random=new Random();
//        int rand=random.nextInt(12);
        database.collection("categories")
                .document(catId)
                .collection("questions")
                .orderBy("index")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                    for(DocumentSnapshot snapshot : queryDocumentSnapshots) {
                        Question question = snapshot.toObject(Question.class);
                        questions.add(question);
                    }
                    setNextQuestion();
                }
            });

        resetTimer();
        setNextQuestion();
    }
    void resetTimer()
    {
        timer=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                binding.timer.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {

            }
        };
    }
    void showAnswer()
    {
        if(question.getAnswer().equals(binding.option1.getText().toString()))
        {
            binding.option1.setBackground(getResources().getDrawable(R.drawable.option_right));
            binding.option2.setEnabled(false);
            binding.option3.setEnabled(false);
            binding.option4.setEnabled(false);
        }
        else if(question.getAnswer().equals(binding.option2.getText().toString()))
        {
            binding.option2.setBackground(getResources().getDrawable(R.drawable.option_right));
            binding.option1.setEnabled(false);
            binding.option3.setEnabled(false);
            binding.option4.setEnabled(false);
        }

        else if(question.getAnswer().equals(binding.option3.getText().toString()))
        {
            binding.option3.setBackground(getResources().getDrawable(R.drawable.option_right));
            binding.option1.setEnabled(false);
            binding.option2.setEnabled(false);
            binding.option4.setEnabled(false);
        }

        else if(question.getAnswer().equals(binding.option4.getText().toString()))
        {
            binding.option4.setBackground(getResources().getDrawable(R.drawable.option_right));
            binding.option1.setEnabled(false);
            binding.option2.setEnabled(false);
            binding.option3.setEnabled(false);
        }

    }
    void setNextQuestion()
    {
        if(timer!=null)
        {
            timer.cancel();
        }
        timer.start();
        if(index<questions.size())
        {
            binding.option1.setEnabled(true);
            binding.option2.setEnabled(true);
            binding.option3.setEnabled(true);
            binding.option4.setEnabled(true);
            binding.questionCounter.setText(String.format("%d/%d",(index+1),questions.size()));
            question=questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());

        }
    }
    void checkAnswer(TextView textview)
    {
        String selectedAnswer=textview.getText().toString();
        if(selectedAnswer.equals(question.getAnswer()))
        {
            correctAnswers++;
            textview.setBackground(getResources().getDrawable(R.drawable.option_right));
            binding.option1.setEnabled(false);
            binding.option2.setEnabled(false);
            binding.option3.setEnabled(false);
            binding.option4.setEnabled(false);
        }
        else
        {
            showAnswer();
            textview.setBackground(getResources().getDrawable(R.drawable.option_wrong));
        }
    }


    void reset()
    {
        binding.option1.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.option_unselected));
    }
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.option_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
                if(timer!=null)
                    timer.cancel();
                TextView selected=(TextView)view;
                checkAnswer(selected);
                break;
            case R.id.nextBtn:
                reset();
                if(index<questions.size()-1) {
                    index++;
                    setNextQuestion();
                }
                else
                {
                    Toast.makeText(this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                    intent.putExtra("correct",correctAnswers);
                    intent.putExtra("total",questions.size());
                    startActivity(intent);

                }
                break;
            case R.id.quitBtn:
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                break;
        }
    }

}