package blonde.psm.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import blonde.psm.R;
import blonde.psm.db.DatabaseHelper;
import blonde.psm.ui.dialog.PlatformDialog;

public class MainActivity extends AppCompatActivity {

    private PlatformDialog platformDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FIXME : Reset table for test
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.resetTable();

        showPlatformDialog();
    }

    private void showPlatformDialog() {

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        platformDialog = new PlatformDialog(this);
        WindowManager.LayoutParams windowManager = platformDialog.getWindow().getAttributes();
        windowManager.copyFrom(platformDialog.getWindow().getAttributes());
        windowManager.width = width * 3 / 4;
        windowManager.height = height / 2;

        platformDialog.show();
    }
}
