package com.latihan.apimy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.latihan.apimy.model.EventsItem;
import com.latihan.apimy.service.SportService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JadwalListener {

    private RecyclerView rvitem;
    //TODO 1 : GOOGLING SPORTDB -> API TUTORIAL -> SCHEDULE -> 15 NEXT LEAGUE
    //TODO 2 : KLIK KANAN DI COM.BLABLA -> NEW -> PACKAGE -> NAMAIN MODEL
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvitem = findViewById(R.id.rv_item);
        new SportService().getJadwal(this);


    }

    @Override
    public void onSuccess(List<EventsItem> items) {
        rvitem.setLayoutManager(new LinearLayoutManager(this));
        EventAdapter eventAdapter = new EventAdapter(items);
        rvitem.setAdapter(eventAdapter);
        for (int i = 0; i<items.size(); i++){
            Log.d("ISI DATA", items.get(i).getStrEvent());
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("ISI EROR", msg);
    }
}
