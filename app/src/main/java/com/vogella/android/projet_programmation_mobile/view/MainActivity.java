package com.vogella.android.projet_programmation_mobile.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vogella.android.projet_programmation_mobile.Injection;
import com.vogella.android.projet_programmation_mobile.R;
import com.vogella.android.projet_programmation_mobile.controller.Controller;
import com.vogella.android.projet_programmation_mobile.model.Avengers;

import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        controller = new Controller(this, Injection.getRestApi());
        controller.onCreate();
    }
    public void showList(List<Avengers> avengersList) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        //Instanciation de layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        //Instanciation de mAdapter
        mAdapter = new Adapter(avengersList,this);
        recyclerView.setAdapter(mAdapter);
    }



}
