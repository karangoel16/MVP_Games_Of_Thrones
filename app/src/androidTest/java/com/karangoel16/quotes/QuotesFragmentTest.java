package com.karangoel16.quotes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4ClassRunner.class)
public class QuotesFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void beforeTest() {
        mainActivityActivityTestRule.getActivity().getFragmentManager().beginTransaction();
    }

    @Test
    public void Test() {
        onView(ViewMatchers.withId(R.id.cl_quotes_fragment)).perform(click());
    }
}
