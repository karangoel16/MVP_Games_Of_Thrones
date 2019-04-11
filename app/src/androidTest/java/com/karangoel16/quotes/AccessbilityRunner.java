package com.karangoel16.quotes;

import androidx.test.espresso.accessibility.AccessibilityChecks;
import androidx.test.runner.AndroidJUnitRunner;

public class AccessbilityRunner extends AndroidJUnitRunner {
    static {
        AccessibilityChecks.enable().setRunChecksFromRootView(true);
    }
}
