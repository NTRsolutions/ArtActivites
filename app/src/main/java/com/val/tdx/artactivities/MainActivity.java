package com.val.tdx.artactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton currentMonthButton;
    ImageButton browseButton;
    ImageButton searchButton;
    ImageButton randomButton;
    Cards cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentMonthButton = (ImageButton) findViewById(R.id.ButtonCurrentMonth);
        browseButton = (ImageButton) findViewById(R.id.ButtonBrowse);
        searchButton = (ImageButton) findViewById(R.id.ButtonSearch);
        randomButton = (ImageButton) findViewById(R.id.ButtonRandom);

        currentMonthButton.setOnClickListener(this);
        browseButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        randomButton.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = null;
        switch (v.getId()) {
            case R.id.ButtonCurrentMonth:
                myIntent = new Intent(getApplicationContext(), CurrentMonthListDisplayActivity.class);
                break;
            case R.id.ButtonBrowse:
                myIntent = new Intent(getApplicationContext(), BrosweMonthActivity.class);
                break;
            case R.id.ButtonSearch:
                myIntent = new Intent(getApplicationContext(), SearchScreenActivity.class);
                break;
            case R.id.ButtonRandom:
                cards = new Cards(this);
                Card selectedCard = cards.getRandomCard();
                myIntent = new Intent(getApplicationContext(), DispalyCardActivity.class);
                myIntent.putExtra("MyCard", selectedCard);
                break;
            default:
                break;
        }
        if (myIntent != null) { startActivity(myIntent); }
    }
}
