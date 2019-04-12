package com.karangoel16.quotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class QuotesFragment extends BaseFragment implements QuotesPresenter.QuotesPresenterUI {

    @BindView(R.id.tv_quote)
    TextView tv_quote;

    @BindView(R.id.tv_author)
    TextView tv_author;

    @BindView(R.id.btn_refresh)
    Button btn_refresh;

    @Inject
    QuotesPresenter quotesPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        quotesPresenter.init();
        return view;
    }

    @OnClick(R.id.btn_refresh)
    void refreshRandom() {
        quotesPresenter.init();
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

    @Override
    public void showQuotes(Response response) {
        tv_quote.setText(response.getQuote());
        tv_author.setText("- " + response.getCharacter());
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
