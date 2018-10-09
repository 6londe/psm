package blonde.psm.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.schema.Title;

public class MainGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Title> titleImageList;
    private LayoutInflater inflater;

    MainGridAdapter(Context context, ArrayList<Title> titleImageList) {
        this.context = context;
        this.titleImageList = titleImageList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return this.titleImageList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        GridImageView imageView = convertView.findViewById(R.id.grid_image);
        imageView.setImageDrawable(
                context.getResources().getDrawable(titleImageList.get(position).getImage())
        );
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        });

        TextView textView = convertView.findViewById(R.id.grid_text);
        textView.setText(titleImageList.get(position).getName());

        return convertView;
    }
}
