package com.val.tdx.artactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.val.tdx.artactivities.R;

/**
 * Created by Tyler Decker on 10/8/15.
 */
public class SearchScreenActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSearch;
    EditText searchTerms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_single);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSearch = (Button)findViewById(R.id.buttonSearchSubmit);
        btnSearch.setOnClickListener(this);
        searchTerms = (EditText) findViewById(R.id.editTextSerachTerms);
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(getApplicationContext(), SearchResultsDisplayActivity.class);
        myIntent.putExtra("materials", searchTerms.getText().toString());
        myIntent.putExtra("name", searchTerms.getText().toString());
        startActivity(myIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}