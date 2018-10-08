package blonde.psm.model.helper;

import java.util.ArrayList;

import blonde.psm.view.search.SearchRow;

public class FirebaseWrapper {

    private ArrayList<SearchRow> searchRows;

    public FirebaseWrapper() {

        searchRows = new ArrayList<>();
        searchRows.add(new SearchRow(1, "WWE 2K19"));
        searchRows.add(new SearchRow(1, "The Midnight Sanctuary"));
        searchRows.add(new SearchRow(1, "Party Crashers"));
        searchRows.add(new SearchRow(1, "ACA NeoGeo: Zupapa!"));
        searchRows.add(new SearchRow(1, "Overcooked! 2: Surf 'n' Turf"));
        searchRows.add(new SearchRow(1, "Mega Man 11"));
        searchRows.add(new SearchRow(1, "Astro Bot: Rescue Mission"));
        searchRows.add(new SearchRow(1, "Assassin's Creed Odyssey"));
        searchRows.add(new SearchRow(1, "Fist of the North Star: Lost Paradise"));
        searchRows.add(new SearchRow(1, "Valthirian Arc: Hero School Story"));
        searchRows.add(new SearchRow(1, "The Surge: The Good, the Bad, and the Augmented"));
        searchRows.add(new SearchRow(1, "Racket Fury: Table Tennis VR"));
        searchRows.add(new SearchRow(1, "The Sims 4: Spooky Stuff"));
        searchRows.add(new SearchRow(1, "Pilot Sports"));
        searchRows.add(new SearchRow(1, "Catastronauts"));
        searchRows.add(new SearchRow(1, "Life is Strange 2"));
        searchRows.add(new SearchRow(1, "Dragon Ball FighterZ: Cooler"));
        searchRows.add(new SearchRow(1, "Life is Strange 2: Episode 1 - Roads"));
        searchRows.add(new SearchRow(1, "Dragon Ball FighterZ: Android 17"));
        searchRows.add(new SearchRow(1, "Perception: Remastered"));
    }

    public ArrayList<SearchRow> getSearchRows() {
        return this.searchRows;
    }
}
