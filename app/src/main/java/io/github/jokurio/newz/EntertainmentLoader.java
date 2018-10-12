package io.github.jokurio.newz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class EntertainmentLoader extends AsyncTaskLoader<List<News>> {
    private static final String LOG_TAG = EntertainmentFragment.class.getSimpleName();

    public EntertainmentLoader(@NonNull Context context) {
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
            URL url = EntertainmentUtils.createUrl();
            String jsonResponse = EntertainmentUtils.makeHttpRequest(url);
            newsList = EntertainmentUtils.extractFeatureFromJson(jsonResponse);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error Loader LoadInBackground: ", e);
        }
        return newsList;
    }
}
