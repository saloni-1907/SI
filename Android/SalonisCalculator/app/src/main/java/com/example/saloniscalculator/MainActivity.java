package com.example.saloniscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_add;
        Button button_subtract;
        Button button_multiply;
        Button button_divide;
        TextView t1=findViewById(R.id.answer);

        button_add=findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1=findViewById(R.id.num1);
                EditText num2=findViewById(R.id.num2);
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());

                t1.setText(n1+n2+" ");
            }
        });
        button_subtract=findViewById(R.id.button_subtract);
        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1=findViewById(R.id.num1);
                EditText num2=findViewById(R.id.num2);
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());

                t1.setText(n1-n2+" ");
            }
        });
        button_multiply=findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1=findViewById(R.id.num1);
                EditText num2=findViewById(R.id.num2);
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());

                t1.setText(n1*n2+" ");
            }
        });
        button_divide=findViewById(R.id.button_divide);
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1=findViewById(R.id.num1);
                EditText num2=findViewById(R.id.num2);
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                if(n2==0)
                {
                    Toast.makeText(MainActivity.this, "Division by zero not allowed!!", Toast.LENGTH_SHORT).show();
                    num2.setText("");
                }
                t1.setText(n1/n2+" ");
            }
        });

    }


}