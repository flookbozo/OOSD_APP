package com.example.oosd_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.oosd_app.DB.DBCar;
import com.example.oosd_app.adapter.RecyclerViewAdapter;
import com.example.oosd_app.model.IllegalCar;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<IllegalCar> mCar = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;
    private DBCar mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mDatabase = DBCar.getInstance(SearchActivity.this);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                mCar = mDatabase.carDao().getAllCar();
                final RecyclerView recyclerView = findViewById(R.id.recycler_view);

                mAdapter = new RecyclerViewAdapter(
                        SearchActivity.this,
                        R.layout.item_car,
                        mCar
                );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                        recyclerView.setAdapter(mAdapter);
                    }
                });
            }
        });
        t.start();
    }
}
