package com.karangoel16.quotes;

import com.google.auto.value.AutoValue;

public class Quotes {

    CoreComponent coreComponent;

    private static final Quotes ourInstance = new Quotes();

    public static Quotes getInstance() {
        return ourInstance;
    }

    private Quotes() {
    }

    public void init(Configuration configuration) {
        coreComponent = DaggerCoreComponent.builder().quotes(this).build();
        coreComponent.inject(this);
    }

    CoreComponent getCoreComponent() {
        return coreComponent;
    }

    @AutoValue
    public static abstract class Configuration {
        abstract String serverUrl();

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract Builder serverUrl(String server);

            public abstract Configuration build();
        }
    }
}
