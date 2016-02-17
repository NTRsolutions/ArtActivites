package com.gatewaytosuccess.craftymadness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tyler Decker on 10/8/15.
 */
public class SearchScreenActivity_old extends AppCompatActivity implements View.OnClickListener{

    Button btnSearch;
    EditText searchName;
    EditText searchMaterials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.gatewaytosuccess.craftymadness.R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSearch = (Button)findViewById(com.gatewaytosuccess.craftymadness.R.id.buttonSearchSubmit);
        btnSearch.setOnClickListener(this);
        searchName = (EditText) findViewById(com.gatewaytosuccess.craftymadness.R.id.editTextSerachName);
        searchMaterials = (EditText) findViewById(com.gatewaytosuccess.craftymadness.R.id.editTextSearchMaterials);
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(getApplicationContext(), SearchResultsDisplayActivity.class);
        myIntent.putExtra("materials", searchMaterials.getText().toString() );
        myIntent.putExtra("name", searchName.getText().toString());
        startActivity(myIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == com.gatewaytosuccess.craftymadness.R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}