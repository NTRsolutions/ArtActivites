package com.example.tdx.artactivities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tdx on 10/9/15.
 */
public class DispalyCardActivity extends AppCompatActivity {


    TextView titleText;

    TextView descriptionText;
    TextView materialsText;
    TextView directionsText;

    ImageView cardImage;

    MenuItem star;

    boolean starred;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.card_menu, menu);

        star = menu.findItem(R.id.action_star);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card);

        starred = false;

        // Enable the "Up" button for more navigation options
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        titleText = (TextView) findViewById(R.id.card_title);
        descriptionText = (TextView) findViewById(R.id.card_description);
        materialsText = (TextView) findViewById(R.id.card_materials);
        directionsText = (TextView) findViewById(R.id.card_directions);

        cardImage = (ImageView) findViewById(R.id.card_imageView);

        Intent myIntent = getIntent();

        Card myCard = (Card)myIntent.getSerializableExtra("MyCard");

        setTitle(myCard.getName());

        titleText.setText(myCard.getName());
        descriptionText.setText(myCard.getDescription());
        materialsText.setText(myCard.getMaterials());
        directionsText.setText(myCard.getDirections());


        cardImage.setImageResource(myCard.getImageID(getApplicationContext()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
/*
        switch (item.getItemId()) {
            case R.id.action_star:
                if (starred) {
                    star.setIcon(R.drawable.outline_star);
                    starred = false;
                }else{
                    star.setIcon(R.drawable.filled_star);
                    starred = true;
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
*/
        return false;
    }


}
