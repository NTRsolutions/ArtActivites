package com.example.tdx.artactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by tdx on 10/8/15.
 */
public class SearchScreenActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSearch;
    EditText searchName;
    EditText searchMaterials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSearch = (Button)findViewById(R.id.buttonSearchSubmit);
        btnSearch.setOnClickListener(this);

        searchName = (EditText) findViewById(R.id.editTextSerachName);
        searchMaterials = (EditText) findViewById(R.id.editTextSearchMaterials);



    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(getApplicationContext(), SearchResultsDisplayActivity.class);
        myIntent.putExtra("materials", searchMaterials.getText().toString() );
        myIntent.putExtra("name", searchName.getText().toString());
        startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}