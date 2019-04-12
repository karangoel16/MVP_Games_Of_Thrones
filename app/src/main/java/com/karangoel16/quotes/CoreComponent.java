package com.karangoel16.quotes;

import javax.inject.Inject;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = NetworkModule.class)
public interface CoreComponent {

    void inject(Quotes quotes);

    @Component.Builder
    public static interface Builder {
        @BindsInstance
        public Builder quotes(Quotes quotes);

        public CoreComponent build();
    }
}
