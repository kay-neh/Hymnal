package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

public class Chorus {

    @SerializedName("_id")
    private String hymnChorusId;

    @SerializedName("chorus")
    private String hymnChorus;

    public Chorus(String hymnChorusId, String hymnChorus) {
        this.hymnChorusId = hymnChorusId;
        this.hymnChorus = hymnChorus;
    }

    public String getHymnChorusId() {
        return hymnChorusId;
    }

    public void setHymnChorusId(String hymnChorusId) {
        this.hymnChorusId = hymnChorusId;
    }

    public String getHymnChorus() {
        return hymnChorus;
    }

    public void setHymnChorus(String hymnChorus) {
        this.hymnChorus = hymnChorus;
    }
}
