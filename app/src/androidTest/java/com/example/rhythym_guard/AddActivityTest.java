package com.example.rhythym_guard;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddActivityTest {
    @Rule
    public ActivityScenarioRule<AddActivity> activityScenarioRule = new ActivityScenarioRule<>(AddActivity.class);

    @Test
    public void testAddActivityUI() {
        onView(withId(R.id.editTextTextPersonName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName2)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName3)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextMultiLine)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void testAddData() {
        String heartRate = "80";
        String systolicPressure = "120";
        String diastolicPressure = "80";
        String comment = "Test comment";

        onView(withId(R.id.editTextTextPersonName)).perform(typeText(heartRate));
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText(systolicPressure));
        onView(withId(R.id.editTextTextPersonName3)).perform(typeText(diastolicPressure));
        onView(withId(R.id.editTextTextMultiLine)).perform(typeText(comment));
        Espresso.pressBack();
        Espresso.closeSoftKeyboard();

        // Perform click action on the button
        onView(withId(R.id.button)).perform(click());

        // Add assertions to verify the result or navigate to the next activity if applicable
    }
}
