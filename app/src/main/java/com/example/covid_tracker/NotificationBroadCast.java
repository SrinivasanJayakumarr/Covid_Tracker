package com.example.covid_tracker;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import static android.content.Context.MODE_PRIVATE;

public class NotificationBroadCast extends BroadcastReceiver {

    Context global;

    private static final String CHANNEL_ID = "Covid Tracker";
    int total = 0,active = 0,recovered = 0,dead = 0;
    @Override
    public void onReceive(Context context, Intent intent) {

        //Toast.makeText(context, "Will Notify", Toast.LENGTH_SHORT).show();

        global = context;

        if (total == 0 && active == 0 && recovered == 0 && dead == 0){

            //getTnDetails();

        }else {
            SharedPreferences sh = global.getSharedPreferences("location", MODE_PRIVATE);
            total = sh.getInt("total", 0);
            active = sh.getInt("active", 0); //Problem here
            recovered = sh.getInt("recovered", 0);
            dead = sh.getInt("dead", 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_heart)
                    .setContentTitle("Total           " + "Active       " + "Recovered       " + "Death")
                    .setContentText(total + "      " + active + "      " + recovered + "      " + dead)
                    .setColor(16711680)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

            notificationManagerCompat.notify(12,mBuilder.build());

        }

    }


    /*private void getTnDetails() {

        String url = "https://api.covid19india.org/data.json";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("statewise");
                    JSONObject object = array.getJSONObject(2);

                    total = object.getInt("confirmed");
                    active = object.getInt("active");
                    recovered = object.getInt("recovered");
                    dead = object.getInt("deaths");

                    SharedPreferences sharedPreferences = global.getSharedPreferences("location", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("total", total);
                    editor.putInt("active", active);
                    editor.putInt("recovered", recovered);
                    editor.putInt("dead", dead);
                    editor.apply();

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
        RequestQueue queue = Volley.newRequestQueue(global);
        queue.add(jor);
    }*/

}
