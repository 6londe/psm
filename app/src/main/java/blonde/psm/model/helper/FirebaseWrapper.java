package blonde.psm.model.helper;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.enums.Genre;
import blonde.psm.model.enums.Platform;
import blonde.psm.model.schema.Title;

public class FirebaseWrapper {

    private ArrayList<Title> titles;

    public FirebaseWrapper() {

        titles = new ArrayList<>();
        titles.add(new Title(Platform.PS4, "WWE 2K19", Genre.ACTION, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "The Surge: The Good, the Bad, and the Augmented", Genre.ARCADE, "Sony", R.drawable.sample_title2));
        titles.add(new Title(Platform.PS4, "Party Crashers", Genre.BOARDGAME, "Sony", R.drawable.sample_title2));
        titles.add(new Title(Platform.PS4, "ACA NeoGeo: Zupapa!", Genre.FIGHTING, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Overcooked! 2: Surf 'n' Turf", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Mega Man 11", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Astro Bot: Rescue Mission", Genre.MUSIC, "Sony", R.drawable.ic_broken_image_black_24dp));
        titles.add(new Title(Platform.PS4, "Assassin's Creed Odyssey", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Fist of the North Star: Lost Paradise", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Valthirian Arc: Hero School Story", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "The Surge: The Good, the Bad, and the Augmented", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "The Sims 4: Spooky Stuff", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Pilot Sports", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Catastronauts", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Life is Strange 2", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Dragon Ball FighterZ: Cooler", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Life is Strange 2: Episode 1 - Roads", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Dragon Ball FighterZ: Android 17", Genre.MUSIC, "Sony", R.drawable.sample_title));
        titles.add(new Title(Platform.PS4, "Perception: Remastered", Genre.MUSIC, "Sony", R.drawable.sample_title));
    }

    public ArrayList<Title> getTitles() {
        return this.titles;
    }

}
