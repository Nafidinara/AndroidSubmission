package com.example.submissionpemula;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] titleData;
    String[] infoData;
    TypedArray imageData;
    Adapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        adapter = new Adapter(this);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        prepare();
        addItem();

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Items mItems = new Items();
                mItems.setImage(imageData.getResourceId(position, -1));
                mItems.setTitle(titleData[position]);
                mItems.setInfo(infoData[position]);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data", mItems);
                startActivity(intent);
            }
        });
    }

    public void prepare() {
        titleData = getResources().getStringArray(R.array.destination_name);
        infoData = getResources().getStringArray(R.array.destination_info);
        imageData = getResources().obtainTypedArray(R.array.destination_image);
    }

    public void addItem() {
        ArrayList<Items> mItems = new ArrayList<>();

        for (int i = 0; i < titleData.length; i++) {
            Items destination = new Items();
            destination.setImage(imageData.getResourceId(i, -1));
            destination.setTitle(titleData[i]);
            destination.setInfo(infoData[i]);
            mItems.add(destination);
        }
        adapter.setMovieItems(mItems);
    }
}
