package com.example.retrofitwithmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitwithmvvm.model.Data;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recData;
    DataViewModel dataViewModel;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recData = findViewById(R.id.rec_data);
        recData.setLayoutManager(new LinearLayoutManager(this));

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getUsersData().observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> data) {
                adapter = new DataAdapter(MainActivity.this,data);
                recData.setAdapter(adapter);
            }
        });
    }
}