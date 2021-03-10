package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Dos_and_donts_card extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_and_donts_card);

        Window window = Dos_and_donts_card.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Dos_and_donts_card.this, R.color.green_color));

        ImageView img1 = (ImageView) findViewById(R.id.hand_wash);
        ImageView img2 = (ImageView) findViewById(R.id.mask);
        ImageView img3 = (ImageView) findViewById(R.id.doctor);
        ImageView img4 = (ImageView) findViewById(R.id.home);

        TextView txt1 = (TextView) findViewById(R.id.hand_wash_title);
        TextView txt2 = (TextView) findViewById(R.id.hand_wash_cont);

        TextView txt3 = (TextView) findViewById(R.id.txtv1);
        TextView txt4 = (TextView) findViewById(R.id.mask_cont);

        TextView txt5 = (TextView) findViewById(R.id.doctor_title);
        TextView txt6 = (TextView) findViewById(R.id.txtv2);

        TextView txt7 = (TextView) findViewById(R.id.home_title);
        TextView txt8 = (TextView) findViewById(R.id.home_cont);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.RL0);

        CardView cardView1 = (CardView) findViewById(R.id.card0);
        CardView cardView2 = (CardView) findViewById(R.id.card1);
        CardView cardView3 = (CardView) findViewById(R.id.card2);
        CardView cardView4 = (CardView) findViewById(R.id.card3);

        Intent intent = getIntent();
        int choice = intent.getIntExtra("Value",0);

        if (choice == 1){

            layout.setBackgroundColor(getColor(R.color.red_color));

            cardView1.setCardBackgroundColor(getColor(R.color.red_color));
            cardView2.setCardBackgroundColor(getColor(R.color.red_color));
            cardView3.setCardBackgroundColor(getColor(R.color.red_color));
            cardView4.setCardBackgroundColor(getColor(R.color.red_color));

            window = Dos_and_donts_card.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(Dos_and_donts_card.this, R.color.red_color));

            img1.setImageResource(R.drawable.ic_hand_shake);
            txt1.setText(R.string.close_contact);
            txt2.setText(R.string.close_contact_cont);

            img2.setImageResource(R.drawable.ic_hand_shake);
            txt3.setText(R.string.dont_spit);
            txt4.setText(R.string.dont_spit_cont);

            img3.setImageResource(R.drawable.ic_transport);
            txt5.setText(R.string.avoid_public_transport);
            txt6.setText(R.string.apt_cont);

            /*LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params1.setMargins(0,20,0,0);
            txt7.setLayoutParams(params1);*/

            img4.setImageResource(R.drawable.ic_medicine);
            txt7.setText(R.string.counter_medicines);
            txt8.setText(R.string.counter_medicines_cont);

            /*LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,10,0);
            txt7.setLayoutParams(params);*/
        }
    }
}