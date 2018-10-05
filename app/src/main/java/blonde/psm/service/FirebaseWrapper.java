package blonde.psm.service;

import org.json.JSONObject;

import java.util.ArrayList;

public class FirebaseWrapper {

    private ArrayList<String> titles;

    public FirebaseWrapper() {
        titles = new ArrayList<>();
        titles.add("WWE 2K19");
        titles.add("The Midnight Sanctuary");
        titles.add("Party Crashers");
        titles.add("ACA NeoGeo: Zupapa!");
        titles.add("Overcooked! 2: Surf 'n' Turf");
        titles.add("Mega Man 11");
        titles.add("Astro Bot: Rescue Mission");
        titles.add("Assassin's Creed Odyssey");
        titles.add("Fist of the North Star: Lost Paradise");
        titles.add("Valthirian Arc: Hero School Story");
        titles.add("The Surge: The Good, the Bad, and the Augmented");
        titles.add("Racket Fury: Table Tennis VR");
        titles.add("The Sims 4: Spooky Stuff");
        titles.add("Pilot Sports");
        titles.add("Catastronauts");
        titles.add("Life is Strange 2");
        titles.add("Dragon Ball FighterZ: Cooler");
        titles.add("Life is Strange 2: Episode 1 - Roads");
        titles.add("Dragon Ball FighterZ: Android 17");
        titles.add("Perception: Remastered");
    }

    public ArrayList<String> getTitles() {
        return this.titles;
    }
}
