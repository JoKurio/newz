package io.github.jokurio.newz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SportsNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_news);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SportsFragment())
                .commit();
    }
}
