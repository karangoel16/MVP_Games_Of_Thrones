package com.karangoel16.quotes;

import javax.inject.Inject;

public class QuotesPresenter extends BasePresenter {

    @Inject
    QuotesPresenterUI quotesPresenterUI;

    abstract interface QuotesPresenterUI extends BasePresenter.BaseUI {

    }
}
