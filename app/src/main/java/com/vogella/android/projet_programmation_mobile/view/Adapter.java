package com.vogella.android.projet_programmation_mobile.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vogella.android.projet_programmation_mobile.R;
import com.vogella.android.projet_programmation_mobile.model.Avengers;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Avengers> values;
    private MainActivity mainActivity;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, Avengers item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    private static final String SelectedAvengers = "selected_avengers";
    public void infoDisplay(int position){
        Log.d("position", String.valueOf(position));
        // Create an Intent to start the second activity
        Intent infoIntent = new Intent(mainActivity, SecondActivity.class);
        final Avengers selectedAvengers = values.get(position);
        ArrayList<String> avengers = new ArrayList<>() ;
        avengers.add(selectedAvengers.getPublisher());
        avengers.add(selectedAvengers.getFirst_appearance());
        avengers.add(selectedAvengers.getCharacters());
        avengers.add(selectedAvengers.getTeam());
        avengers.add(selectedAvengers.getOrigin());
        infoIntent.putStringArrayListExtra(SelectedAvengers,avengers);
// Start the new activity.
        mainActivity.startActivity(infoIntent);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(List<Avengers> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.raw_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        this.position = position;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Avengers selectedAvengers = values.get(position);
        holder.txtHeader.setText(selectedAvengers.getSuperhero());
        holder.txtFooter.setText("Click to get some details.");
        holder.layout.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                infoDisplay(position);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return values.size();
    }


}
