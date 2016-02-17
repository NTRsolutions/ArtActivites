package com.gatewaytosuccess.craftymadness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gatewaytosuccess.craftymadness.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Tyler Decker on 10/8/15.
 */
public class CurrentMonthListDisplayActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    ListView myListView;

    Cards cards;

    Calendar myCalendar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card_list);

        myListView = (ListView) findViewById(R.id.card_list);

        cards = new Cards(this);
        myCalendar = Calendar.getInstance();
        SimpleDateFormat myFormat = new SimpleDateFormat("MMMM");
        String month = myFormat.format(myCalendar.getTime());
        Log.d("Month =", month);
        setTitle(month);


        CardListAdapter adapter = new CardListAdapter(this, R.layout.list_row, cards.getCards(month));
        View header = (View) getLayoutInflater().inflate(R.layout.list_row, null);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Card selectedCard = (Card) parent.getItemAtPosition(position);
        Intent myIntent = new Intent(getApplicationContext(), DispalyCardActivity.class);
        myIntent.putExtra("MyCard", selectedCard);
        startActivity(myIntent);

    }


}
