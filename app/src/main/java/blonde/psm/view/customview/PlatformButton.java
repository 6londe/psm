package blonde.psm.view.customview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

public class PlatformButton extends AppCompatButton {

    private boolean selectedPlatform = false;

    public PlatformButton(Context context) {
        this(context, (AttributeSet)null);
    }

    public PlatformButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlatformButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPlatform = !selectedPlatform;
                if(selectedPlatform) v.setBackgroundColor(Color.RED);
                else v.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public boolean isSelectedPlatform() {
        return selectedPlatform;
    }
}
