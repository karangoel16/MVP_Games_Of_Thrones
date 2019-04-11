package com.karangoel16.quotes;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindFragment(QuotesFragment.getInstance(), R.id.fragment_container);
    }

    @Override
    int layoutID() {
        return R.layout.main_activity;
    }
}
