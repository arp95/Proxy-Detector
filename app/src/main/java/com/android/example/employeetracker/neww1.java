package com.android.example.employeetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class neww1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neww1);
    }

    public void r1(View view)
    {
        Intent i = new Intent(this , neww.class);
        startActivity(i);
    }

    public void r2(View view)
    {
        Intent i = new Intent(this , neww2.class);
        startActivity(i);
    }

}
