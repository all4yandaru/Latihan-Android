package com.latihan.apimy.service;

import com.latihan.apimy.model.JadwalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportAPI {
    static final String URL_BASE = "https://www.thesportsdb.com/";

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<JadwalResponse> getJadwal();
}