package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.BoringLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class update1 extends AppCompatActivity {

    SQLiteDatabase db;
    String hj="sfsfs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update1);
        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        Intent  i =getIntent();
        Bundle y = i.getExtras();
        hj = y.getString("haha");

    }

    public void update2(View view)
    {
        TextView tb1 = (TextView) findViewById(R.id.up1);
        TextView tb2 = (TextView) findViewById(R.id.up2);

        Boolean b1 = tb1.getText().toString().equals("");
        Boolean b2 = tb2.getText().toString().equals("");
        if(b1==true || b2==true)
            Toast.makeText(this , "Enter proper info" , Toast.LENGTH_SHORT).show();
        else
        {
            String name = tb1.getText().toString();
            String pass = tb2.getText().toString();

            db.execSQL("UPDATE admin SET name = '" + name + "' , password = '" + pass + "' WHERE user_id = '" + hj + "' ;");
            Intent f = new Intent(this , admin.class);
            f.putExtra("yolo" , hj);
            startActivity(f);
        }
    }
}