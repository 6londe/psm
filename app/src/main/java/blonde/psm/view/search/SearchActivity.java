package blonde.psm.view.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;
import blonde.psm.view.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    private SearchArrayAdapter searchArrayAdapter;
    private FirebaseWrapper firebaseWrapper;
    private Activity activity;

    private TextView emptyView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        activity = this;
        firebaseWrapper = new FirebaseWrapper();
        searchArrayAdapter = new SearchArrayAdapter(this, firebaseWrapper.getTitles());
        searchArrayAdapter.clear();

        LinearLayout linearLayout = findViewById(R.id.search_activity_layout);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        int dp = (int) getResources().getDisplayMetrics().density;

        final SearchEditText searchEditText = new SearchEditText(this, new OnBackPressed() {
            @Override
            public void OnBackPressedCallback() {
                hideKeyboard();
                activity.onBackPressed();
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
        searchEditText.setHint(R.string.search_edittext_hint);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (searchEditText.isFocused()) {
                    searchEditText.setDrawables(charSequence.length() > 0);
                }
                searchArrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        searchEditText.requestFocus();

        listView = new ListView(this);
        LinearLayout.LayoutParams listViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listViewLayoutParams.setMargins(10*dp, 10*dp, 10*dp, 10*dp);
        listView.setLayoutParams(listViewLayoutParams);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setAdapter(searchArrayAdapter);

        emptyView = new TextView(this);
        LinearLayout.LayoutParams emptyViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        emptyViewLayoutParams.setMargins(10*dp, 40*dp, 10*dp, 10*dp);
        emptyView.setPadding(13*dp, 5*dp, 13*dp, 5*dp);
        emptyView.setLayoutParams(emptyViewLayoutParams);
        emptyView.setText(getResources().getString(R.string.search_add_button));
        emptyView.setTextColor(getResources().getColor(R.color.colorAccent));
        emptyView.setBackground(getDrawable(R.drawable.custom_rounded_button));
        emptyView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        emptyView.setVisibility(View.GONE);
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linearLayout.addView(searchEditText);
        linearLayout.addView(emptyView);
        listView.setEmptyView(emptyView);
        linearLayout.addView(listView);

        showKeyboard();
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentFocus();
        if (v != null && inputMethodManager != null) inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view == null) view = new View(this);
        if (inputMethodManager != null) inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public interface OnBackPressed {
        void OnBackPressedCallback();
    }
}