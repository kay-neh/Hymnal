package com.example.hymnal.Network;

import com.example.hymnal.POJO.Category;
import com.example.hymnal.POJO.HymnBody;
import com.example.hymnal.POJO.Hymns;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    //Get all hymns
    @GET("/hymns")
    Call<List<Hymns>> getAllHymns();

    //Get hymn by id
    @GET("/hymns/{hymnId}")
    Call<HymnBody> getHymnsById(@Path("hymnId") String hymnId);

    //Get hymns by category
    @GET("/category/{categoryId}")
    Call<Category> getHymnsByCategory(@Path("categoryId") String categoryId);
}
