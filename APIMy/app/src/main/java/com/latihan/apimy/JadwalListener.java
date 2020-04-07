package com.latihan.apimy;

import com.latihan.apimy.model.EventsItem;

import java.util.List;

public interface JadwalListener {
    void onSuccess(List<EventsItem> items);
    void onFailed(String msg);
}
