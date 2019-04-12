package com.karangoel16.quotes;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class QuotesPresenter extends BasePresenter {

    QuotesPresenterUI quotesPresenterUI;
    Api api;

    @Inject
    QuotesPresenter(QuotesPresenterUI quotesPresenterUI, Api api) {
        this.api = api;
        this.quotesPresenterUI = quotesPresenterUI;
    }

    abstract interface QuotesPresenterUI extends BasePresenter.BaseUI {
        void showQuotes(com.karangoel16.quotes.Response response);
    }

    void init() {
        api.getQuote().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                quotesPresenterUI.showQuotes(response.body());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                quotesPresenterUI.showError(new Exception("Some error occurred"));
            }
        });
    }
}
