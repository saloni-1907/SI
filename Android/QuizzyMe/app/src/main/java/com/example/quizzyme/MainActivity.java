package com.example.quizzyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizzyme.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setSupportActionBar(binding.titleProject);
        ArrayList<CategoryModel> categories=new ArrayList<>();
        categories.add(new CategoryModel("","Mathematics","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        categories.add(new CategoryModel("","Science","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        categories.add(new CategoryModel("","History","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        categories.add(new CategoryModel("","English","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        categories.add(new CategoryModel("","Geography","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        categories.add(new CategoryModel("","Civics","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT4ZlJ8SOMkPPAdLBzCCcJa4MCmI0yVnPtiA&usqp=CAU"));
        CategoryAdapter adapter=new CategoryAdapter(this,categories);
        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.wallet)
        {
            Toast.makeText(this,"Toast is Clicked!",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}