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
import android.widget.TextView;
import android.widget.Toast;

public class existing extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing);

        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS admin( user_id VARCHAR PRIMARY KEY, name VARCHAR , password VARCHAR );");
    }

    public void login(View view)
    {
        String uname = "sdsd" , pass = "sdsds";


        EditText e11 = (EditText) findViewById(R.id.e1);
        Boolean bg1 = e11.getText().toString().equals("");
        if(bg1==false)
            uname = e11.getText().toString();
        EditText e21 = (EditText) findViewById(R.id.e2);
        Boolean bg2 = e21.getText().toString().equals("");
        if(bg2==false)
            pass = e21.getText().toString();

        if(bg1==true || bg2==true)
            Toast.makeText(this , "Invalid Credentials !!" , Toast.LENGTH_SHORT).show();
        else {
            Cursor c = db.rawQuery("SELECT * FROM admin", null);
            if (c.getCount() == 0) {
                Toast.makeText(this, "No record found !!", Toast.LENGTH_SHORT).show();
            } else {
                int f = 0;
                while (c.moveToNext()) {
                    String n1 = c.getString(0);
                    String n2 = c.getString(2);
                    if (n1.equals(uname) && n2.equals(pass)) {
                        f = 1;
                        break;
                    }
                }
                if (f == 0) {
                    Toast.makeText(this, "No record Found !!", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "Logging in as admin", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, admin.class);
                    i.putExtra("yolo" , uname);
                    startActivity(i);
                }
            }
        }
    }

    public void forgotyr(View view)
    {
        EditText n1 = (EditText) findViewById(R.id.e1);
        Boolean v = n1.getText().toString().equals("");
        if(v==true)
            Toast.makeText(this , "Enter Correct Username" , Toast.LENGTH_SHORT).show();
        else
        {
            int f=0;
            String yo = n1.getText().toString();
            String n="sfs";
            Cursor c = db.rawQuery("SELECT * FROM admin", null);
            while(c.moveToNext())
            {
                String m = c.getString(0);
                String pass = c.getString(2);
                if(m.equals(yo))
                {
                    f=1;
                    n = pass;
                    break;
                }
            }
            if(f==0)
                Toast.makeText(this , "Enter Correct Username" , Toast.LENGTH_SHORT).show();
            else
            {
                Intent h = new Intent(this , forgot1.class);
                h.putExtra("yolo" , n);
                startActivity(h);
            }
        }
    }
}
