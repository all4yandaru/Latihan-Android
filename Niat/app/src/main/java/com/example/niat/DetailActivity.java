package com.example.niat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_DARI = "extra_dari";
    public static final String EXTRA_SNIPERTEXT = "extra_SniperText";
    public static final String EXTRA_RUSHERTEXT = "extra_RusherText";
    public static final String EXTRA_OBSERVERTEXT = "extra_ObserverText";
    public static final String EXTRA_SUPPORTTEXT = "extra_SupportText";
    public static final String EXTRA_SNIPER_IMG = "extra_Sniper";

    TextView textView;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //back toolbar
        Toolbar toolbar = findViewById(R.id.acivity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PUBG MOBILE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //get intenet
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int sniper = getIntent().getIntExtra(EXTRA_SNIPER_IMG,0);
        int image = getIntent().getIntExtra(EXTRA_IMAGE, 0);
        String dari = getIntent().getStringExtra(EXTRA_DARI);
        String sniperText = getIntent().getStringExtra(EXTRA_SNIPERTEXT);
        String rusherText = getIntent().getStringExtra(EXTRA_RUSHERTEXT);
        String ObserverText= getIntent().getStringExtra(EXTRA_OBSERVERTEXT);
        String supportText= getIntent().getStringExtra(EXTRA_SUPPORTTEXT);


        imgView = findViewById(R.id.Sniper_img);
        imgView = findViewById(R.id.bigetron_logo);
        textView = findViewById(R.id.name);
        textView = findViewById(R.id.From);
        textView = findViewById(R.id.Sniper);
        textView = findViewById(R.id.Rusher);
        textView = findViewById(R.id.Support);
        textView =findViewById(R.id.observer);



        //get img

        Glide.with(getApplicationContext())
                .load(image)
                .into(imgView);

        Glide.with(getApplicationContext())
                .load(sniper)
                .into(imgView);

        //get TEXT
        Bundle extra_name = getIntent().getExtras();
        if (extra_name == null ) {
            return;
        }
        String value1 = extra_name.getString("value1");

        if (value1 == null ) {

            TextView displayIntentExtra = (TextView) findViewById(R.id.name);
            displayIntentExtra.setText(name);
            TextView fromIntentExtra = (TextView) findViewById(R.id.From);
            fromIntentExtra.setText(dari);
            TextView SniperIntentExtra = (TextView) findViewById(R.id.Sniper);
            SniperIntentExtra.setText(sniperText);
            TextView RusherIntentExtra =(TextView) findViewById(R.id.Rusher);
            RusherIntentExtra.setText(rusherText);
            TextView ObserverIntentExtra =(TextView) findViewById(R.id.observer);
            ObserverIntentExtra.setText(ObserverText);
            TextView SupportIntentExtra =(TextView) findViewById(R.id.Support);
            SupportIntentExtra.setText(supportText);
        }


    }
}
