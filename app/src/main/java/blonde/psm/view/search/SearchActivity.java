package blonde.psm.view.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;

public class SearchActivity extends AppCompatActivity {

    private FirebaseWrapper firebaseWrapper;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mContext = this;
        firebaseWrapper = new FirebaseWrapper();

        LinearLayout linearLayout = findViewById(R.id.search_activity_layout);
        int dp = (int) getResources().getDisplayMetrics().density;

        SearchAutoCompleteTextView searchAutoCompleteTextView = new SearchAutoCompleteTextView(this, new OnBackPressed() {
            @Override
            public void OnBackPressedCallback() {
                hideKeyboard();
                ((Activity) mContext).onBackPressed();
            }
        });
        searchAutoCompleteTextView.setBackground(getResources().getDrawable(R.drawable.custom_search_bar));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40*dp);
        layoutParams.setMargins(10*dp, 15*dp, 10*dp, 10*dp);
        searchAutoCompleteTextView.setLayoutParams(layoutParams);
        searchAutoCompleteTextView.setPadding(10*dp, 5*dp, 10*dp, 5*dp);
        searchAutoCompleteTextView.setMaxLines(1);
        searchAutoCompleteTextView.setSingleLine();
        searchAutoCompleteTextView.setThreshold(1);
        searchAutoCompleteTextView.setCompoundDrawablePadding(10*dp);
        linearLayout.addView(searchAutoCompleteTextView);

        searchAutoCompleteTextView.setAdapter(new SearchArrayAdapter(this, firebaseWrapper.getSearchRows()));
        searchAutoCompleteTextView.requestFocus();

        showKeyboard();
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentFocus();
        if (v != null) inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view == null) view = new View(this);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public interface OnBackPressed {
        void OnBackPressedCallback();
    }
}