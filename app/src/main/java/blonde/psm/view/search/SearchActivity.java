package blonde.psm.view.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ListView;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;

public class SearchActivity extends AppCompatActivity {

    private SearchArrayAdapter searchArrayAdapter;
    private FirebaseWrapper firebaseWrapper;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mContext = this;
        firebaseWrapper = new FirebaseWrapper();
        searchArrayAdapter = new SearchArrayAdapter(this, firebaseWrapper.getTitles());
        searchArrayAdapter.clear();

        LinearLayout linearLayout = findViewById(R.id.search_activity_layout);
        int dp = (int) getResources().getDisplayMetrics().density;

        final SearchEditText searchEditText = new SearchEditText(this, new OnBackPressed() {
            @Override
            public void OnBackPressedCallback() {
                hideKeyboard();
                ((Activity) mContext).onBackPressed();
            }
        });
        searchEditText.setBackground(getResources().getDrawable(R.drawable.custom_search_bar));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50*dp);
        layoutParams.setMargins(10*dp, 15*dp, 10*dp, 10*dp);
        searchEditText.setLayoutParams(layoutParams);
        searchEditText.setPadding(10*dp, 5*dp, 10*dp, 5*dp);
        searchEditText.setMaxLines(1);
        searchEditText.setSingleLine();
        searchEditText.setCompoundDrawablePadding(10*dp);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (searchEditText.isFocused()) {
                    searchEditText.setDrawables(charSequence.length() > 0);
                }
                searchArrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        linearLayout.addView(searchEditText);
        searchEditText.requestFocus();

        ListView listView = new ListView(this);
        LinearLayout.LayoutParams listViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listViewLayoutParams.setMargins(10*dp, 10*dp, 10*dp, 10*dp);
        listView.setLayoutParams(listViewLayoutParams);
        listView.setAdapter(searchArrayAdapter);
        linearLayout.addView(listView);

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