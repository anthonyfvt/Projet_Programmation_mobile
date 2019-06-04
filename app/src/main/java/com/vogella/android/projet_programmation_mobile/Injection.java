package com.vogella.android.projet_programmation_mobile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    private static RestApiAvengers restApiAvengers;

    //Singleton
    public static RestApiAvengers getRestApi(){
        if(restApiAvengers == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://gist.githubusercontent.com/mariodev12/a923f2b651a005ca3ca7f851141efcbc/raw/12fbcb788eac52f08720d4bf5bf5b249ffa18420/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiAvengers = retrofit.create(RestApiAvengers.class);
        }
        return restApiAvengers;
    }
}
