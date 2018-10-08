package blonde.psm.view.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import blonde.psm.BuildConfig;
import blonde.psm.R;
import blonde.psm.view.base.BaseActivity;

public class MainActivity extends BaseActivity {

    static SharedPreferences sharedPreferences = null;
    private FragmentManager fragmentManager;
    private Boolean isGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_frame, new MainGridFragment());
        fragmentTransaction.commit();
        isGrid = true;

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

    @Override
    public void switchFragment() {

        isGrid = !isGrid;
        Fragment fragment = isGrid ? new MainGridFragment() : new MainListFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
