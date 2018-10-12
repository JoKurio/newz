package io.github.jokurio.newz;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportsAdapter extends ArrayAdapter<News> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.section)
    TextView section;

    public SportsAdapter(Context context) {
        super(context, -1, new ArrayList<News>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.generic_layout, parent, false);
        }
        ButterKnife.bind(this, convertView);

        News currentNews = getItem(position);
        title.setText(currentNews.getmTitle());
        author.setText(currentNews.getmAuthor());
        date.setText(currentNews.getmDate());
        section.setText(currentNews.getmSection());

        return convertView;
    }
}




