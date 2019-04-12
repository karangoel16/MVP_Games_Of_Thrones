package com.karangoel16.quotes;

import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import dagger.Module;
import dagger.Provides;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.karangoel16.quotes.BasePresenter.BaseUI;

public abstract class BaseFragment extends Fragment implements BaseUI {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(layoutId(), container, false);
        //ButterKnife.bind(this, fragmentView);
        bindView(fragmentView);
        inject();
        return fragmentView;
    }

    abstract int layoutId();

    @CallSuper
    void bindView(View view) {

    }

    abstract void inject();

    public void showError(Exception e) {
        new MaterialDialog.Builder(getContext())
                .title(getString(R.string.error))
                .content(e.getMessage())
                .cancelable(true)
                .show();
    }
}
