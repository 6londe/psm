package blonde.psm.view.search;

import android.widget.Filter;

import java.util.ArrayList;

import blonde.psm.model.schema.Title;

public class SearchFilter extends Filter {

    private SearchArrayAdapter searchArrayAdapter;
    private ArrayList<Title> filteredRows, unfilteredRows;

    SearchFilter(SearchArrayAdapter searchArrayAdapter, ArrayList<Title> titleArrayList) {
        this.searchArrayAdapter = searchArrayAdapter;
        this.filteredRows = new ArrayList<>(titleArrayList);
        this.unfilteredRows = new ArrayList<>(titleArrayList);
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
        Title title = (Title) resultValue;
        return title.getName();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        ArrayList<Title> filteredList = (ArrayList<Title>) results.values;

        if (results.count > 0) {
            searchArrayAdapter.clear();

            for (Title t : filteredList) {
                searchArrayAdapter.add(t);
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

        if (constraint != null && constraint.length() > 0) {

            filteredRows.clear();

            for (Title t : unfilteredRows) {
                if (t.getName().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                    filteredRows.add(t);
                }
            }
            filterResults.values = filteredRows;
            filterResults.count = filteredRows.size();
        }

        return filterResults;
    }
}