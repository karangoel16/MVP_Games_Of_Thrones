package com.karangoel16.quotes;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Named("server")
    public String server(Quotes.Configuration configuration) {
        return configuration.serverUrl();
    }

    @Provides
    @Singleton
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient, @Named("server") String server) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(server)
                .build();
    }

    @Provides
    @Singleton
    public Api apiRetroFit(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
