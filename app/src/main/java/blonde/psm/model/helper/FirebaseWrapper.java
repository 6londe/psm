package blonde.psm.model.helper;

import org.json.JSONObject;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.view.activity.search.SearchRow;

public class FirebaseWrapper {

    private ArrayList<SearchRow> titles;

    public FirebaseWrapper() {

        titles = new ArrayList<>();
        titles.add(new SearchRow(1, "WWE 2K19"));
        titles.add(new SearchRow(1, "The Midnight Sanctuary"));
        titles.add(new SearchRow(1, "Party Crashers"));
        titles.add(new SearchRow(1, "ACA NeoGeo: Zupapa!"));
        titles.add(new SearchRow(1, "Overcooked! 2: Surf 'n' Turf"));
        titles.add(new SearchRow(1, "Mega Man 11"));
        titles.add(new SearchRow(1, "Astro Bot: Rescue Mission"));
        titles.add(new SearchRow(1, "Assassin's Creed Odyssey"));
        titles.add(new SearchRow(1, "Fist of the North Star: Lost Paradise"));
        titles.add(new SearchRow(1, "Valthirian Arc: Hero School Story"));
        titles.add(new SearchRow(1, "The Surge: The Good, the Bad, and the Augmented"));
        titles.add(new SearchRow(1, "Racket Fury: Table Tennis VR"));
        titles.add(new SearchRow(1, "The Sims 4: Spooky Stuff"));
        titles.add(new SearchRow(1, "Pilot Sports"));
        titles.add(new SearchRow(1, "Catastronauts"));
        titles.add(new SearchRow(1, "Life is Strange 2"));
        titles.add(new SearchRow(1, "Dragon Ball FighterZ: Cooler"));
        titles.add(new SearchRow(1, "Life is Strange 2: Episode 1 - Roads"));
        titles.add(new SearchRow(1, "Dragon Ball FighterZ: Android 17"));
        titles.add(new SearchRow(1, "Perception: Remastered"));
    }

    public ArrayList<SearchRow> getSearchRows() {
        return this.titles;
    }
}
