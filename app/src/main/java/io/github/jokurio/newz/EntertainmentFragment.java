package io.github.jokurio.newz;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EntertainmentFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String LOG_TAG = EntertainmentFragment.class.getSimpleName();


    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.empty_view)
    TextView mEmptyStateTextView;
    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;

    private EntertainmentAdapter adapter;
    private static int LOADER_ID = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);
        ButterKnife.bind(this, view);

        listView.setEmptyView(mEmptyStateTextView);

        adapter = new EntertainmentAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                News news = adapter.getItem(i);
                String url = news.mUrl;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().initLoader(LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

        return view;
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new EntertainmentLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> news) {
        if (news != null) {
            adapter.setNotifyOnChange(false);
            adapter.clear();
            adapter.setNotifyOnChange(true);
            adapter.addAll(news);
        }
        mEmptyStateTextView.setText(R.string.no_data);
        loadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {

    }


}
