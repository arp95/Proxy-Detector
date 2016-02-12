package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.w3c.dom.Text;

public class admin extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener{

    SQLiteDatabase db;
    GoogleApiClient g;

    TextView tl3,tl4;

    String user1="sfsf",b="ss",y="3",lr="ss",hr="dsd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE , null);
        Intent g1 = getIntent();
        Bundle d = g1.getExtras();
        user1 = d.getString("yolo");

        TextView tl1 = (TextView) findViewById(R.id.te1);
        TextView tl2 = (TextView) findViewById(R.id.te2);
        tl3 = (TextView) findViewById(R.id.te3);
        tl4 = (TextView) findViewById(R.id.te4);


        db.execSQL("CREATE TABLE IF NOT EXISTS master3( branch VARCHAR , year VARCHAR , rolll VARCHAR ,lat VARCHAR , lon VARCHAR );");

        Cursor c = db.rawQuery("SELECT * FROM admin;" , null);
        while(c.moveToNext())
        {
            String ml1 = c.getString(0);
            String ml2 = c.getString(1);

            if(ml1.equals(user1)){

                tl1.setText(ml1);
                tl2.setText(ml2);
                break;
            }
        }

        if(checkPlayServices())
        {
            g = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }

    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        1000).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(g!=null)
            g.connect();
    }

    @Override
    protected void onPause() {
        g.disconnect();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Toast.makeText(this, "Connection Failed" , Toast.LENGTH_SHORT).show();
    }


    double l1=10.00,l2=19.00;

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected !!", Toast.LENGTH_SHORT).show();

        Location l = LocationServices.FusedLocationApi.getLastLocation(g);
        if (g != null) {
            l1 = (double) (l.getLatitude());
            l2 = (double) (l.getLongitude());
            tl3.setText("" + l1);
            tl4.setText("" + l2);

        }
        else
        {
            tl3.setText("Not Available");
            tl4.setText("Not Available");
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        g.connect();
    }

    public void apply(View view) {


        int cnt=0;
        EditText et1 = (EditText) findViewById(R.id.pp1);
        Boolean b1 = et1.getText().toString().equals("");

        EditText et2 = (EditText) findViewById(R.id.pp2);
        Boolean b2 = et2.getText().toString().equals("");

        EditText et3 = (EditText) findViewById(R.id.pp3);
        Boolean b3 = et3.getText().toString().equals("");

        EditText et4 = (EditText) findViewById(R.id.pp4);
        Boolean b4 = et4.getText().toString().equals("");


        if (b1 == true || b2 == true || b3 == true || b4 == true)
            Toast.makeText(this, "Enter all fields !!", Toast.LENGTH_SHORT).show();
        else {
            b = et1.getText().toString();
            y = et2.getText().toString();
            lr = et3.getText().toString();
            hr = et4.getText().toString();

            String lat = tl3.getText().toString();
            String lon = tl4.getText().toString();


            int lroll = Integer.parseInt(lr);
            int hroll = Integer.parseInt(hr);

            Cursor c = db.rawQuery("SELECT * FROM master3", null);
            if (c.getCount() != 0) {

                Toast.makeText(this , "Delivering the count...Please Wait" , Toast.LENGTH_LONG).show();
                while (c.moveToNext()) {
                    String bra = c.getString(0);
                    String year = c.getString(1);
                    String roll = c.getString(2);

                    int roll1 = Integer.parseInt(roll);

                    String lati = c.getString(3);
                    String longi = c.getString(4);

                    if (b.equals(bra) && y.equals(year) && roll1 >= lroll && roll1 <= hroll && lati.equals(lat) && longi.equals(lon))
                        cnt++;
                }
            }

            String yolo = "" + cnt;
            Intent i = new Intent(this, countt.class);
            i.putExtra("haha", yolo);
            startActivity(i);

        }
    }



    public void update1(View view)
    {
        Intent l = new Intent(this , update1.class);
        l.putExtra("haha" , user1);
        startActivity(l);
    }

    public void logout(View view)
    {
        Intent i = new Intent(this , MainActivity.class);
        startActivity(i);
    }

    public void cleara(View view)
    {

        EditText et1 = (EditText) findViewById(R.id.pp1);
        Boolean b1 = et1.getText().toString().equals("");

        EditText et2 = (EditText) findViewById(R.id.pp2);
        Boolean b2 = et2.getText().toString().equals("");

        EditText et3 = (EditText) findViewById(R.id.pp3);
        Boolean b3 = et3.getText().toString().equals("");

        EditText et4 = (EditText) findViewById(R.id.pp4);
        Boolean b4 = et4.getText().toString().equals("");


        if(b1==true || b2==true || b3== true || b4==true)
            Toast.makeText(this , "Enter all fields !!" , Toast.LENGTH_SHORT).show();
        else
        {
            b = et1.getText().toString();
            y = et2.getText().toString();
            lr = et3.getText().toString();
            hr = et4.getText().toString();

            Cursor c1 = db.rawQuery("SELECT * FROM master3",null);
            int lroll = Integer.parseInt(lr);
            int hroll = Integer.parseInt(hr);

            if(c1.getCount()!=0)
            {
                while (c1.moveToNext())
                {
                    String bra = c1.getString(0);
                    String year = c1.getString(1);
                    String roll = c1.getString(2);
                    int r = Integer.parseInt(roll);
                    if(bra.equals(b) && year.equals(y) && r>=lroll && r<=hroll)
                        db.execSQL("DELETE FROM master3 WHERE branch = '" + bra + "' AND year = '" + year + "' AND rolll = '" + roll + "' ;");
                }
            }
            Toast.makeText(this , "Records Deleted !!" , Toast.LENGTH_SHORT).show();
        }
    }
}