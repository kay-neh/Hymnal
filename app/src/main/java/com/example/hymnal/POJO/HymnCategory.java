package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

public class HymnCategory {

    @SerializedName("_id")
    private String hymnCategoryId;

    @SerializedName("name")
    private String hymnCategoryName;

    public HymnCategory(String hymnCategoryId, String hymnCategoryName) {
        this.hymnCategoryId = hymnCategoryId;
        this.hymnCategoryName = hymnCategoryName;
    }

    public String getHymnCategoryId() {
        return hymnCategoryId;
    }

    public void setHymnCategoryId(String hymnCategoryId) {
        this.hymnCategoryId = hymnCategoryId;
    }

    public String getHymnCategoryName() {
        return hymnCategoryName;
    }

    public void setHymnCategoryName(String hymnCategoryName) {
        this.hymnCategoryName = hymnCategoryName;
    }
}
