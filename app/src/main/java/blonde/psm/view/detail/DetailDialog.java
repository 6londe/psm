package blonde.psm.view.detail;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.main.SquareImageView;

public class DetailDialog extends Dialog {

    private SquareImageView titleImage;
    private TextView titleName, titlePublisher, titleGenre, titlePlatform;

    public DetailDialog(final Context context, Title title, int width) {

        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_detail);

        titleImage = findViewById(R.id.detail_title_image);
        titleName = findViewById(R.id.detail_title_name);
        titlePublisher = findViewById(R.id.detail_title_publisher);
        titleGenre = findViewById(R.id.detail_title_genre);
        titlePlatform = findViewById(R.id.detail_title_platform);

        titleImage.setImageDrawable(context.getResources().getDrawable(title.getImage()));
        titleImage.getLayoutParams().width = width * 4 / 5;
        titleName.setText(title.getName());
        titlePublisher.setText(title.getPublisher());
        titleGenre.setText(title.getGenre().toString());
        titlePlatform.setText(title.getPlatform().toString());
    }
}
