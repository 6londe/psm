package blonde.psm.view.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import blonde.psm.R;
import blonde.psm.model.schema.Title;
import blonde.psm.view.detail.DetailActivity;

public class MainGridAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Title> titleImageList;
    private LayoutInflater inflater;

    MainGridAdapter(Context context, ArrayList<Title> titleImageList) {
        this.mContext = context;
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

        final Title currentTitle = titleImageList.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        SquareImageView imageView = convertView.findViewById(R.id.grid_image);
        imageView.setImageDrawable(
                mContext.getResources().getDrawable(currentTitle.getImage())
        );
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Title", currentTitle);
                mContext.startActivity(intent);
            }
        });

        TextView textView = convertView.findViewById(R.id.grid_text);
        textView.setText(currentTitle.getName());

        return convertView;
    }
}
