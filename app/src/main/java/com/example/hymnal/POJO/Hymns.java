package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hymns {

    @SerializedName("_id")
    private String hymnId;

    @SerializedName("number")
    private int hymnNo;

    @SerializedName("title")
    private String hymnTitle;

    @SerializedName("category")
    private HymnCategory hymnCategory;

    public Hymns(String hymnId, int hymnNo, String hymnTitle, HymnCategory hymnCategory) {
        this.hymnId = hymnId;
        this.hymnNo = hymnNo;
        this.hymnTitle = hymnTitle;
        this.hymnCategory = hymnCategory;
    }

    public String getHymnId() {
        return hymnId;
    }

    public void setHymnId(String hymnId) {
        this.hymnId = hymnId;
    }

    public int getHymnNo() {
        return hymnNo;
    }

    public void setHymnNo(int hymnNo) {
        this.hymnNo = hymnNo;
    }

    public String getHymnTitle() {
        return hymnTitle;
    }

    public void setHymnTitle(String hymnTitle) {
        this.hymnTitle = hymnTitle;
    }

    public HymnCategory getHymnCategory() {
        return hymnCategory;
    }

    public void setHymnCategory(HymnCategory hymnCategory) {
        this.hymnCategory = hymnCategory;
    }
}
