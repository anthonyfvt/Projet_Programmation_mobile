package com.vogella.android.projet_programmation_mobile;

import com.vogella.android.projet_programmation_mobile.model.Avengers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiAvengers {
    @GET("superheroes.json")
    Call<List<Avengers>> getAvengersData();
}
