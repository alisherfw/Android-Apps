package com.example.recyclerview;

import Adapter.MyAdapter;
import Model.ListItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItem item1 = new ListItem("Spiderman", "Super fantastic film", "Nice 4.2");
        ListItem item2 = new ListItem("Joker", "Thriller movie", "Great 5.0");

//        for(int i = 0; i < 10; i++) {
//            ListItem item = new ListItem(
//                    "Item" + (i+1),
//                    "description",
//                    "Excellent"
//            );
//            listItems.add(item);
//        }
        listItems.add(item1);
        listItems.add(item2);

        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}