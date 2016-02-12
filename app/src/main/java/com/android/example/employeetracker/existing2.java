package com.android.example.employeetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class existing2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing2);

    }


    public void l1(View view)
    {
        Intent i = new Intent(this , existing.class);
        startActivity(i);
    }

    public void l2(View view)
    {
        Intent i = new Intent(this , existing1.class);
        startActivity(i);
    }
}
