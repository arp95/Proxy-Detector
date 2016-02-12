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
import android.widget.EditText;
import android.widget.Toast;

public class neww2 extends AppCompatActivity {


    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neww2);
        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user4(name VARCHAR , pass VARCHAR , branch VARCHAR , year VARCHAR , roll VARCHAR , deviceid VARCHAR);");

    }

    public void finish1(View view)
    {
        String name="S",pass="sfsss",branch="sfs",year="dgd",roll="sdsd";

        EditText ey1 = (EditText) findViewById(R.id.n1);
        Boolean b1 = ey1.getText().toString().equals("");
        if(b1==false)
            name = ey1.getText().toString();

        EditText ey2 = (EditText) findViewById(R.id.n2);
        Boolean b2 = ey2.getText().toString().equals("");
        if(b2==false)
            pass = ey2.getText().toString();

        EditText ey3 = (EditText) findViewById(R.id.n3);
        Boolean b3 = ey3.getText().toString().equals("");
        if(b3==false)
            branch = ey3.getText().toString();

        EditText ey4 = (EditText) findViewById(R.id.n4);
        Boolean b4 = ey4.getText().toString().equals("");
        if(b4==false)
            year = ey4.getText().toString();

        EditText ey5 = (EditText) findViewById(R.id.n5);
        boolean b5 = ey5.getText().toString().equals("");
        if(b5==false)
            roll = ey5.getText().toString();

        if(b1==true || b2==true || b3==true || b4==true || b5==true)
            Toast.makeText(this , "Invalid Credentials" , Toast.LENGTH_SHORT).show();
        else {
            String deviceId = "sffaf";
            deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
            Cursor c = db.rawQuery("SELECT * FROM user4", null);
            if (c.getCount() == 0) {
                Toast.makeText(this, "Created Account", Toast.LENGTH_LONG).show();
                db.execSQL("INSERT INTO user4 VALUES('" + name + "' , '" + pass + "' , '" + branch + "' , '" + year + "' , '" + roll + "' , '" + deviceId + "' );");
                Intent i = new Intent(this, existing1.class);
                startActivity(i);
            } else {
                while (c.moveToNext()) {
                    String m1 = c.getString(2);
                    String m2 = c.getString(3);
                    String m3 = c.getString(4);
                    String m4 = c.getString(5);
                    if (m1.equals(branch) && m2.equals(year) && m3.equals(roll))
                        Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
                    else if (m4.equals(deviceId))
                        Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(this, "Created User Account", Toast.LENGTH_LONG).show();
                        db.execSQL("INSERT INTO user4 VALUES('" + name + "' , '" + pass + "' , '" + branch + "' , '" + year + "' , '" + roll + "' , '" + deviceId + "' );");
                        Intent i = new Intent(this, existing1.class);
                        startActivity(i);
                    }
                }
            }
        }
    }
}