package com.example.rhythym_guard;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class main_itemTest {
    @Rule
    public ActivityScenarioRule<MainActivity2> activityScenarioRule = new ActivityScenarioRule<>(MainActivity2.class);


    @Test
    public void testRecyclerViewVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.rv))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testMain_item() {
        Espresso.onView(ViewMatchers.withId(R.id.rv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.rate))
                .check(ViewAssertions.matches(ViewMatchers.withText("Heart Rate:")));
        Espresso.onView(ViewMatchers.withId(R.id.d_pres))
                .check(ViewAssertions.matches(ViewMatchers.withText("Diastolic Pressure:")));
        Espresso.onView(ViewMatchers.withId(R.id.s_pres))
                .check(ViewAssertions.matches(ViewMatchers.withText("Systolic Pressure:")));
        Espresso.onView(ViewMatchers.withId(R.id.dt))
                .check(ViewAssertions.matches(ViewMatchers.withText("Date:")));
        Espresso.onView(ViewMatchers.withId(R.id.tm))
                .check(ViewAssertions.matches(ViewMatchers.withText("Time:")));
        Espresso.onView(ViewMatchers.withId(R.id.commentLabel))
                .check(ViewAssertions.matches(ViewMatchers.withText("Comment:")));

    }

    @Test
    public void testUpdate(){
        Espresso.onView(ViewMatchers.withId(R.id.rv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.btn1))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn1))
                .perform(ViewActions.click());
    }
    public void testDelete(){
        Espresso.onView(ViewMatchers.withId(R.id.rv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.btn2))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn2))
                .perform(ViewActions.click());
    }


}
