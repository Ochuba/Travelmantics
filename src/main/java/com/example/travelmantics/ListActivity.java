package com.example.travelmantics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView rvDeals =(RecyclerView) findViewById(R.id.rvDeals);
        final DealAdapter adapter = new DealAdapter();
        rvDeals.setAdapter(adapter);

        LinearLayoutManager dealsLinearLayoutManager =
                new LinearLayoutManager(this,RecyclerView.VERTICAL,  false);
         rvDeals.setLayoutManager(dealsLinearLayoutManager);

    }
}
