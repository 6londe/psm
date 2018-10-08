package blonde.psm.view.activity.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;
import blonde.psm.view.custom.CustomAutoCompleteTextView;

public class SearchActivity extends AppCompatActivity {

    private FirebaseWrapper firebaseWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseWrapper = new FirebaseWrapper();

        LinearLayout linearLayout = findViewById(R.id.search_activity_layout);

        int dp = (int) getResources().getDisplayMetrics().density;

        CustomAutoCompleteTextView customAutoCompleteTextView = new CustomAutoCompleteTextView(this);
        customAutoCompleteTextView.setBackground(getResources().getDrawable(R.drawable.custom_search_bar));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40*dp);
        layoutParams.setMargins(10*dp, 15*dp, 10*dp, 10*dp);
        customAutoCompleteTextView.setLayoutParams(layoutParams);
        customAutoCompleteTextView.setPadding(10*dp, 5*dp, 10*dp, 5*dp);
        customAutoCompleteTextView.setMaxLines(1);
        customAutoCompleteTextView.setSingleLine();
        customAutoCompleteTextView.setThreshold(1);
        linearLayout.addView(customAutoCompleteTextView);

        //CustomAutoCompleteTextView searchTextView = findViewById(R.id.title_search);
        customAutoCompleteTextView.setAdapter(new SearchArrayAdapter(this, firebaseWrapper.getSearchRows()));
        customAutoCompleteTextView.requestFocus();

        showKeyboard();
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentFocus();
        if (v != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        }
    }
}