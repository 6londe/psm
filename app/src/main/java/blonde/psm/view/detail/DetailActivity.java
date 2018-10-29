package blonde.psm.view.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.base.BaseActivity;
import blonde.psm.view.main.SquareImageView;

public class DetailActivity extends BaseActivity {

    private SquareImageView titleImage;
    private TextView titleName, titlePublisher, titleGenre, titlePlatform;
    private ImageView backButton;
    private Button editButton;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int dp = (int) getResources().getDisplayMetrics().density;

        activity = this;
        Intent intent = getIntent();
        Title title = intent.getParcelableExtra("Title");

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;

        titleImage = findViewById(R.id.detail_title_image);
        titleName = findViewById(R.id.detail_title_name);
        titlePublisher = findViewById(R.id.detail_title_publisher);
        titleGenre = findViewById(R.id.detail_title_genre);
        titlePlatform = findViewById(R.id.detail_title_platform);

        titleImage.setImageDrawable(getResources().getDrawable(title.getImage()));
        titleImage.getLayoutParams().width = width * 4 / 5;
        titleName.setText(title.getName());
        titlePublisher.setText(title.getPublisher());
        titleGenre.setText(title.getGenre().toString());
        titlePlatform.setText(title.getPlatform().toString());

        backButton = findViewById(R.id.detail_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });

        editButton = findViewById(R.id.detail_edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
