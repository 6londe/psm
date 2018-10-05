package blonde.psm.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import blonde.psm.R;
import blonde.psm.service.FirebaseWrapper;

public class CreateDialog extends Dialog {

    private static String TAG = CreateDialog.class.getSimpleName();

    private Context mContext;
    private FirebaseWrapper firebaseWrapper;

    public CreateDialog(final Context context) {

        super(context);
        this.mContext = context;
        firebaseWrapper = new FirebaseWrapper();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_create);

        AutoCompleteTextView edit = (AutoCompleteTextView) findViewById(R.id.title_search);

        edit.setAdapter(new ArrayAdapter<String>(
                mContext,android.R.layout.simple_dropdown_item_1line,
                firebaseWrapper.getTitles().toArray(new String[0]))
        );
    }
}
