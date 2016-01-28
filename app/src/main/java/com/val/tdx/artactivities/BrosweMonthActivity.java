package com.val.tdx.artactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tyler Decker on 10/6/15.
 */
public class BrosweMonthActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnJan;
    Button btnFeb;
    Button btnMar;
    Button btnApr;
    Button btnMay;
    Button btnJun;
    Button btnJul;
    Button btnAug;
    Button btnSep;
    Button btnOct;
    Button btnNov;
    Button btnDec;
    Button btnAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.val.tdx.artactivities.R.layout.activity_browse_month);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnJan = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonJan);
        btnFeb = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonFeb);
        btnMar = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonMar);
        btnApr = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonApr);
        btnMay = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonMay);
        btnJun = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonJun);
        btnJul = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonJul);
        btnAug = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonAug);
        btnSep = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonSep);
        btnOct = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonOct);
        btnNov = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonNov);
        btnDec = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonDec);
        btnAll = (Button) findViewById(com.val.tdx.artactivities.R.id.ButtonAllMonths);

        btnJan.setOnClickListener(this);
        btnFeb.setOnClickListener(this);
        btnMar.setOnClickListener(this);
        btnApr.setOnClickListener(this);
        btnMay.setOnClickListener(this);
        btnJun.setOnClickListener(this);
        btnJul.setOnClickListener(this);
        btnAug.setOnClickListener(this);
        btnSep.setOnClickListener(this);
        btnOct.setOnClickListener(this);
        btnNov.setOnClickListener(this);
        btnDec.setOnClickListener(this);
        btnAll.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent myIntent = new Intent(getApplicationContext(), SelectedMonthListDisplayActivity.class);

        switch (v.getId()) {
            case com.val.tdx.artactivities.R.id.ButtonJan:
                myIntent.putExtra("month", "January");
                break;
            case com.val.tdx.artactivities.R.id.ButtonFeb:
                myIntent.putExtra("month", "Febuary");
                break;
            case com.val.tdx.artactivities.R.id.ButtonMar:
                myIntent.putExtra("month", "March");
                break;
            case com.val.tdx.artactivities.R.id.ButtonApr:
                myIntent.putExtra("month", "April");
                break;
            case com.val.tdx.artactivities.R.id.ButtonMay:
                myIntent.putExtra("month", "May");
                break;
            case com.val.tdx.artactivities.R.id.ButtonJun:
                myIntent.putExtra("month", "June");
                break;
            case com.val.tdx.artactivities.R.id.ButtonJul:
                myIntent.putExtra("month", "July");
                break;
            case com.val.tdx.artactivities.R.id.ButtonAug:
                myIntent.putExtra("month", "August");
                break;
            case com.val.tdx.artactivities.R.id.ButtonSep:
                myIntent.putExtra("month", "September");
                break;
            case com.val.tdx.artactivities.R.id.ButtonOct:
                myIntent.putExtra("month", "October");
                break;
            case com.val.tdx.artactivities.R.id.ButtonNov:
                myIntent.putExtra("month", "November");
                break;
            case com.val.tdx.artactivities.R.id.ButtonDec:
                myIntent.putExtra("month", "December");
                break;
            case com.val.tdx.artactivities.R.id.ButtonAllMonths:
                myIntent.putExtra("month", "All Activites");
                break;
        }

        if (myIntent != null) { startActivity(myIntent); }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == com.val.tdx.artactivities.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
