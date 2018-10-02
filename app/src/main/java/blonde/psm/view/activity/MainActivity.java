package blonde.psm.view.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import blonde.psm.BuildConfig;
import blonde.psm.R;
import blonde.psm.model.helper.SQLiteHelper;
import blonde.psm.view.dialog.PlatformDialog;

public class MainActivity extends AppCompatActivity {

    static SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FIXME : Reset table for test
        SQLiteHelper SQLiteHelper = new SQLiteHelper(this);
        SQLiteHelper.resetTable();

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
            showPlatformDialog();
        }
        else if (currentVersionCode > savedVersionCode) {
            // Upgraded case
            return;
        }

        sharedPreferences.edit().putInt(VERSION_CODE, currentVersionCode).apply();
    }

    private void showPlatformDialog() {

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        PlatformDialog platformDialog = new PlatformDialog(this);
        WindowManager.LayoutParams windowManager = platformDialog.getWindow().getAttributes();
        windowManager.copyFrom(platformDialog.getWindow().getAttributes());
        windowManager.width = width * 3 / 4;
        windowManager.height = height / 2;

        platformDialog.show();
    }
}
