package com.huntdreams.huntmeizi.model;

import org.litepal.crud.DataSupport;

/**
 * Created by noprom on 15/6/25.
 */
public class Meizhi extends DataSupport {

    private String mid;
    private String url;


    public Meizhi(String id, String url) {
        this.mid = id;
        this.url = url;
    }

    public Meizhi() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String id) {
        this.mid = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Meizhi{" +
                "id='" + mid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
