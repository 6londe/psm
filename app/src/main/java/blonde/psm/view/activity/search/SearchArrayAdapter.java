package blonde.psm.view.activity.search;

import android.content.Context;
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

    private Context mContext;
    private ArrayList<SearchRow> searchRows, filteredRows, searchRowsAll;

    SearchArrayAdapter(Context context, ArrayList<SearchRow> rows) {
        super(context, android.R.layout.simple_list_item_1, rows);

        this.mContext = context;
        this.searchRows = rows;
        this.filteredRows = new ArrayList<>(rows);
        this.searchRowsAll = new ArrayList<>(rows);
    }

    @Override
    public SearchRow getItem(int position) {
        return searchRows.get(position);
    }

    @Override
    public int getCount() {
        return searchRows.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.search_row, parent, false);

            ImageView titleImage = view.findViewById(R.id.row_title_image);
            if (titleImage != null)
                titleImage.setImageResource(searchRows.get(position).getTitleImage());

            TextView titleName = view.findViewById(R.id.row_title_name);
            if (titleName != null)
                titleName.setText(searchRows.get(position).getTitleName());
        }

        return view;
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter = new Filter() {

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            SearchRow sr = (SearchRow) resultValue;
            return sr.getTitleName();
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            ArrayList<SearchRow> filteredList = (ArrayList<SearchRow>) results.values;

            if (results != null && results.count > 0) {
                clear();

                for (SearchRow sr : filteredList) {
                    add(sr);
                    notifyDataSetChanged();
                }
            }
            else {
                clear();
                notifyDataSetInvalidated();
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults filterResults = new FilterResults();

            if (constraint != null) {

                filteredRows.clear();
                for (SearchRow sr : searchRowsAll) {
                    if (sr.getTitleName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredRows.add(sr);
                    }
                }
                filterResults.values = filteredRows;
                filterResults.count = filteredRows.size();
            }

            return filterResults;
        }
    };
}
