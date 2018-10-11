package blonde.psm.view.search;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.detail.DetailActivity;
import blonde.psm.view.main.SquareImageView;

public class SearchArrayAdapter extends ArrayAdapter<Title> {

    private ArrayList<Title> titleArrayList;
    private Context context;
    private SearchFilter searchFilter;

    SearchArrayAdapter(Context context, ArrayList<Title> titleArrayList) {
        super(context, R.layout.search_list, titleArrayList);
        this.context = context;
        this.titleArrayList = titleArrayList;
        this.searchFilter = new SearchFilter(this, titleArrayList);
    }

    @Override
    public @NonNull View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) view = LayoutInflater.from(getContext()).inflate(R.layout.search_row, parent, false);

        final Title currentTitle = titleArrayList.get(position);

        TextView titleName = view.findViewById(R.id.row_title_name);
        if (titleName != null) titleName.setText(currentTitle.getName());

        SquareImageView titleImage = view.findViewById(R.id.row_title_image);
        if (titleImage != null) titleImage.setImageResource(currentTitle.getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Title", currentTitle);
                context.startActivity(intent);
                ((SearchActivity) context).hideKeyboard();
            }
        });

        return view;
    }

    @Override
    public @NonNull Filter getFilter() {
        return this.searchFilter;
    }

}
