package com.karangoel16.quotes;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Quotes.getInstance().init(new AutoValue_Quotes_Configuration.Builder()
                .serverUrl(getString(R.string.server))
                .build());
    }
}
