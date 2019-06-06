package com.vogella.android.projet_programmation_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Avengers {

    @SerializedName("superhero")
    private String superhero;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("alter_ego")
    private String alter_ego;
    @SerializedName("first_appearance")
    private String first_appearance;
    @SerializedName("characters")
    private String characters;
    @SerializedName("team")
    private String team;
    @SerializedName("origin")
    private String origin;


    public String getSuperhero() {
        return superhero;
    }
    public String getAlter_ego() {
        return alter_ego;
    }
    public String getPublisher() {
        return publisher;
    }


    public String getFirst_appearance() {
        return first_appearance;
    }

    public String getCharacters() {
        return characters;
    }


    public String getTeam() {
        return team;
    }

    public String getOrigin() {
        return origin;
    }


}
