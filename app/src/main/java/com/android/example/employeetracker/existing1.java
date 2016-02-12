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

public class existing1 extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing1);
        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user4(name VARCHAR , pass VARCHAR , branch VARCHAR , year VARCHAR , roll VARCHAR, deviceid VARCHAR );");
    }

    public void login1(View view)
    {
        String bra="sdsds",year="sdsd",roll="sdsd",pass="sssd";

        EditText x1 = (EditText) findViewById(R.id.v1);
        Boolean b1 = x1.getText().toString().equals("");
        if(b1==false)
            bra= x1.getText().toString();


        EditText x2 = (EditText) findViewById(R.id.v2);
        Boolean b2 = x2.getText().toString().equals("");
        if(b2==false)
            year=x2.getText().toString();


        EditText x3 = (EditText) findViewById(R.id.v3);
        Boolean b3 = x3.getText().toString().equals("");
        if(b3==false)
            roll = x3.getText().toString();

        EditText x4 = (EditText) findViewById(R.id.v4);
        Boolean b4 = x4.getText().toString().equals("");
        if(b4==false)
            pass=x4.getText().toString();

        if(b1==true || b2==true || b3==true || b4==true)
            Toast.makeText(this , "Invalid Credentials !!" , Toast.LENGTH_SHORT).show();

        else {

            String d="dgfdfd";
            Cursor c = db.rawQuery("SELECT * FROM user4", null);
            if (c.getCount() == 0) {
                Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
            } else {
                String deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
                int f = 0;
                while (c.moveToNext()) {
                    String b11 = c.getString(2);
                    String b21 = c.getString(3);
                    String b31 = c.getString(4);
                    String b41 = c.getString(1);
                    d = c.getString(5);
                    if (b11.equals(bra) && b21.equals(year) && b31.equals(roll) && d.equals(deviceId) && b41.equals(pass)) {
                        f = 1;
                        break;
                    }

                }
                if (f == 0) {
                    Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this , "Logging In as user" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this , EmployeeDetails.class);
                    i.putExtra("yolo" ,d);
                    startActivity(i);
                }
            }
        }
    }


    public void login2(View view)
    {
        String bra="sdsds",year="sdsd",roll="sdsd",pass="sssd";

        EditText x1 = (EditText) findViewById(R.id.v1);
        Boolean b1 = x1.getText().toString().equals("");
        if(b1==false)
            bra= x1.getText().toString();


        EditText x2 = (EditText) findViewById(R.id.v2);
        Boolean b2 = x2.getText().toString().equals("");
        if(b2==false)
            year=x2.getText().toString();


        EditText x3 = (EditText) findViewById(R.id.v3);
        Boolean b3 = x3.getText().toString().equals("");
        if(b3==false)
            roll = x3.getText().toString();

        EditText x4 = (EditText) findViewById(R.id.v4);
        Boolean b4 = x4.getText().toString().equals("");
        if(b4==false)
            pass=x4.getText().toString();

        if(b1==true || b2==true || b3==true )
            Toast.makeText(this , "Invalid Credentials !!" , Toast.LENGTH_SHORT).show();

        else {

            Cursor c = db.rawQuery("SELECT * FROM user4", null);
            if (c.getCount() == 0) {
                Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
            } else {
                String deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID) , b41="Ssd";
                int f = 0;
                while (c.moveToNext()) {
                    String b11 = c.getString(2);
                    String b21 = c.getString(3);
                    String b31 = c.getString(4);
                    b41 = c.getString(1);
                    String d = c.getString(5);
                    if (b11.equals(bra) && b21.equals(year) && b31.equals(roll) && d.equals(deviceId)) {
                        f = 1;
                        break;
                    }

                }
                if (f == 0) {
                    Toast.makeText(this, "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(this, forgot.class);
                    i.putExtra("yolo" , b41);
                    startActivity(i);
                }
            }
        }
    }
}