package com.android.example.employeetracker;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
//import android.location.Location;
//import android.location.LocationListener;
import android.location.LocationManager;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationListener;

import org.w3c.dom.Text;

public class EmployeeDetails extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener , GoogleApiClient.ConnectionCallbacks {

    TextView tr1;
    TextView tr2,ty1,ty2,ty3,ty4;

    String p = "fgdgd";
    SQLiteDatabase db;
    String np = "pw[ew";
    GoogleApiClient g;

    double l1=67.00;
    double l2=28.00;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        db = openOrCreateDatabase("USERDB1", Context.MODE_PRIVATE, null);
        Intent i = getIntent();
        Bundle r = i.getExtras();
        np = r.getString("yolo");
        ty1 = (TextView) findViewById(R.id.t1);
        ty2 = (TextView) findViewById(R.id.t2);
        ty3 = (TextView) findViewById(R.id.t3);
        ty4 = (TextView) findViewById(R.id.t4);

        Cursor c = db.rawQuery("SELECT * FROM user4", null);
        tr1 = (TextView) findViewById(R.id.t5);
        tr2 = (TextView) findViewById(R.id.t6);

        String nh;
        nh = "apl";
        while (c.moveToNext()) {
            String v = c.getString(5);
            String v1 = c.getString(0);
            String v2 = c.getString(1);
            String v3 = c.getString(2);
            String v4 = c.getString(3);
            String v5 = c.getString(4);

            if (v.equals(np)) {
                ty1.setText(v1);
                ty2.setText(v3);
                ty3.setText(v4);
                ty4.setText(v5);
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


        db = openOrCreateDatabase("USERDB1" , Context.MODE_PRIVATE ,null );
        db.execSQL("CREATE TABLE IF NOT EXISTS master3( branch VARCHAR , year VARCHAR , rolll VARCHAR ,lat VARCHAR , lon VARCHAR );");

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

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected !!", Toast.LENGTH_SHORT).show();

        Location l = LocationServices.FusedLocationApi.getLastLocation(g);
        if (g != null) {
            l1 = (double) (l.getLatitude());
            l2 = (double) (l.getLongitude());
            tr1.setText("" + l1);
            tr2.setText("" + l2);

        }
        else
        {
            tr1.setText("Not Available");
            tr2.setText("Not Available");
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        g.connect();
    }

    public void logout(View view) {
        Location l = LocationServices.FusedLocationApi.getLastLocation(g);
        if (g != null) {
            l1 = (double) (l.getLatitude());
            l2 = (double) (l.getLongitude());
            tr1.setText("" + l1);
            tr2.setText("" + l2);

        }
        else
        {
            tr1.setText("Not Available");
            tr2.setText("Not Available");
        }

        //int h1 = (int)(l1);
        //int h2 = (int)(l2);

        String la = tr1.getText().toString();
        String lo = tr2.getText().toString();
        String bra = ty2.getText().toString();
        String year = ty3.getText().toString();
        String roll = ty4.getText().toString();

        Cursor c = db.rawQuery("SELECT * FROM master3" , null);
        if(c.getCount()==0)
        {
            db.execSQL("INSERT INTO master3 VALUES('" + bra +"' , '" + year + "' , '" + roll + "' , '" + la + "' , '" + lo + "' );");
        }
        else
        {
            db.execSQL("DELETE FROM master3 WHERE branch = '" + bra + "' AND year = '" + year + "' AND rolll = '" + roll + "' ;" );
            db.execSQL("INSERT INTO master3 VALUES('" + bra +"' , '" + year + "' , '" + roll + "' , '" + la + "' , '" + lo + "' );");
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void updat(View view) {
        Intent i = new Intent(this, update.class);
        i.putExtra("yolo1", np);
        startActivity(i);
    }


    public void updatel(View view)
    {
        Location l = LocationServices.FusedLocationApi.getLastLocation(g);
        if (g != null) {
            l1 = (double) (l.getLatitude());
            l2 = (double) (l.getLongitude());
            tr1.setText("" + l1);
            tr2.setText("" + l2);

        }
        else
        {
            tr1.setText("Not Available");
            tr2.setText("Not Available");
        }
    }

    public void maps(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse("http://maps.google.com/maps?q=" + String.valueOf(l1) + "," + String.valueOf(l2)));
        startActivity(i);
    }

}