package com.karangoel16.quotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class QuotesFragment extends BaseFragment {

    @BindView(R.id.textView)
    TextView text_input;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }

    public static QuotesFragment getInstance() {
        return new QuotesFragment();
    }

    @Override
    int layoutId() {
        return R.layout.quotes_fragment;
    }

    @Override
    void bindView(View view) {
        super.bindView(view);
    }
}
