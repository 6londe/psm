package blonde.psm.model.helper;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;
import blonde.psm.model.schema.Title;
import blonde.psm.view.search.SearchRow;

public class FirebaseWrapper {

    private ArrayList<Title> titles;
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

        titles = new ArrayList<>();
        titles.add(new Title(Platform.PS4, "WWE 2K19", Genre.ACTION, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "The Surge: The Good, the Bad, and the Augmented", Genre.ARCADE, "Sony", R.drawable.sample_title2));
        titles.add(new Title(Platform.PS4, "Party Crashers", Genre.BOARDGAME, "Sony", R.drawable.sample_title2));
        titles.add(new Title(Platform.PS4, "ACA NeoGeo: Zupapa!", Genre.FIGHTING, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Overcooked! 2: Surf 'n' Turf", Genre.MUSIC, "Sony", R.drawable.sample_title));
    }

    public ArrayList<SearchRow> getSearchRows() {
        return this.searchRows;
    }

    public ArrayList<Title> getTitles() {
        return this.titles;
    }

}
