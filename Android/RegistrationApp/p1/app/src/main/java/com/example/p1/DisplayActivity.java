package com.example.p1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayActivity extends AppCompatActivity {
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView phoneDisplay,nameDisplay,ageDisplay;
        phoneDisplay=(TextView)findViewById(R.id.phoneDisplay);
        nameDisplay=(TextView)findViewById(R.id.nameDisplay);
        ageDisplay=(TextView)findViewById(R.id.ageDisplay);
        Button b=(Button)findViewById(R.id.displayButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref= FirebaseDatabase.getInstance().getReference().child("Member");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String n=snapshot.child("name").getValue().toString();
                        String a=snapshot.child("age").getValue().toString();
                        String p=snapshot.child("phone").getValue().toString();
                        nameDisplay.setText(n);
                        ageDisplay.setText(a);
                        phoneDisplay.setText(p);
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(DisplayActivity.this, (CharSequence) error,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}