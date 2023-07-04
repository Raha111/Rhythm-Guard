package com.example.rhythym_guard;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {
    @Rule
    public ActivityScenarioRule<HomeActivity> activityScenarioRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void testHomeActivity() {
        onView(withId(R.id.titleTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.graphImageView)).check(matches(isDisplayed()));
        onView(withId(R.id.dataLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.lastSystolicLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.lastDiastolicLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.button5)).check(matches(isDisplayed()));
        onView(withId(R.id.button3)).check(matches(isDisplayed()));
    }

    @Test
    public void testButton5() {
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.add_page)).check(matches(isDisplayed()));
    }

    @Test
    public void testButton3() {
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.view_data_page)).check(matches(isDisplayed()));
    }
}
