package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Search_Result extends AppCompatActivity {

    TextView city,cityPop,cityTot,cityAct,cityReco,cityDead,cityTested,city_Today_tot,city_Today_reco,city_Today_dead;
    CardView cityC,stateC,countryC,testedC,totalC,activeC,recovoC,deadC;
    //int pop,tot,act,reco,dead;
    private static final String TAG = "Search_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__result);

        Window window = Search_Result.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Search_Result.this, R.color.cyan));

        city = findViewById(R.id.city_name);
        cityPop = findViewById(R.id.city_pop_count);
        cityTot = findViewById(R.id.city_total_count);
        cityAct = findViewById(R.id.city_active_count);
        cityReco = findViewById(R.id.city_recovo_count);
        cityDead = findViewById(R.id.city_dead_count);
        cityTested = findViewById(R.id.city_tested_count);
        city_Today_tot = findViewById(R.id.city_today_confirmed);
        city_Today_reco = findViewById(R.id.city_today_recovered);
        city_Today_dead = findViewById(R.id.city_today_dead);

        cityC = findViewById(R.id.card_city_name);
        stateC = findViewById(R.id.card_squ1);
        countryC = findViewById(R.id.card_squ2);
        testedC = findViewById(R.id.card_tested);
        totalC = findViewById(R.id.card_total);
        activeC = findViewById(R.id.card_active);
        recovoC = findViewById(R.id.card_recovo);
        deadC = findViewById(R.id.card_dead);

        Sequent.origin(cityC).flow(Direction.BACKWARD).duration(800).delay(200).anim(this, Animation.FADE_IN_DOWN).start();
        Sequent.origin(stateC).flow(Direction.BACKWARD).duration(800).delay(400).anim(this, Animation.FADE_IN_LEFT).start();
        Sequent.origin(countryC).flow(Direction.BACKWARD).duration(800).delay(400).anim(this, Animation.FADE_IN_LEFT).start();
        Sequent.origin(testedC).flow(Direction.BACKWARD).duration(800).delay(400).anim(this, Animation.FADE_IN_LEFT).start();
        Sequent.origin(totalC).flow(Direction.BACKWARD).duration(800).delay(500).anim(this, Animation.FADE_IN_DOWN).start();
        Sequent.origin(activeC).flow(Direction.BACKWARD).duration(800).delay(600).anim(this, Animation.FADE_IN_DOWN).start();
        Sequent.origin(recovoC).flow(Direction.BACKWARD).duration(800).delay(700).anim(this, Animation.FADE_IN_DOWN).start();
        Sequent.origin(deadC).flow(Direction.BACKWARD).duration(800).delay(800).anim(this, Animation.FADE_IN_DOWN).start();

        Intent intent = getIntent();
        int chosen = intent.getIntExtra("Option",0);
        Log.d(TAG,String.valueOf(chosen));

        String[] cityname = getResources().getStringArray(R.array.cities);
        Log.d(TAG,cityname[0]);

        switch (chosen){
            case 1:
                city.setText(cityname[0].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsAri();
                break;
            case 2:
                city.setText(cityname[1].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsChengal();
                break;
            case 3:
                city.setText(cityname[2].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsChennai();
                break;
            case 4:
                city.setText(cityname[3].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsCoimba();
                break;
            case 5:
                city.setText(cityname[4].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsCudda();
                break;
            case 6:
                city.setText(cityname[5].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsDhar();
                break;
            case 7:
                city.setText(cityname[6].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsDindi();
                break;
            case 8:
                city.setText(cityname[7].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsErod();
                break;
            case 9:
                city.setText(cityname[8].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsKallakuri();
                break;
            case 10:
                city.setText(cityname[9].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsKanchee();
                break;
            case 11:
                city.setText(cityname[10].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsKanya();
                break;
            case 12:
                city.setText(cityname[11].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsKarur();
                break;
            case 13:
                city.setText(cityname[12].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsKrish();
                break;
            case 14:
                city.setText(cityname[13].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsMadurai();
                break;
            case 15:
                city.setText(cityname[14].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsNagapa();
                break;
            case 16:
                city.setText(cityname[15].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsNamak();
                break;
            case 17:
                city.setText(cityname[16].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsNilgi();
                break;
            case 18:
                city.setText(cityname[17].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsPeramba();
                break;
            case 19:
                city.setText(cityname[18].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsPuduk();
                break;
            case 20:
                city.setText(R.string.ramnadu);
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsRamanatha();
                break;
            case 21:
                city.setText(cityname[20].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsRanipet();
                break;
            case 22:
                city.setText(cityname[21].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsSalem();
                break;
            case 23:
                city.setText(cityname[22].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsSivagan();
                break;
            case 24:
                city.setText(cityname[23].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTenkasi();
                break;
            case 25:
                city.setText(cityname[24].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsThanja();
                break;
            case 26:
                city.setText(cityname[25].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTheni();
                break;
            case 27:
                city.setText(cityname[26].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsThiruval();
                break;
            case 28:
                city.setText(cityname[27].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsThiruvar();
                break;
            case 29:
                city.setText(cityname[28].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsThoothu();
                break;
            case 30:
                city.setText(R.string.trichy);
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTrichy();
                break;
            case 31:
                city.setText(cityname[30].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTirunel();
                break;
            case 32:
                city.setText(cityname[31].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTirupathur();
                break;
            case 33:
                city.setText(cityname[32].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTiruppur();
                break;
            case 34:
                city.setText(cityname[33].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsTiruvanna();
                break;
            case 35:
                city.setText(cityname[34].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsVellore();
                break;
            case 36:
                city.setText(cityname[35].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsVilupu();
                break;
            case 37:
                city.setText(cityname[36].toUpperCase());
                Log.d(TAG,"Value inside switch1"+chosen);
                getDetailsVirudhu();
                break;
        }
    }

    private void getDetailsAri () {

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Ariyalur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");
                    Log.d(TAG,"Inside today call");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Ariyalur");
                    Log.d(TAG,String.valueOf(cd));
                    JSONObject delta = cd.getJSONObject("delta");
                    Log.d(TAG,String.valueOf(delta));

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));

                    int mtoday_tot = delta.getInt("confirmed");
                    Log.d(TAG,"Confirmed");
                    Log.d(TAG,String.valueOf(mtoday_tot));
                    int mtoday_reco = delta.getInt("recovered");
                    Log.d(TAG,"Recovored");
                    Log.d(TAG,String.valueOf(mtoday_reco));
                    int mtoday_dead = delta.getInt("deceased");
                    Log.d(TAG,"Deaceased");
                    Log.d(TAG,String.valueOf(mtoday_dead));

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsChengal () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Chengalpattu");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Chengalpattu");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsChennai () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Chennai");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Chennai");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsCoimba () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Coimbatore");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Coimbatore");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsCudda () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Cuddalore");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Cuddalore");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsDhar () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Dharmapuri");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Dharmapuri");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsDindi () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Dindigul");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Dindigul");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsErod () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Erode");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Erode");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsKallakuri () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Kallakurichi");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Kallakurichi");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsKanchee () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Kancheepuram");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Kancheepuram");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsKanya () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Kanyakumari");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Kanyakumari");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsKarur () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Karur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Karur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsKrish () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Krishnagiri");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Krishnagiri");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsMadurai () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Madurai");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Madurai");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsNagapa () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Nagapattinam");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Nagapattinam");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsNamak () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Namakkal");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Namakkal");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsNilgi () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Nilgiris");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Nilgiris");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsPeramba () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Perambalur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Perambalur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsPuduk () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Pudukkottai");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Pudukkottai");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsRamanatha () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Ramanathapuram");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Ramanathapuram");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsRanipet () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Ranipet");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Ranipet");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsSalem () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Salem");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Salem");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsSivagan () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Sivaganga");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Sivaganga");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTenkasi () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tenkasi");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tenkasi");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsThanja () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Thanjavur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Thanjavur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTheni () {

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Theni");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Theni");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsThiruval () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Thiruvallur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Thiruvallur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsThiruvar () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Thiruvarur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Thiruvarur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsThoothu () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Thoothukkudi");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Thoothukkudi");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTrichy () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tiruchirappalli");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tiruchirappalli");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTirunel () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tirunelveli");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tirunelveli");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTirupathur () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tirupathur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tirupathur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTiruppur () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tiruppur");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tiruppur");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsTiruvanna () {

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Tiruvannamalai");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Tiruvannamalai");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsVellore () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Vellore");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Vellore");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsVilupu () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Viluppuram");
                    Log.d(TAG,String.valueOf(cd));
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Viluppuram");
                    Log.d(TAG,String.valueOf(cd));
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }

    private void getDetailsVirudhu () {

        Log.d(TAG,"inside update details");

        String url = "https://api.covid19india.org/v3/data.json";
        String url1 = "https://api.covid19india.org/state_district_wise.json";
        //String url2 = "https://api.covid19india.org/districts_daily.json";

        Log.d(TAG,"Before JSON request");

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                //Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("TN");
                    JSONObject dd = Key.getJSONObject("districts");
                    JSONObject cd = dd.getJSONObject("Virudhunagar");
                    JSONObject details = cd.getJSONObject("total");
                    JSONObject meta = cd.getJSONObject("meta");

                    int tot = details.getInt("confirmed");
                    int pop = meta.getInt("population");
                    int reco = details.getInt("recovered");
                    int dead = details.getInt("deceased");
                    int tested = details.getInt("tested");

                    cityTot.setText(String.valueOf(tot));
                    cityPop.setText(String.valueOf(pop));
                    //cityAct.setText(String.valueOf(act));
                    cityReco.setText(String.valueOf(reco));
                    cityDead.setText(String.valueOf(dead));
                    cityTested.setText(String.valueOf(tested));

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
        //return tot;
        Log.d(TAG,"Another Json call");

        JsonObjectRequest jor1 = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"Before response value");
                Log.d(TAG,String.valueOf(response));

                try {
                    Log.d(TAG,"Inside try");

                    JSONObject Key = response.getJSONObject("Tamil Nadu");
                    Log.d(TAG,String.valueOf(Key));
                    JSONObject dd = Key.getJSONObject("districtData");
                    Log.d(TAG,String.valueOf(dd));
                    JSONObject cd = dd.getJSONObject("Virudhunagar");
                    JSONObject delta = cd.getJSONObject("delta");

                    int mtoday_tot = delta.getInt("confirmed");
                    int mtoday_reco = delta.getInt("recovered");
                    int mtoday_dead = delta.getInt("deceased");

                    if (mtoday_tot == 0){
                        city_Today_tot.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_tot.setText(String.valueOf(mtoday_tot));
                    }
                    if (mtoday_reco == 0){
                        city_Today_reco.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_reco.setText(String.valueOf(mtoday_reco));
                    }
                    if (mtoday_dead == 0){
                        city_Today_dead.setText(getResources().getString(R.string.hyphen));
                    }else {
                        city_Today_dead.setText(String.valueOf(mtoday_dead));
                    }

                    int act = cd.getInt("active");
                    Log.d(TAG,String.valueOf(act));

                    cityAct.setText(String.valueOf(act));
                    Log.d(TAG,String.valueOf(act));

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
        RequestQueue queue1 = Volley.newRequestQueue(this);
        queue1.add(jor1);
    }
}