package com.example.registrationlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {
    Button btn;
    EditText task;
    Button addTask;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn=(Button)findViewById(R.id.logoutBtn);
        addTask=(Button)findViewById(R.id.taskBtn);
        task=(EditText)findViewById(R.id.writeTask);
        listView=(ListView)findViewById(R.id.listView);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskString=task.getText().toString();
                if(taskString.isEmpty())
                {
                    Toast.makeText(StartActivity.this,"No task entered!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    FirebaseDatabase.getInstance().getReference().child("Tasks").push().child("Name").setValue(taskString);
                    Toast.makeText(StartActivity.this,"Task entered successfully!",Toast.LENGTH_LONG).show();
                }

            }
        });
        ArrayList<String> list=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(adapter);
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Tasks").child("Name");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot snap: snapshot.getChildren())
                {
                    list.add(snap.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(StartActivity.this,"Logged out successfully!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(StartActivity.this,MainActivity.class));
            }
        });
    }
}