package blonde.psm.view.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import blonde.psm.R;
import blonde.psm.service.FirebaseWrapper;
import blonde.psm.view.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    private FirebaseWrapper firebaseWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseWrapper = new FirebaseWrapper();

        AutoCompleteTextView searchTextView = findViewById(R.id.title_search);
        searchTextView.setAdapter(new ArrayAdapter<>(
            this, android.R.layout.simple_dropdown_item_1line,
            firebaseWrapper.getTitles().toArray(new String[0]))
        );
    }

}