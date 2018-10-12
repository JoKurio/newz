package io.github.jokurio.newz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EntertainmentNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_news);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new EntertainmentFragment())
                .commit();
    }
}
