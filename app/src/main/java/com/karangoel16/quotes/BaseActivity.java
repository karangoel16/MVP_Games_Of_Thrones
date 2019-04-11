package com.karangoel16.quotes;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.app.Fragment;

abstract public class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
    }

    abstract int layoutID();

    public void bindFragment(Fragment fragment, int container) {
        this.getFragmentManager().beginTransaction().add(container, fragment).commit();
    }

}
