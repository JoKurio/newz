package io.github.jokurio.newz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import android.util.Log;


public class SportsLoader extends AsyncTaskLoader<List<News>> {
    private static final String LOG_TAG = SportsFragment.class.getSimpleName();

    public SportsLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        List<News> newsList = null;
        try {
            URL url = SportsUtils.createUrl();
            String jsonResponse = SportsUtils.makeHttpRequest(url);
            newsList = SportsUtils.extractFeatureFromJson(jsonResponse);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error Loader LoadInBackground: ", e);
        }
        return newsList;
    }
}
