package com.example.tdx.artactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

/**
 * Created by tdx on 10/8/15.
 */
public class CurrentMonthListDisplayActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView myListView;
    List<Card> cards;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card_list);

        myListView = (ListView) findViewById(R.id.card_list);

        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            cards = parser.parse(getAssets().open("cards.xml"));
            CardListAdapter adapter = new CardListAdapter(this, R.layout.list_row, cards);
            View header = (View) getLayoutInflater().inflate(R.layout.list_row, null);
            myListView.addHeaderView(header);
            myListView.setAdapter(adapter);
        } catch(IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

    }


}
