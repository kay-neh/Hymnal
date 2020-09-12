package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HymnBody {

    @SerializedName("verses")
    private List<Verses> verses;

    @SerializedName("chorus")
    private Chorus chorus;

    public List<Verses> getVerses() {
        return verses;
    }

    public void setVerses(List<Verses> verses) {
        this.verses = verses;
    }

    public Chorus getChorus() {
        return chorus;
    }

    public void setChorus(Chorus chorus) {
        this.chorus = chorus;
    }
}
