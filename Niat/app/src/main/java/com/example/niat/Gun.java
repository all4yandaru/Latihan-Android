package com.example.niat;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Gun {

    String Gun;
    String Style;
    Integer picture;
    String dari;
    String Sniper_name;
    String Rusher_name;
    String Observer_name;
    String Support_name;
    String info;
    Integer Support;
    Integer Sniper;
    Integer Rusher;
    Integer Ovserver;


    public Gun(String gun, String style, Integer picture, String dari, String sniper_name, String rusher_name, String observer_name, String support_name, String birthday, Integer support, Integer sniper, Integer rusher, Integer ovserver) {
        Gun = gun;
        Style = style;
        this.picture = picture;
        this.dari = dari;
        Sniper_name = sniper_name;
        Rusher_name = rusher_name;
        Observer_name = observer_name;
        Support_name = support_name;
        Support = support;
        Sniper = sniper;
        Rusher = rusher;
        Ovserver = ovserver;

    }

    public Gun(String info) {
        this.info = info;
    }

    public Gun() {
    }

    public String getGun() {
        return Gun;
    }

    public void setGun(String gun) {
        Gun = gun;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public String getSniper_name() {
        return Sniper_name;
    }

    public void setSniper_name(String sniper_name) {
        Sniper_name = sniper_name;
    }

    public String getRusher_name() {
        return Rusher_name;
    }

    public void setRusher_name(String rusher_name) {
        Rusher_name = rusher_name;
    }

    public String getObserver_name() {
        return Observer_name;
    }

    public void setObserver_name(String observer_name) {
        Observer_name = observer_name;
    }

    public String getSupport_name() {
        return Support_name;
    }

    public void setSupport_name(String support_name) {
        Support_name = support_name;
    }

    public Integer getSupport() {
        return Support;
    }

    public void setSupport(Integer support) {
        Support = support;
    }

    public Integer getSniper() {
        return Sniper;
    }

    public void setSniper(Integer sniper) {
        Sniper = sniper;
    }

    public Integer getRusher() {
        return Rusher;
    }

    public void setRusher(Integer rusher) {
        Rusher = rusher;
    }

    public Integer getOvserver() {
        return Ovserver;
    }

    public void setOvserver(Integer ovserver) {
        Ovserver = ovserver;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    void intent(Context context, Object x){
        context.startActivity(new Intent(context,(Class) x));
    }
}
