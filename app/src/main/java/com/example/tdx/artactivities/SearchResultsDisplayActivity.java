package com.example.tdx.artactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by tdx on 10/9/15.
 */
public class SearchResultsDisplayActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    ListView myListView;

    Cards cards;
    String name;
    String materials;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card_list);

        Intent myIntent = getIntent();
        name = (String)myIntent.getSerializableExtra("name");
        materials = (String)myIntent.getSerializableExtra("materials");

        myListView = (ListView) findViewById(R.id.card_list);



        cards = new Cards(this);
        CardListAdapter adapter = new CardListAdapter(this, R.layout.list_row, cards.search(name,materials));
        View header = (View) getLayoutInflater().inflate(R.layout.list_row, null);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Card selectedCard = (Card) parent.getItemAtPosition(position);
        Log.d("********", selectedCard.getDescription());

    }


}

