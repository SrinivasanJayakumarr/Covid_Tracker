package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Direction;
import com.fujiyuu75.sequent.Sequent;

import org.json.JSONException;
import org.json.JSONObject;

public class Explore_card extends AppCompatActivity {

    private static final String TAG = "Explore_card_Activity";
    private TextView mTotal;
    private TextView mActive;
    private TextView mRecovered;
    private TextView mApTotal;
    private TextView mApActive;
    private TextView mApRecovered;
    private TextView mTested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_card);

        Intent intent = getIntent();
        String iUpdated = intent.getStringExtra("Updated");

        //SharedPreferences


        Window window = Explore_card.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Explore_card.this, R.color.orange));

        TextView mUpdated = findViewById(R.id.explore_updated);

        mUpdated.setText("Last updated "  + iUpdated + " IST");

        mTotal = findViewById(R.id.r_total);
        mActive = findViewById(R.id.r_active);
        mRecovered = findViewById(R.id.r_recovered);

        mApTotal = findViewById(R.id.ap_total);
        mApActive = findViewById(R.id.ap_active);
        mApRecovered = findViewById(R.id.ap_recovered);

        mTested = findViewById(R.id.tested_cases);

        CardView anim1 = findViewById(R.id.card_ap);
        CardView anim2 = findViewById(R.id.cad_s1);
        CardView anim3 = findViewById(R.id.card_rail);
        CardView anim4 = findViewById(R.id.card_mostaffec);
        CardView anim5 = findViewById(R.id.card_s2);
        CardView anim6 = findViewById(R.id.card_credits);

        Sequent.origin(anim1).flow(Direction.FORWARD).duration(700).delay(100).anim(this, Animation.FADE_IN_UP).start();
        Sequent.origin(anim2).flow(Direction.BACKWARD).duration(800).delay(500).anim(this,Animation.FADE_IN_LEFT).start();
        Sequent.origin(anim3).flow(Direction.FORWARD).duration(800).delay(750).anim(this,Animation.FADE_IN_DOWN).start();
        Sequent.origin(anim4).flow(Direction.FORWARD).duration(800).delay(750).anim(this,Animation.FADE_IN_RIGHT).start();
        Sequent.origin(anim5).flow(Direction.FORWARD).duration(800).delay(700).anim(this,Animation.FADE_IN_DOWN).start();
        Sequent.origin(anim6).flow(Direction.FORWARD).duration(800).delay(800).anim(this,Animation.FADE_IN_LEFT).start();

        getDetails();
        getTested();

        anim4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(Explore_card.this,Search.class);
                startActivity(searchIntent);
            }
        });


    }

    private void getTested() {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("total");

                    int tested = dd.getInt("tested");

                    mTested.setText(String.valueOf(tested));

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
    }

    private void getDetails() {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/state_district_wise.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                     JSONObject dd = Key.getJSONObject("districtData");
                     JSONObject rq = dd.getJSONObject("Railway Quarantine");
                     JSONObject apq = dd.getJSONObject("Airport Quarantine");
                    //Log.d(TAG,String.valueOf(Key));
                    //Log.d(TAG,String.valueOf(dd));
                    //Log.d(TAG,String.valueOf(rq));

                    int total = rq.getInt("confirmed");
                    int active = rq.getInt("active");
                    int recovered = rq.getInt("recovered");

                    int aptotal = apq.getInt("confirmed");
                    int apactive = apq.getInt("active");
                    int aprecovered = apq.getInt("recovered");
                    Log.d(TAG,String.valueOf(total));
                    Log.d(TAG,String.valueOf(active));
                    Log.d(TAG,String.valueOf(recovered));

                    mTotal.setText(String.valueOf(total));
                    mActive.setText(String.valueOf(active));
                    mRecovered.setText(String.valueOf(recovered));

                    mApTotal.setText(String.valueOf(aptotal));
                    mApActive.setText(String.valueOf(apactive));
                    mApRecovered.setText(String.valueOf(aprecovered));

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
    }
}