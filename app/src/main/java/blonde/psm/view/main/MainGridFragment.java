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
import java.util.Arrays;

import blonde.psm.R;

public class MainGridFragment extends Fragment {

    private ArrayList<Integer> sampleList;
    private GridView gridView;

    public MainGridFragment() {

        // FIXME Replace sample data
        sampleList = new ArrayList<>(
                Arrays.asList(
                        R.drawable.sample_image_200dp,
                        R.drawable.sample_image_200dp,
                        R.drawable.sample_image_200dp,
                        R.drawable.sample_image_200dp,
                        R.drawable.sample_image_200dp
                )
        );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_gridview, container, false);

        gridView = view.findViewById(R.id.main_grid_view);
        gridView.setAdapter(new MainGridAdapter(getActivity(), sampleList));

        return view;
    }
}
