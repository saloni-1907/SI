package com.example.quizzyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizzyme.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    ActivityQuizBinding binding;
    ArrayList<Question> questions;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        questions=new ArrayList<>();
        questions.add(new Question("What is Earth",
                "Planet","Sun","Star","Human","Planet"));
        questions.add(new Question("What is Pizza?",
                "Planet","Food","Star","Human","Food"));
        setNextQuestion();
    }
    void setNextQuestion()
    {
        if(index<questions.size())
        {
            Question question=questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());

        }
    }
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.nextBtn:
                if(index<questions.size()) {
                    index++;
                    setNextQuestion();
                }
                else
                {
                    Toast.makeText(this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}