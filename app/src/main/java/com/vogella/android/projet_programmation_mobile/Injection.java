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
                    .baseUrl("https://gist.githubusercontent.com/anthonyfvt/1f3ce4e0d77dbe17bb263f00ad72d313/raw/31d6616d8ecbae0149f57c7438216e2aa91c6d90/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiAvengers = retrofit.create(RestApiAvengers.class);
        }
        return restApiAvengers;
    }
}
