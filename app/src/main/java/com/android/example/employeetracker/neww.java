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
import android.widget.EditText;
import android.widget.Toast;

public class neww extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neww);
        db=openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS admin( user_id VARCHAR PRIMARY KEY, name VARCHAR , password VARCHAR );");
    }

    public void finish(View view)
    {

        String uname="dfs" , name="ss" , pass="sfs";

        EditText e1 = (EditText) findViewById(R.id.n1);
        Boolean bh1 = e1.getText().toString().equals("");
        if(bh1==false)
            uname = e1.getText().toString();
        EditText e2 = (EditText) findViewById(R.id.n2);
        Boolean bh2 = e2.getText().toString().equals("");
        if(bh2==false)
            name = e2.getText().toString();
        EditText e3 = (EditText) findViewById(R.id.n3);
        Boolean bh3 = e3.getText().toString().equals("");
        if(bh3==false)
            pass = e3.getText().toString();

        if(bh1==true || bh2==true || bh3==true)
            Toast.makeText(this , "Invalid Credentials !!" , Toast.LENGTH_SHORT).show();

        else
        {

            Cursor c= db.rawQuery("SELECT * FROM admin" , null);
            if(c.getCount()==0)
            {
                Toast.makeText(this, "Creating Account" , Toast.LENGTH_SHORT).show();
                db.execSQL("INSERT INTO admin VALUES('" + uname + "' , '" + name + "' , '" + pass + "' );");
                Intent i = new Intent(this,existing.class);
                startActivity(i);
            }

            else
            {

                int f=0;
                while(c.moveToNext())
                {
                    String s1=c.getString(0);
                    if(s1.equals(uname))
                    {
                        f=1;
                        break;
                    }
                }
                if(f==1)
                {
                    Toast.makeText(this, "Invalid Username !!" , Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(this, "Creating Account" , Toast.LENGTH_SHORT).show();
                    db.execSQL("INSERT INTO admin VALUES('" + uname + "' , '" + name + "' , '" + pass + "' );");
                    Intent i = new Intent(this,existing.class);
                    startActivity(i);

                }
            }
        }
    }
}