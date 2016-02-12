package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    SQLiteDatabase db;
    String b1 = "sfsfs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = openOrCreateDatabase("USERDB1", Context.MODE_PRIVATE, null);
        Intent i = getIntent();
        Bundle p = i.getExtras();
        b1 = p.getString("yolo1");

    }

    public void update5(View view) {
        EditText rt1 = (EditText) findViewById(R.id.z1);
        Boolean b1 = rt1.getText().toString().equals("");


        EditText rt2 = (EditText) findViewById(R.id.z2);
        Boolean b2 = rt2.getText().toString().equals("");


        EditText rt3 = (EditText) findViewById(R.id.z3);
        Boolean b3 = rt3.getText().toString().equals("");


        EditText rt4 = (EditText) findViewById(R.id.z4);
        Boolean b4 = rt4.getText().toString().equals("");


        EditText rt5 = (EditText) findViewById(R.id.z5);
        Boolean b5 = rt5.getText().toString().equals("");

        if (b1 == true || b2 == true || b3 == true || b4 == true || b5 == true)
            Toast.makeText(this, "Fill the empty fields", Toast.LENGTH_SHORT).show();
        else {


            String uname = rt1.getText().toString();
            String pass = rt2.getText().toString();
            String bra = rt3.getText().toString();
            String year = rt4.getText().toString();
            String roll = rt5.getText().toString();
            db.execSQL("UPDATE user4 SET name='" + uname + "' , pass='" + pass + "' , branch = '" + bra + "' , year = '" + year + "' , roll = '" + roll + "' WHERE deviceid = '" + b1 + "' ;");
            Toast.makeText(this, "Record Updated !!", Toast.LENGTH_SHORT).show();
            Intent p1 = new Intent(this, EmployeeDetails.class);
            p1.putExtra("yolo", b1);
            startActivity(p1);

        }
    }
}