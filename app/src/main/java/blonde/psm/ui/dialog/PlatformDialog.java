package blonde.psm.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.Dictionary;
import java.util.Hashtable;

import blonde.psm.R;
import blonde.psm.db.DataImporter;
import blonde.psm.enums.Platform;
import blonde.psm.ui.view.PlatformButton;

public class PlatformDialog extends Dialog {

    private static String TAG = PlatformDialog.class.getSimpleName();

    private Context mContext;
    private Dictionary platformButtons;

    public PlatformDialog(final Context context) {

        super(context);

        this.mContext = context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_platform);

        platformButtons = new Hashtable();
        for (Platform platform : Platform.values()) {
            String buttonID = "platform_" + platform.getValue();
            int resID = context.getResources().getIdentifier(buttonID, "id", context.getPackageName());
            platformButtons.put(platform.getValue(), (PlatformButton) findViewById(resID));
        }

        Button platformSelectButton = findViewById(R.id.platform_select);
        platformSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean selected = false;
                for (Platform platform : Platform.values()) {
                    if(((PlatformButton) platformButtons.get(platform.getValue())).isSelectedPlatform()) {
                        importData(platform);
                        selected = true;
                    }
                }
                if(selected) dismiss();
                else Toast.makeText(mContext, "Please select at least one platform", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void importData(Platform platform) {
        DataImporter dataImporter = new DataImporter(mContext);
        if(!dataImporter.importData(platform)) {
            Log.e(TAG, "Failed to import data");
        }
    }
}
