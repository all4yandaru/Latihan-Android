package com.latihan.apimy.service;

import com.latihan.apimy.JadwalListener;
import com.latihan.apimy.model.EventsItem;
import com.latihan.apimy.model.JadwalResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportService {

    private Retrofit retrofit = null;

    public SportAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(SportAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SportAPI.class);
    }

    public void getJadwal(final JadwalListener listener){

        getAPI().getJadwal().enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                JadwalResponse data = response.body();

                if (data != null && data.getEvents() !=null){
                    listener.onSuccess(data.getEvents());
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
