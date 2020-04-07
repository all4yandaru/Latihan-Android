package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    public static final String extraJudul = "JUDUL";
    public static final String extraTanggalRilis = "Tanggal Rilis";
    public static final String extraSutradara = "Sutradara";
    public static final String extraDesc = "Desc";
    public static final String extraImage = "Gambar";

    TextView tvJudul, tvDesc, tvTglRilis, tvSutradara;
    ImageView imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String judul = getIntent().getStringExtra(extraJudul);
        String tanggalRilis = getIntent().getStringExtra(extraTanggalRilis);
        String sutradara = getIntent().getStringExtra(extraSutradara);
        String desc = getIntent().getStringExtra(extraDesc);
        int photo = getIntent().getIntExtra(extraImage,0);

        tvJudul = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_deskripsi);
        tvTglRilis = findViewById(R.id.tv_tanggal);
        tvSutradara = findViewById(R.id.tv_sutradara);
        imgCover = findViewById(R.id.img_gambar);


        Glide.with(getApplicationContext()).load(photo).into(imgCover);

        tvJudul.setText(judul);
        tvDesc.setText(desc);
        tvTglRilis.setText(tanggalRilis);
        tvSutradara.setText(sutradara);

    }
}
