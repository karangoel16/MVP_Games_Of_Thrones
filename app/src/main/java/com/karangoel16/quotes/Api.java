package com.karangoel16.quotes;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    public static String GET_QUOTES = "quotes";

    @GET(Api.GET_QUOTES)
    public Call<Response> getQuote();
}
