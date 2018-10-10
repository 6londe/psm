package blonde.psm.view.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.main.SquareImageView;
import blonde.psm.view.search.SearchActivity;

public class DetailActivity extends AppCompatActivity {

    private SquareImageView titleImage;
    private TextView titleName, titlePublisher, titleGenre, titlePlatform;
    private ImageView backButton;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        context = this;
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
                context.onBackPressed();
            }
        });
    }
}
