package com.karangoel16.quotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class QuotesFragment extends BaseFragment implements QuotesPresenter.QuotesPresenterUI {

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

    @Override
    void inject() {
        DaggerQuotesFragment_Component.builder()
                .module(new QuotesFragment.Module(this))
                .coreComponent(Quotes.getInstance().getCoreComponent())
                .build().inject(this);
    }

    @FragmentScope
    @dagger.Component(modules = QuotesFragment.Module.class, dependencies = CoreComponent.class)
    interface Component {
        public void inject(QuotesFragment quotesFragment);
    }

    @dagger.Module
    static class Module {
        QuotesFragment quotesFragment;

        Module(QuotesFragment quotesFragment) {
            this.quotesFragment = quotesFragment;
        }

        @Provides
        @FragmentScope
        public QuotesPresenter.QuotesPresenterUI provideQuotesFragment() {
            return quotesFragment;
        }

    }
}
