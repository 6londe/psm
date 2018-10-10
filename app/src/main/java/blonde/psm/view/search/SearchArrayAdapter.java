package blonde.psm.view.search;

import android.content.Context;
import android.content.Intent;
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
import blonde.psm.model.schema.Title;
import blonde.psm.view.detail.DetailActivity;

public class SearchArrayAdapter extends ArrayAdapter<Title> {

    private ArrayList<Title> titleArrayList;
    private Context mContext;

    SearchArrayAdapter(Context context, ArrayList<Title> rows) {
        super(context, R.layout.search_list, rows);
        mContext = context;
        this.titleArrayList = rows;
    }

    @Override
    public @NonNull View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) view = LayoutInflater.from(getContext()).inflate(R.layout.search_row, parent, false);

        final Title currentTitle = titleArrayList.get(position);

        ImageView titleImage = view.findViewById(R.id.row_title_image);
        if (titleImage != null) titleImage.setImageResource(currentTitle.getImage());

        TextView titleName = view.findViewById(R.id.row_title_name);
        if (titleName != null) {
            titleName.setText(currentTitle.getName());
            titleName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("Title", currentTitle);
                    mContext.startActivity(intent);
                }
            });
        }

        return view;
    }

    @Override
    public @NonNull Filter getFilter() {
        return new SearchFilter(this, titleArrayList);
    }

}
