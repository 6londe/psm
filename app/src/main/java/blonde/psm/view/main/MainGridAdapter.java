package blonde.psm.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import blonde.psm.R;

public class MainGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> titleImageList;
    private LayoutInflater inflater;

    MainGridAdapter(Context context, ArrayList<Integer> titleImageList) {
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

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        imageView.setImageDrawable(context.getResources().getDrawable(titleImageList.get(position)));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        });

        TextView textView = convertView.findViewById(R.id.grid_text);
        textView.setText("ASDF");

        return convertView;
    }
}
