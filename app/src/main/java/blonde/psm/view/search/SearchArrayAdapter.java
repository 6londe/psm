package blonde.psm.view.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import blonde.psm.R;

public class SearchArrayAdapter extends ArrayAdapter<SearchRow> {

    private ArrayList<SearchRow> searchRows;

    SearchArrayAdapter(Context context, ArrayList<SearchRow> rows) {
        super(context, R.layout.search_list, rows);
        this.searchRows = rows;
    }

    @Override
    public @NonNull View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.search_row, parent, false);
        }

        ImageView titleImage = view.findViewById(R.id.row_title_image);
        if (titleImage != null) titleImage.setImageResource(searchRows.get(position).getTitleImage());

        TextView titleName = view.findViewById(R.id.row_title_name);
        if (titleName != null)titleName.setText(searchRows.get(position).getTitleName());

        return view;
    }

    @Override
    public @NonNull Filter getFilter() {
        return new SearchFilter(this, searchRows);
    }

}