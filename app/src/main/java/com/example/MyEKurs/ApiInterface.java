package com.example.MyEKurs;

import com.example.MyEKurs.Model.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Headlines> getHeadlines(
        @Query("country") String country,
        @Query("category") String category,
        @Query("apiKey") String apiKey
    );

}
