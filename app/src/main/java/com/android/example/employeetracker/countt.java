package com.android.example.employeetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class countt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countt);

        Intent p =getIntent();
        Bundle b = p.getExtras();
        String s = b.getString("haha");
        TextView tp = (TextView) findViewById(R.id.yu1);
        tp.setText(s);

    }
}
