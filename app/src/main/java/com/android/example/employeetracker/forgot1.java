package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class forgot1 extends AppCompatActivity {


    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot1);
        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);

        Intent l = getIntent();
        Bundle w = l.getExtras();
        String us = w.getString("yolo");

        TextView g = (TextView) findViewById(R.id.pe1);
        g.setText(us);
    }

    public void back1(View view)
    {
        Intent k =new Intent(this,existing.class);
        startActivity(k);
    }

}