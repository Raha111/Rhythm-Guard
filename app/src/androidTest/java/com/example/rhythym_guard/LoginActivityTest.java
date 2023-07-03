package com.example.rhythym_guard;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test

    public void testLoginActivity() {
        onView(withId(R.id.loginpage)).check(matches(isDisplayed()));
        onView(withId(R.id.logo)).check(matches(isDisplayed()));
        onView(withId(R.id.inputPhone2)).check(matches(isDisplayed()));
        onView(withId(R.id.inputPassword2)).check(matches(isDisplayed()));
        onView(withId(R.id.btn2)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));

        String phoneNumber = "01738047196";
        String password = "2970";

        onView(withId(R.id.inputPhone2)).perform(typeText(phoneNumber));
        onView(withId(R.id.inputPassword2)).perform(typeText(password));
        Espresso.pressBack();
        onView(withId(R.id.btn2)).perform(click());
    }

}