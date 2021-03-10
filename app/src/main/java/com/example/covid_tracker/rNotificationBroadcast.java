package com.example.covid_tracker;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static android.content.Context.MODE_PRIVATE;

public class rNotificationBroadcast extends BroadcastReceiver {

    Context global;

    private static final String CHANNEL_ID = "Covid Tracker";
    int total = 10,active = 20,recovered = 30,dead = 40;

    PendingIntent pendingIntent;

    @Override
    public void onReceive(Context context, Intent intent) {

        global = context;

        //Toast.makeText(context, "Notified", Toast.LENGTH_SHORT).show();

        Intent rNB = new Intent(context,MainActivity.class);
        rNB.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        pendingIntent = PendingIntent.getActivity(context,14,rNB,PendingIntent.FLAG_UPDATE_CURRENT);

        getTnDetails();

        /*NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_heart)
                .setContentTitle("Total           " + "Active       " + "Recovered       " + "Dead")
                .setContentText(total + "      " + active + "      " + recovered + "      " + dead)
                .setColor(16711680)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(15,mBuilder.build());*/
    }

    private void getTnDetails() {

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

                    //Toast.makeText(global, "Total : "+total, Toast.LENGTH_SHORT).show();

                    /*SharedPreferences sharedPreferences = global.getSharedPreferences("location", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("total", total);
                    editor.putInt("active", active);
                    editor.putInt("recovered", recovered);
                    editor.putInt("dead", dead);
                    editor.apply();*/

                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(global,CHANNEL_ID)
                            .setContentIntent(pendingIntent)
                            .setSmallIcon(R.drawable.ic_heart)
                            .setContentTitle("Total              " + "Active         " + "Recovered       " + "Dead")
                            .setContentText(total + "       " + active + "        " + recovered + "           " + dead)
                            .setColor(16711680)
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(global);

                    notificationManagerCompat.notify(15,mBuilder.build());

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
    }

}
