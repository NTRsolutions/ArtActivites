package com.gatewaytosuccess.craftymadness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tyler Decker on 10/9/15.
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.gatewaytosuccess.craftymadness.R.layout.activity_display_card);

        starred = false;


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        titleText = (TextView) findViewById(com.gatewaytosuccess.craftymadness.R.id.card_title);
        descriptionText = (TextView) findViewById(com.gatewaytosuccess.craftymadness.R.id.card_description);
        materialsText = (TextView) findViewById(com.gatewaytosuccess.craftymadness.R.id.card_materials);
        directionsText = (TextView) findViewById(com.gatewaytosuccess.craftymadness.R.id.card_directions);

        cardImage = (ImageView) findViewById(com.gatewaytosuccess.craftymadness.R.id.card_imageView);

        Intent myIntent = getIntent();

        Card myCard = (Card)myIntent.getSerializableExtra("MyCard");

        setTitle(myCard.getName());

        titleText.setText(myCard.getName());
        descriptionText.setText(myCard.getDescription());
        materialsText.setText(myCard.getMaterials());
        directionsText.setText(myCard.getDirections());


        cardImage.setImageResource(myCard.getImageID(getApplicationContext()));
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }
*/

}
