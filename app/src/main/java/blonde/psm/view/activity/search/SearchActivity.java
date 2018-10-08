package blonde.psm.view.activity.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;

public class SearchActivity extends AppCompatActivity {

    private FirebaseWrapper firebaseWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseWrapper = new FirebaseWrapper();

        AutoCompleteTextView searchTextView = findViewById(R.id.title_search);
        searchTextView.setAdapter(new SearchArrayAdapter(this, firebaseWrapper.getSearchRows()));
        searchTextView.requestFocus();

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