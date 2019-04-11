package com.karangoel16.quotes;

import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(layoutId(), container, false);
        //ButterKnife.bind(this, fragmentView);
        bindView(fragmentView);
        return fragmentView;
    }

    abstract int layoutId();

    @CallSuper
    void bindView(View view){

    }
}
