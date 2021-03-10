package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Search extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_search);

        Window window = Search.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Search.this, R.color.bg_blue_color));

        lv = (ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),
                        adapter.getItem(position),Toast.LENGTH_SHORT).show();

                String selected_city = adapter.getItem(position);

                Intent i = new Intent(Search.this,Search_Result.class);

                assert selected_city != null;
                switch (selected_city){
                    case "Ariyalur":
                        int val = 1;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Chengalpattu":
                        val = 2;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Chennai":
                        val = 3;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Coimbatore":
                        val = 4;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Cuddalore":
                        val = 5;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Dharmapuri":
                        val = 6;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Dindigul":
                        val = 7;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Erode":
                        val = 8;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Kallakurichi":
                        val = 9;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Kancheepuram":
                        val = 10;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Kanyakumari":
                        val = 11;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Karur":
                        val = 12;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Krishnagiri":
                        val = 13;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Madurai":
                        val = 14;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Nagapattinam":
                        val = 15;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Namakkal":
                        val = 16;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Nilgiris":
                        val = 17;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Perambalur":
                        val = 18;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Pudukottai":
                        val = 19;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Ramanathapuram":
                        val = 20;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Ranipet":
                        val = 21;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Salem":
                        val = 22;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Sivaganga":
                        val = 23;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tenkasi":
                        val = 24;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Thanjavur":
                        val = 25;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Theni":
                        val = 26;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Thiruvallur":
                        val = 27;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Thiruvarur":
                        val = 28;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Thoothukkudi":
                        val = 29;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tiruchirappalli":
                        val = 30;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tirunelveli":
                        val = 31;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tirupathur":
                        val = 32;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tiruppur":
                        val = 33;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Tiruvannamalai":
                        val = 34;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Vellore":
                        val = 35;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Vilupuram":
                        val = 36;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    case "Virudhunagar":
                        val = 37;
                        i.putExtra("Option",val);
                        startActivity(i);
                        break;
                    default: Toast.makeText(Search.this,"Make correct selection",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<String> cityNames = new ArrayList<>();
        cityNames.addAll(Arrays.asList(getResources().getStringArray(R.array.cities)));

        adapter = new ArrayAdapter<>(
                Search.this,
                android.R.layout.simple_list_item_1,
                cityNames
        );
        lv.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.sv);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }
}