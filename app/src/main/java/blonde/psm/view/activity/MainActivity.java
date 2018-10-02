package blonde.psm.view.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import blonde.psm.BuildConfig;
import blonde.psm.R;

public class MainActivity extends AppCompatActivity {

    static SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
