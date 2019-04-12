package com.karangoel16.quotes;

public class BasePresenter implements Presenter {

    public interface BaseUI {
        void showError(Exception e);
    }
}
