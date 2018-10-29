package blonde.psm.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.helper.FirebaseWrapper;
import blonde.psm.model.schema.Title;

public class MainGridFragment extends Fragment {

    private ArrayList<Title> titleArrayList;
    private GridView gridView;

    public MainGridFragment() {

        FirebaseWrapper firebaseWrapper = new FirebaseWrapper();
        titleArrayList = firebaseWrapper.getTitles();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_gridview, container, false);

        gridView = view.findViewById(R.id.main_grid_view);
        gridView.setAdapter(new MainGridAdapter(getActivity(), titleArrayList));

        return view;
    }
}
