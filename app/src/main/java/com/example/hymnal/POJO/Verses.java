package com.example.hymnal.POJO;

import com.google.gson.annotations.SerializedName;

public class Verses {

    @SerializedName("_id")
    private String hymnVerseId;

    @SerializedName("verse")
    private String hymnVerse;

    public Verses(String hymnVerseId, String hymnVerse) {
        this.hymnVerseId = hymnVerseId;
        this.hymnVerse = hymnVerse;
    }

    public String getHymnVerseId() {
        return hymnVerseId;
    }

    public void setHymnVerseId(String hymnVerseId) {
        this.hymnVerseId = hymnVerseId;
    }

    public String getHymnVerse() {
        return hymnVerse;
    }

    public void setHymnVerse(String hymnVerse) {
        this.hymnVerse = hymnVerse;
    }
}
