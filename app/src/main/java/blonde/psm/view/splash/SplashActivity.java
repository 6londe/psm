package blonde.psm.view.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import blonde.psm.R;
import blonde.psm.view.base.BaseActivity;
import blonde.psm.view.main.MainActivity;

public class SplashActivity extends BaseActivity {

    private static final int SPLASH_TIMEOUT = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}