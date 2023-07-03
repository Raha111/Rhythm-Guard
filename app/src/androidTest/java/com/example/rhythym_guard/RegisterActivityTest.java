package com.example.rhythym_guard;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import android.annotation.SuppressLint;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class RegisterActivityTest {
    @Rule
    public ActivityScenarioRule<RegisterActivity> activityScenarioRule =
            new ActivityScenarioRule<>(RegisterActivity.class);

    @Test
    @SuppressLint("InlinedApi")
    public void testRegisterActivity() {

        onView(withId(R.id.registerpage)).check(matches(isDisplayed()));
        onView(withId(R.id.logo)).check(matches(isDisplayed()));
        onView(withId(R.id.inputUsername)).check(matches(isDisplayed()));
        onView(withId(R.id.inputEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.inputPhone2)).check(matches(isDisplayed()));
        onView(withId(R.id.inputPassword2)).check(matches(isDisplayed()));
        onView(withId(R.id.inputConfirmPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));

        String name = "Rafi";
        String email = "rafi@gmail.com";
        String phone = "1234567890";
        String password = "rafi";

        onView(withId(R.id.inputUsername)).perform(typeText(name));
        onView(withId(R.id.inputEmail)).perform(typeText(email));
        onView(withId(R.id.inputPhone2)).perform(typeText(phone));
        onView(withId(R.id.inputPassword2)).perform(typeText(password));
        Espresso.pressBack();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.inputConfirmPassword)).perform(typeText(password));
        Espresso.pressBack();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnRegister)).perform(click());
        onView(withId(R.id.loginpage)).check(matches(isDisplayed()));
    }

}