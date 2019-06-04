package com.vogella.android.projet_programmation_mobile.controller;

import com.vogella.android.projet_programmation_mobile.RestApiAvengers;
import com.vogella.android.projet_programmation_mobile.model.Avengers;
import com.vogella.android.projet_programmation_mobile.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller {

    public MainActivity view;
    private RestApiAvengers restApiAvengers;

    public Controller(MainActivity view, RestApiAvengers restApiAvengers) {
        this.view = view;
        this.restApiAvengers = restApiAvengers;
    }

    public void onCreate() {
        Call<List<Avengers>> call = restApiAvengers.getAvengersData();
        call.enqueue(new Callback<List<Avengers>>() {
            @Override
            public void onResponse(Call<List<Avengers>> call, Response<List<Avengers>> response) {
                List<Avengers> restAvengersResponse = response.body();
                List<Avengers> avengersList = restAvengersResponse;
                view.showList(avengersList);
            }

            @Override
            public void onFailure(Call<List<Avengers>> call, Throwable t) {

            }
        });
    }
}
