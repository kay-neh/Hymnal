package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

    @SerializedName("hymns")
    private List<Hymns> hymns;

    public List<Hymns> getHymns() {
        return hymns;
    }

    public void setHymns(List<Hymns> hymns) {
        this.hymns = hymns;
    }
}
