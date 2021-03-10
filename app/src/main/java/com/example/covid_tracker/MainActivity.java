package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Direction;
import com.fujiyuu75.sequent.Sequent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    final TestBroadcastReceiver testBroadcastReceiver = new TestBroadcastReceiver();

    private static final String TAG = "Main_Activity";

    private static final String CHANNEL_ID = "Covid Tracker";
    private static final String CHANNEL_NAME = "Covid-Tracker";
    private static final String CHANNEL_DESC = "This is a test notification";

    private TextView mTotal;
    private TextView mActive;
    private TextView mRecovered;
    private TextView mDead;
    private TextView mUpdated;
    private TextView mRecoveryRate;
    private  TextView mMortalityRate;
    private TextView todayUpdate1,todayUpdate2,todayUpdate3;
    String date;
    int total,recovered,active,dead,today_total,today_reco,today_dead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Inside oncreate");

        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg_blue_color));
        }

        //Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        mTotal = findViewById(R.id.tn_total);
        mActive = findViewById(R.id.tn_active);
        mRecovered = findViewById(R.id.tn_recovered);
        mDead = findViewById(R.id.tn_dead);
        mUpdated = findViewById(R.id.updated);
        mRecoveryRate = findViewById(R.id.rec_rate);
        mMortalityRate = findViewById(R.id.mor_rate);
        todayUpdate1 = findViewById(R.id.tn_today_total);
        todayUpdate2 = findViewById(R.id.tn_today_reco);
        todayUpdate3 = findViewById(R.id.tn_today_dead);

        CardView mMainCard = findViewById(R.id.card_ap);
        CardView mMorCard = findViewById(R.id.card_s2);
        CardView mRecCard = findViewById(R.id.cad_s1);

        Sequent.origin(mMainCard).flow(Direction.FORWARD).duration(700).delay(100).anim(this, Animation.FADE_IN_DOWN).start();
        Sequent.origin(mRecCard).flow(Direction.BACKWARD).duration(800).delay(500).anim(this,Animation.FADE_IN_RIGHT).start();
        Sequent.origin(mMorCard).flow(Direction.FORWARD).duration(800).delay(700).anim(this,Animation.FADE_IN_UP).start();

        CardView mExplore = findViewById(R.id.card_rail);
        Sequent.origin(mExplore).flow(Direction.FORWARD).duration(800).delay(750).anim(this,Animation.FADE_IN_LEFT).start();

        mExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Explore_card.class);
                intent.putExtra("Updated",date);
                startActivity(intent);
            }
        });

        CardView mDos = findViewById(R.id.card_dos);
        Sequent.origin(mDos).flow(Direction.FORWARD).duration(800).delay(750).anim(this,Animation.FADE_IN_RIGHT).start();

        mDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Dos_and_donts_card.class);
                startActivity(intent);
            }
        });

        CardView mDonts = findViewById(R.id.card_donts);
        Sequent.origin(mDonts).flow(Direction.FORWARD).duration(800).delay(800).anim(this,Animation.FADE_IN_UP).start();

        mDonts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = 1;
                Intent intent = new Intent(MainActivity.this,Dos_and_donts_card.class);
                intent.putExtra("Value",val);
                startActivity(intent);
            }
        });

        isConnected();

        if (isConnected()){
            Log.d(TAG,String.valueOf(isConnected()));
            getTnDetails();
            getTodayData();
        }else {
            Log.d(TAG,String.valueOf(isConnected()));
            @SuppressLint({"ResourceAsColor", "ResourceType"}) CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                    .setDialogStyle(CFAlertDialog.CFAlertStyle.BOTTOM_SHEET)
                    .setCornerRadius(50)
                    .setHeaderView(R.layout.alert_dialog_header)
                    .setTitle("NO INTERNET CONNECTION")
                    .setTextGravity(Gravity.CENTER_HORIZONTAL)
                    .setMessage("Enable the internet connection to get our valuable services.")
                    .addButton("ENABLE",-1,-1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED,
                             new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "Internet activated", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Settings.ACTION_SETTINGS);//Intent.ACTION_MAIN
                                    //intent.setClassName("com.android.phone","com.android.phone.Settings");
                                    MainActivity.this.startActivity(intent);
                                    dialog.dismiss();
                                }
                            })
                    .addButton("NO,THANKS",-1,-1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED,
                            new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this,"No Internet",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });
            builder.show();

        }
        /*mRecCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Notification set(10s)", Toast.LENGTH_SHORT).show();
                Intent notiIntent = new Intent(MainActivity.this,NotificationBroadCast.class);
                PendingIntent notiPendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,notiIntent,0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long atCardClick = System.currentTimeMillis();
                long trigger = 1000*10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        atCardClick+trigger,notiPendingIntent);
            }
        });*/

        mMainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!preferences.getBoolean("firstTime",false)){

            repeatingNotification();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstTime",true);
            editor.apply();
        }
    }

    private void repeatingNotification() {
        Toast.makeText(this, "Alarm triggered", Toast.LENGTH_SHORT).show();
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY,20);
        calendar.set(Calendar.MINUTE,24);
        calendar.set(Calendar.SECOND,30);
        Intent rIntent = new Intent(getApplicationContext(),rNotificationBroadcast.class);
        PendingIntent rPendingIntent = PendingIntent.getBroadcast(getApplicationContext(),14,rIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager rAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        rAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,rPendingIntent);
    }

    private void displayNotification(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_heart)
                .setContentTitle("Total           " + "Active       " + "Recovered")
                .setContentText(total + "      " + active + "      " + recovered)
                .setColor(16711680)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        notificationManagerCompat.notify(11,mBuilder.build());

    }

    @Override
   protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(testBroadcastReceiver,filter);
   }

   @Override
   protected void onStop(){
        super.onStop();
        unregisterReceiver(testBroadcastReceiver);
   }

    private boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            //return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", Objects.requireNonNull(e.getMessage()));
        }
        return connected;
    }

    private void getTodayData() {

        Log.d(TAG,"inside today data updation");

        String url = "https://api.covid19india.org/states_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");
                    JSONArray array = response.getJSONArray("states_daily");
                    JSONObject object = array.getJSONObject(array.length()-1);
                    JSONObject object1 = array.getJSONObject(array.length()-2);
                    JSONObject object2 = array.getJSONObject(array.length()-3);
                    Log.d(TAG,"After array");

                    today_total = object2.getInt("tn");
                    today_reco = object1.getInt("tn");
                    today_dead = object.getInt("tn");

                    Log.d(TAG,String.valueOf(today_total));
                    Log.d(TAG,String.valueOf(today_reco));
                    Log.d(TAG,String.valueOf(today_dead));

                    if (today_total == 0){
                        todayUpdate1.setText(getResources().getString(R.string.hyphen));
                    }else {
                        todayUpdate1.setText("+"+today_total);
                    }
                    if (today_reco == 0){
                        todayUpdate2.setText(getResources().getString(R.string.hyphen));
                    }else {
                        todayUpdate2.setText("+"+today_reco);
                    }
                    if (today_dead == 0){
                        todayUpdate3.setText(getResources().getString(R.string.hyphen));
                    }else {
                        todayUpdate3.setText("+"+today_dead);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
        Log.d(TAG,"Out of try and catch");

    }

    private void getTnDetails() {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/data.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");
                    JSONArray array = response.getJSONArray("statewise");
                    JSONObject object = array.getJSONObject(2);
                    Log.d(TAG,"After array");

                    total = object.getInt("confirmed");
                    active = object.getInt("active");
                    recovered = object.getInt("recovered");

                    dead = object.getInt("deaths");
                    date = object.getString("lastupdatedtime");
                    Log.d(TAG,"After values fetch");
                    Log.d(TAG,String.valueOf(total));
                    Log.d(TAG,String.valueOf(active));
                    Log.d(TAG,String.valueOf(recovered));
                    Log.d(TAG,String.valueOf(dead));
                    Log.d(TAG,date);

                    double tot = total;
                    double rec  = recovered;
                    double recovery = (rec / tot) * 100;
                    mRecoveryRate.setText(new DecimalFormat("##.##").format(recovery) + "%");

                    double dea = dead;
                    double mortality = (dea / tot) * 100;
                    mMortalityRate.setText(new DecimalFormat("##.##").format(mortality) + "%");


                    Log.d(TAG,"Before total value");
                    mTotal.setText(String.valueOf(total));
                    Log.d(TAG,"After total value");
                    mActive.setText(String.valueOf(active));
                    mRecovered.setText(String.valueOf(recovered));
                    mDead.setText(String.valueOf(dead));
                    mUpdated.setText("Last updated " + date + " IST");
                    Log.d(TAG,"Ater values set");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
        Log.d(TAG,"Out of try and catch");
    }
}
