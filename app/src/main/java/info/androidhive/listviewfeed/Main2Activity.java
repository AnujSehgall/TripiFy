package info.androidhive.listviewfeed;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getActionBar().setDisplayShowHomeEnabled(false);
         ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null)
                && (wifi.isConnected() | datac.isConnected())) {
            //connection is avlilable
            //Toast.makeText(getApplicationContext(),"Available",Toast.LENGTH_SHORT).show();
        }else{
            //no connection
            AlertDialog.Builder builder1 = new AlertDialog.Builder(Main2Activity.this);
            builder1.setTitle("Connectivity Issues");
            builder1.setIcon(R.drawable.ic_launcher);
            builder1.setMessage("Internet Connection Not Found." + "\nPlease check the network settings.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "SETTINGS",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.setComponent(new ComponentName("com.android.settings",
                                    "com.android.settings.Settings$DataUsageSummaryActivity"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();

                            dialog.cancel();
                        }
                    });



            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        Button a,n,s,e,w;
        a= (Button)findViewById(R.id.all);
        n=(Button)findViewById(R.id.north);
        e=(Button)findViewById(R.id.east);
        w=(Button)findViewById(R.id.west);
        s=(Button)findViewById(R.id.south);

       a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                SharedPreferences dist = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                dist.edit().putString("Zone","all" ).commit();
                startActivity(i);
                finish();
            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);

                SharedPreferences dist = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                dist.edit().putString("Zone", "north").commit();
                startActivity(i);
                finish();
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                SharedPreferences dist = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                dist.edit().putString("Zone","east" ).commit();
                startActivity(i);
                finish();
            }
        });

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                SharedPreferences dist = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                dist.edit().putString("Zone","west" ).commit();
                startActivity(i);
                finish();
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                SharedPreferences dist = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                dist.edit().putString("Zone","south" ).commit();
                startActivity(i);
                finish();
            }
        });


    }
}
