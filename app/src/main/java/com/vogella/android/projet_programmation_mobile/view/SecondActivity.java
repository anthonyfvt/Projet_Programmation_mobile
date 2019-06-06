package com.vogella.android.projet_programmation_mobile.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vogella.android.projet_programmation_mobile.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String SelectedAvengers = "selected_avengers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showDescription();
    }

    public void showDescription() {

        // Get the text view where the description is displayed
        TextView publisher = findViewById(R.id.publisher);
        // Get the text view where the title is displayed
        TextView first_appearance = findViewById(R.id.first_appearance);
        TextView characters = findViewById(R.id.characters);
        TextView team = findViewById(R.id.team);
        TextView origin = findViewById(R.id.origin);



        ArrayList<String> avengers = getIntent().getStringArrayListExtra(SelectedAvengers);

        publisher.setText("Publisher : "+ avengers.get(0));
        first_appearance.setText("First Apperance : "+avengers.get(1));
        characters.setText("Characters : "+ avengers.get(2));
        team.setText("Team : "+avengers.get(3));
        origin.setText("Origin : " + avengers.get(4));

    }
}
