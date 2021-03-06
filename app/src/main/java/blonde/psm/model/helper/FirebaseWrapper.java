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
        titles.add(new Title(Platform.PS4, "WWE 2K19", Genre.SPORTS, "Full Game", R.drawable.sample_wwe_2k19));
        titles.add(new Title(Platform.PS4, "The Surge: The Good, the Bad, and the Augmented", Genre.SHOOTER, "Focus Home Interactive", R.drawable.sample_the_surge_the_good_the_bad_and_the_augmented));
        titles.add(new Title(Platform.PS4, "Party Crashers", Genre.ARCADE, "PSN Game", R.drawable.sample_party_crashers));
        titles.add(new Title(Platform.PS4, "ACA NEOGEO BURNING FIGHT", Genre.ARCADE, "HAMSTER Corporation", R.drawable.sample_aca_neogeo_burning_fight));
        titles.add(new Title(Platform.PS4, "Overcooked! 2: Surf 'n' Turf", Genre.SIMULATION, "Team17 Software Ltd.", R.drawable.sample_overcooked_2_surf_n_turf));
        titles.add(new Title(Platform.PS4, "Mega Man 11", Genre.ACTION, "Capcom U.S.A., Inc.", R.drawable.sample_mega_man_11));
        titles.add(new Title(Platform.VR, "Astro Bot: Rescue Mission", Genre.ADVENTURE, "Sony Interactive Entertainment", R.drawable.sample_astro_bot_rescue_mission));
        titles.add(new Title(Platform.PS4, "Assassin's Creed Odyssey", Genre.FIGHTING, "Ubisoft Entertainment", R.drawable.sample_assassins_creed_odyssey));
        titles.add(new Title(Platform.PS4, "Fist of the North Star: Lost Paradise", Genre.ACTION, "Sega of America Inc.", R.drawable.sample_fist_of_the_north_star_lost_paradise));
        titles.add(new Title(Platform.PS4, "Valthirian Arc: Hero School Story", Genre.ACTION, "PQUBE LTD", R.drawable.sample_valthirian_arc_hero_school_story));
        titles.add(new Title(Platform.PS4, "The Sims 4: Spooky Stuff", Genre.SIMULATION, "Electronic Arts Inc", R.drawable.sample_the_sims_4_spooky_stuff));
        titles.add(new Title(Platform.PS4, "Pilot Sports", Genre.SPORTS, "EuroVideo Medien GmbH", R.drawable.sample_pilot_sports));
        titles.add(new Title(Platform.PS4, "Catastronauts", Genre.ACTION, "INERTIASOFT LIMITED", R.drawable.sample_catastronauts));
        titles.add(new Title(Platform.PS4, "Life is Strange 2", Genre.ADVENTURE, "SQUARE ENIX CO. LTD.", R.drawable.sample_life_is_strange_2));
        titles.add(new Title(Platform.PS4, "DRAGON BALL FIGHTERZ - Goku", Genre.FIGHTING, "BANDAI NAMCO Entertainment America Inc.", R.drawable.sample_dragon_ball_fighterz_goku));
        titles.add(new Title(Platform.PS4, "Perception: Remastered", Genre.ADVENTURE, "The Deep End Games", R.drawable.sample_perception_remastered));
    }

    public ArrayList<Title> getTitles() {
        return this.titles;
    }

}
