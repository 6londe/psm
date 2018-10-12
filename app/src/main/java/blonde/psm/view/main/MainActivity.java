package blonde.psm.view.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageButton;

import blonde.psm.BuildConfig;
import blonde.psm.R;
import blonde.psm.view.base.BaseActivity;
import blonde.psm.view.search.SearchActivity;

public class MainActivity extends BaseActivity {

    static SharedPreferences sharedPreferences = null;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        View actionBar = getSupportActionBar().getCustomView();
        getSupportActionBar().setElevation(0f);

        ImageButton logoButton = actionBar.findViewById(R.id.actionbar_logo);
        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton searchButton = actionBar.findViewById(R.id.actionbar_search_icon);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        ImageButton settingsButton = actionBar.findViewById(R.id.actionbar_settings_icon);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_frame, new MainGridFragment());
        fragmentTransaction.commit();

        checkFirstRun();
    }

    private void checkFirstRun() {

        final String PREF_NAME = "blonde.psm";
        final String VERSION_CODE = "version_code";
        final int FIRST_RUN = -1;

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        int savedVersionCode = sharedPreferences.getInt(VERSION_CODE, FIRST_RUN);
        int currentVersionCode = BuildConfig.VERSION_CODE;

        if (currentVersionCode == savedVersionCode) {
            // Normal case
            return;
        }
        else if (savedVersionCode == FIRST_RUN) {
            // First run case
            return;
        }
        else if (currentVersionCode > savedVersionCode) {
            // Upgraded case
            return;
        }

        sharedPreferences.edit().putInt(VERSION_CODE, currentVersionCode).apply();
    }
}
