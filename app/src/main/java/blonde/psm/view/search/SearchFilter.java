package blonde.psm.view.search;

import android.widget.Filter;

import java.util.ArrayList;

public class SearchFilter extends Filter {

    private SearchArrayAdapter searchArrayAdapter;
    private ArrayList<SearchRow> filteredRows, unfilteredRows;

    SearchFilter(SearchArrayAdapter searchArrayAdapter, ArrayList<SearchRow> rows) {
        this.searchArrayAdapter = searchArrayAdapter;
        this.filteredRows = new ArrayList<>(rows);
        this.unfilteredRows = new ArrayList<>(rows);
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
        SearchRow sr = (SearchRow) resultValue;
        return sr.getTitleName();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        ArrayList<SearchRow> filteredList = (ArrayList<SearchRow>) results.values;

        if (results.count > 0) {
            searchArrayAdapter.clear();

            for (SearchRow sr : filteredList) {
                searchArrayAdapter.add(sr);
            }
            searchArrayAdapter.notifyDataSetChanged();
        }
        else {
            searchArrayAdapter.clear();
            searchArrayAdapter.notifyDataSetInvalidated();
        }
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults filterResults = new FilterResults();

        if (constraint != null) {

            filteredRows.clear();

            for (SearchRow sr : unfilteredRows) {
                if (sr.getTitleName().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                    filteredRows.add(sr);
                }
            }
            filterResults.values = filteredRows;
            filterResults.count = filteredRows.size();
        }

        return filterResults;
    }
}