package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class forgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        Intent h = getIntent();
        Bundle vc = h.getExtras();
        String l = vc.getString("yolo");

        TextView bn = (TextView) findViewById(R.id.p1);
        bn.setText(l);
    }

    public void back(View view)
    {
        Intent i = new Intent(this , existing1.class);
        startActivity(i);
    }

}
