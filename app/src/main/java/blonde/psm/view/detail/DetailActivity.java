package blonde.psm.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.main.SquareImageView;

public class DetailActivity extends AppCompatActivity {

    private SquareImageView titleImage;
    private TextView titleName, titlePublisher, titleGenre, titlePlatform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Title title = intent.getParcelableExtra("Title");

        titleImage = findViewById(R.id.detail_title_image);
        titleName = findViewById(R.id.detail_title_name);
        titlePublisher = findViewById(R.id.detail_title_publisher);
        titleGenre = findViewById(R.id.detail_title_genre);
        titlePlatform = findViewById(R.id.detail_title_platform);

        titleImage.setImageDrawable(getResources().getDrawable(title.getImage()));
        //titleImage.getLayoutParams().width = width * 4 / 5;
        titleName.setText(title.getName());
        titlePublisher.setText(title.getPublisher());
        titleGenre.setText(title.getGenre().toString());
        titlePlatform.setText(title.getPlatform().toString());
    }
}
