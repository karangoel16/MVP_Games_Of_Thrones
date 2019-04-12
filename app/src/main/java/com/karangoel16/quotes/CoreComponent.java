package com.karangoel16.quotes;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface CoreComponent {

    void inject(Quotes quotes);

    Api api();

    @Component.Builder
    public static interface Builder {

        @BindsInstance
        public Builder configuration(Quotes.Configuration configuration);

        public CoreComponent build();
    }
}
